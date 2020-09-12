package dev.paie.utils.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import dev.paie.service.EmployeService;

public final class LoggerUtils {

	public static Logger getLOG(Class<?> className) {
        return LoggerFactory.getLogger(className.getClass());

	}
}
