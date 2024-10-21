package com.hdbank.common.log.utils;

import lombok.NoArgsConstructor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class LoggerPool {

    public static Logger json = LogManager.getLogger("JSON");
}
