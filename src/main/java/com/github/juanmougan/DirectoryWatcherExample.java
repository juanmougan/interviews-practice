package com.github.juanmougan;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class DirectoryWatcherExample {

  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("Starting the WatchService");
    WatchService watchService
        = FileSystems.getDefault().newWatchService();

    Path path = Paths.get(System.getProperty("user.home"));

    path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

    WatchKey key;
    while ((key = watchService.take()) != null) {
      for (WatchEvent<?> event : key.pollEvents()) {
        System.out.println(
            "Event kind:" + event.kind()
                + ". File affected: " + event.context() + ".");
      }
      key.reset();
    }
    System.out.println("Finished");
  }
}
