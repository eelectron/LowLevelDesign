package job_scheduler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobScheduler {
    private DelayQueue<ScheduledJob> delayQueue = new DelayQueue<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private Map<String, Job> jobStore = new ConcurrentHashMap<>();

    public void submit(Job job){
        jobStore.put(job.getJobId(), job);
        delayQueue.offer(new ScheduledJob(job, job.getScheduledTime()));
    }

    public void start(){
        while(true){
            try {
                ScheduledJob scheduledJob = delayQueue.take();
                execute(scheduledJob.getJob());
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }

    private void execute(Job job){
        executorService.execute(() -> runJob(job));
    }

    private void runJob(Job job){
        if(job.getStatus() == JobStatus.CANCELLED){
            return;
        }

        job.setStatus(JobStatus.RUNNING);

        try{
            Runnable task = job.getTask();
            task.run();
            job.setStatus(JobStatus.SUCCESS);
        }catch (Exception ex){
            handleFailure(job);
        }

    }

    private void handleFailure(Job job) {
        if(job.getRetryCount() >= job.getMaxRetires()){
            job.setStatus(JobStatus.FAILED);
        }
        else{
            job.setRetryCount(job.getRetryCount()+1);
            job.setStatus(JobStatus.PENDING);

            long backoff = (long)Math.pow(2, job.getRetryCount()) * 1000;
            job.setScheduledTime(System.currentTimeMillis() + backoff);
            delayQueue.offer(new ScheduledJob(job, job.getScheduledTime()));
        }
    }

    public void cancelJob(String jobId) {
        Job job = jobStore.get(jobId);
        if (job != null) {
            job.setStatus(JobStatus.CANCELLED);
        }
    }
}
