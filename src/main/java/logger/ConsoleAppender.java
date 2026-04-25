package logger;

public class ConsoleAppender implements Appender {
    private final Formatter formatter;

    public  ConsoleAppender(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void append(LogMessage message) {
        System.out.println(formatter.format(message));
    }
}
