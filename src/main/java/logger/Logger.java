package logger;

import java.time.LocalDateTime;

public class Logger {
    private String loggerName;
    private LoggerConfig loggerConfig;

    public Logger(String loggerName, LoggerConfig loggerConfig) {
        this.loggerName = loggerName;
        this.loggerConfig = loggerConfig;
    }

    public void log(LogLevel level, String message) {
        if(level.getLevel() < loggerConfig.getMinLevel().getLevel()){
            return;
        }

        LogMessage logMessage = new LogMessage(level, message);

        for(Appender appender : loggerConfig.getAppenders()){
            appender.append(logMessage);
        }
    }

    public void info(String message){
        log(LogLevel.INFO, message);
    }

    public void error(String message){
        log(LogLevel.ERROR, message);
    }
}
