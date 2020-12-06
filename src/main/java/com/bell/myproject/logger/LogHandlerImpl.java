package com.bell.myproject.logger;

import com.bell.myproject.service.math.MathHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogHandlerImpl implements LogHandler{
    private Logger logger;

    public LogHandlerImpl(MathHelper helper) {
        this.logger = LoggerFactory.getLogger(LogHandlerImpl.class);
        
    }

    public void logInfo(String msg, String uuid) {
        logger.info(uuid+ " " + msg);
    };

    @Override
    public void logError(String msg, String uuid) {
        logger.error(uuid + " " + msg);
    }

    @Override
    public void logWarn(String msg, String uuid) {
        logger.warn(uuid + " " + msg);
    }
}
