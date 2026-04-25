package logger;

import java.util.List;

public class LoggerConfig {
    private LogLevel minLevel;
    private List<Appender> appenders;

    public LoggerConfig(LogLevel minLevel,  List<Appender> appenders) {
        this.minLevel = minLevel;
        this.appenders = appenders;
    }

    public LogLevel getMinLevel() {
        return minLevel;
    }

    public List<Appender> getAppenders() {
        return appenders;
    }
}
