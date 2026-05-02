package job_scheduler;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ScheduledJob implements Delayed {
    private Job job;
    private long scheduledTime;

    public ScheduledJob(Job job, long scheduledTime) {
        this.job = job;
        this.scheduledTime = scheduledTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(scheduledTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(scheduledTime, ((ScheduledJob)o).scheduledTime);
    }

    public Job getJob() {
        return job;
    }

    public long getScheduledTime() {
        return scheduledTime;
    }
}
