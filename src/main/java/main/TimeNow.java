package main;

import java.time.LocalDateTime;

public class TimeNow implements Runnable{
    private static LocalDateTime timeNow;

    @Override
    public void run() {
        while (true) {
            timeNow = LocalDateTime.now();
        }
    }

    public static LocalDateTime getTimeNow() {
        return timeNow;
    }
}
