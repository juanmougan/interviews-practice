package com.github.juanmougan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableScheduling
public class TaskSchedulingExample {

  public static void main(String[] args) {
    SpringApplication.run(TaskSchedulingExample.class);
  }

  @Component
  public static class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTime() {
      int sleep = getRandom();
      log.info("Sleeping the Thread for {} milliseconds", sleep);
      try {
        Thread.sleep(sleep);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      log.info("The time is now {}", dateFormat.format(new Date()));
    }

    private int getRandom() {
      Random r = new Random();
      int lowerBound = 1000;
      int upperBound = 10000;
      return r.nextInt(upperBound-lowerBound) + lowerBound;
    }
  }

}
