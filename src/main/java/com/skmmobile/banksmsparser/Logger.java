package com.skmmobile.banksmsparser;

public interface Logger {
    Logger DUMMY = new Logger() {
        @Override
        public void debug(String msg) {

        }
    };

    void debug(String msg);
}
