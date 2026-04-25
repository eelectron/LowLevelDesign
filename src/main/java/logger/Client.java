package logger;

import java.io.IOException;
import java.util.List;

public class Client {
    public static void main(String[] args) throws IOException {
        Formatter formatter = new SimpleFormatter();
        Appender consoleAppender = new ConsoleAppender(formatter);
        Appender fileAppender = new FileAppender("app.log", formatter);
        Appender aysnAppender = new AsynAppender(fileAppender);

        LoggerConfig loggerConfig = new LoggerConfig(LogLevel.INFO, List.of(consoleAppender, aysnAppender));

        LoggerFactory.setConfig(loggerConfig);
        Logger logger = LoggerFactory.getLogger("MyApp");
        logger.info("Application started");
        logger.info("Logger Low Level Design Demo");
        logger.error("Application error");
    }
}
