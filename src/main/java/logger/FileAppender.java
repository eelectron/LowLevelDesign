package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements Appender {
    private final BufferedWriter bufferedWriter;
    private final Formatter formatter;

    public FileAppender(String filePath, Formatter formatter) throws IOException {
        this.bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
        this.formatter = formatter;
    }

    @Override
    public synchronized void append(LogMessage message) {
        try {
            bufferedWriter.write(formatter.format(message));
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
