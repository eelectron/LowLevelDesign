package logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoggerFactory {
    private static Map<String, Logger> loggers = new ConcurrentHashMap<>();
    private static LoggerConfig globalConfig;


    public static Logger getLogger(String loggerName) {
        Logger logger = loggers.computeIfAbsent(loggerName, n -> new Logger(n, globalConfig));
        return logger;
    }

    public static void setConfig(LoggerConfig config){
        globalConfig = config;
    }
}
