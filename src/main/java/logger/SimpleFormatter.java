package logger;

public class SimpleFormatter implements Formatter {
    @Override
    public String format(LogMessage message) {
        return message.getTimestamp() + " [" + message.getLevel() + "] "
                + message.getThreadName() + " - " + message.getMessage();
    }
}
