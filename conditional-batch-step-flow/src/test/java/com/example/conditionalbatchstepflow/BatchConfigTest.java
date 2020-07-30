package com.example.conditionalbatchstepflow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.*;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.example.conditionalbatchstepflow.BatchConfig.PARAM_NAME;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBatchTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BatchConfig.class, MyDecider.class})
@MockBean(JobRepositoryTestUtils.class)
class BatchConfigTest {
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private Job job;

    @BeforeEach
    void initJobLauncherTestUtils() {
        jobLauncherTestUtils.setJob(job);
    }

    @Test
    void shouldWorkWithParamOne() throws Exception {
        startJobWithParam(1L);
    }

    @Test
    void shouldWorkWithParamTwo() throws Exception {
        startJobWithParam(2L);
    }

    private void startJobWithParam(long param) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong(PARAM_NAME, param)
                .toJobParameters();

        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
        assertThat(jobExecution.getExitStatus())
                .isEqualTo(ExitStatus.COMPLETED);
    }
}