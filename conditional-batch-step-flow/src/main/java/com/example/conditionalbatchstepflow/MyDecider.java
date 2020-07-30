package com.example.conditionalbatchstepflow;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.stereotype.Component;

import static com.example.conditionalbatchstepflow.BatchConfig.PARAM_NAME;

@Component
public class MyDecider implements JobExecutionDecider {
    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        JobParameters jobParameters = jobExecution.getJobParameters();
        Long param = jobParameters.getLong(PARAM_NAME);
        String status = param != null && param == 1 ? "1" : "2";
        return new FlowExecutionStatus(status);
    }
}
