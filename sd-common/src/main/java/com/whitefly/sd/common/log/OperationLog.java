package com.whitefly.sd.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 操作日志归档
 */
public class OperationLog {

    static Logger logger = LoggerFactory.getLogger("operation_log");

    public static void info(String classPath, String className, String user, String paramJson) {
        logger.info("{}|{}|{} , {}", classPath, className, user, paramJson);
    }


}
