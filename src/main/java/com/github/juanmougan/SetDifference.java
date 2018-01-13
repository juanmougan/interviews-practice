package com.github.juanmougan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given two really big sets, say, 10 million and 1 million element each,
 * calculate its difference.
 */
public class SetDifference {

    public void difference(String big, String small, String output) {
        Set<String> smallSet;
        Set<String> outputSet;
        try {
            // Read all lines from a file as a Stream. Bytes from the file are decoded into characters using the UTF-8 charset
            smallSet = Files.lines(Paths.get(small)).collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //read file into stream, try-with-resources
        try (Stream<String> bigStream = Files.lines(Paths.get(big))) {
            outputSet = bigStream.filter(bigLine -> !smallSet.contains(bigLine)).collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Write Stream to file
        try {
            Files.write(Paths.get(output), (Iterable<String>)outputSet.stream()::iterator);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        new SetDifference().difference("big.csv", "small.csv", "output.csv");
    }
}
