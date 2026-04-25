package logger;

public enum LogLevel {
    DEBUG(1), INFO(2),  WARN(3), ERROR(4), FATAL(5);
    private int level;
    LogLevel(int level) {}
    public int getLevel() {
        return level;
    }
}
