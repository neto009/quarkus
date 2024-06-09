package br.com.test.infraestrutura.batch;

import io.quarkiverse.jberet.runtime.QuarkusJobOperator;
import jakarta.batch.runtime.JobExecution;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.jberet.job.model.Job;

import java.util.Properties;

@Slf4j
@ApplicationScoped
public class BatchImpl implements Batch {

    private final Job job;

    @Inject
    QuarkusJobOperator jobOperator;

    public BatchImpl(final Job job) {
        this.job = job;
    }
    @Override
    public void execute() {
        long executionId = jobOperator.start(job, new Properties());
        final JobExecution jobExecution = jobOperator.getJobExecution(executionId);
        log.info("Job execution started: {}", jobExecution.toString());
    }
}
