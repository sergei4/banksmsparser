package com.skmmobile.banksmsparser;

public class ConsoleLogger implements Logger {
    @Override
    public void debug(String msg) {
        System.out.println(msg);
    }
}
