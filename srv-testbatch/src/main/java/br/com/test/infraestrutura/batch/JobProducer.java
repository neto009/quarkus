package br.com.test.infraestrutura.batch;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.ws.rs.Produces;
import org.jberet.job.model.Job;
import org.jberet.job.model.JobBuilder;
import org.jberet.job.model.Step;
import org.jberet.job.model.StepBuilder;

@ApplicationScoped
public class JobProducer {

    @Produces
    @Named
    public Job job() {
        return new JobBuilder("job")
                .step(this.step())
                .build();
    }

    private Step step() {
        return new StepBuilder("step")
                .batchlet("meuBatchlet")
                .build();
    }
}
