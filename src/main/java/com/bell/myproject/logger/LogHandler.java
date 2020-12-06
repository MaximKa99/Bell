package com.bell.myproject.logger;

public interface LogHandler {

    void logInfo(String msg, String uuid);

    void logError(String msg, String uuid);

    void logWarn(String msg, String uuid);
}
