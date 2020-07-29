package com.example.springbatchtest;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import java.util.Arrays;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job testJob(Step testStep) {
        return jobBuilderFactory
                .get("testJob")
                .start(testStep)
                .build();
    }

    @JobScope
    @Bean
    public FilenameHolder filenameHolder(@Value("#{jobParameters[filename]}") String filename) {
        return new FilenameHolder(filename);
    }

    @JobScope
    @Bean
    public Step testStep(FilenameHolder filenameHolder) {
        ItemReader<String> itemReader = new ListItemReader<>(Arrays.asList("1", "2", "5"));
        ItemWriter<String> itemWriter = new FlatFileItemWriterBuilder<String>()
                .name("stringItemWriter")
                .resource(new FileSystemResource(filenameHolder.getFilename()))
                .lineAggregator(new DelimitedLineAggregator<>())
                .build();

        return stepBuilderFactory
                .get("testStep")
                .<String, String>chunk(5)
                .reader(itemReader)
                .writer(itemWriter)
                .build();
    }
}
