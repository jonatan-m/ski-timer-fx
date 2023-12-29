package com.gr7.skitimer;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public class Timer {
    private LocalTime startTime;

    public Timer() {
        this.startTime = LocalTime.now();
    }

    public LocalTime stopTimer() {
        LocalTime currentTime = LocalTime.now();
        long diff = this.startTime.until(currentTime, ChronoUnit.NANOS);

        if (diff < 0) {
            long dayInNanos = (long) 24 * 60 * 60 * 1000000000;
            diff += dayInNanos;
        }

        return LocalTime.ofNanoOfDay(diff);
    }

    public LocalTime getTime() {
        return LocalTime.now();
    }
}
