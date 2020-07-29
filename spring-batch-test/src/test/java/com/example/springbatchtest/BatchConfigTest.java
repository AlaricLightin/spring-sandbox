package com.example.springbatchtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBatchTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BatchConfig.class})
@MockBean(JobRepositoryTestUtils.class)
class BatchConfigTest {
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @TestConfiguration
    static class TestConfig{
        @Bean
        public JobLauncherTestUtils jobLauncherTestUtils() {
            return new JobLauncherTestUtils();
        }
    }

    @Test
    void launchJob() throws Exception {
        JobParameters parameters = new JobParametersBuilder()
                .addString("filename", "test.txt")
                .toJobParameters();

        JobExecution jobExecution = jobLauncherTestUtils.launchJob(parameters);
        assertThat(jobExecution.getExitStatus())
                .isEqualTo(ExitStatus.COMPLETED);
    }

}