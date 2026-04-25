package logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AsynAppender implements Appender{
    private final BlockingQueue<LogMessage> queue = new LinkedBlockingQueue<>();
    private final Appender delegate;

    public AsynAppender(Appender delegate) {
        this.delegate = delegate;

        new Thread(() -> {
            while (true) {
                LogMessage msg = null;
                try {
                    msg = queue.take();
                    delegate.append(msg);
                } catch (InterruptedException e) {
                    // ignored exception
                }
            }
        }).start();
    }

    @Override
    public void append(LogMessage message) {
        queue.offer(message);
    }
}
