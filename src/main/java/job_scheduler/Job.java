package job_scheduler;

public class Job {
    private String jobId;
    private Runnable task;
    private JobStatus status;
    private long scheduledTime;
    private int retryCount;
    private int maxRetires;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Runnable getTask() {
        return task;
    }

    public void setTask(Runnable task) {
        this.task = task;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public long getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(long scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public int getMaxRetires() {
        return maxRetires;
    }

    public void setMaxRetires(int maxRetires) {
        this.maxRetires = maxRetires;
    }
}
