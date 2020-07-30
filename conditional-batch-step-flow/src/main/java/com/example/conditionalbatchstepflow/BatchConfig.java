package com.example.conditionalbatchstepflow;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    static final String PARAM_NAME = "PARAM";

    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    private Tasklet createTaskletWithText(String text) {
        return (stepContribution, chunkContext) -> {
            System.out.println(text);
            return RepeatStatus.FINISHED;
        };
    }

    private Step createStep(String text) {
        return stepBuilderFactory
                .get("STEP-" + text)
                .tasklet(createTaskletWithText(text))
                .build();
    }

    @Bean
    Flow startFlow(MyDecider decider) {
        return new FlowBuilder<SimpleFlow>("startFlow")
                .start(createStep("Step A"))
                .next(decider).on("1").to(
                        createStep("Step B1")
                )
                .from(decider).on("2").to(createStep("Step B2"))
                .end();
    }

    @Bean
    Job job(Flow startFlow) {
        return jobBuilderFactory
                .get("job")
                .start(startFlow)
                .next(createStep("Step C"))
                .end()
                .build();
    }
}
