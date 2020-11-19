package com.example.springbatchschema.batch;

import com.example.springbatchschema.models.Document;
import com.example.springbatchschema.repositories.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DocumentRepository repository;

    @Bean
    Job job(Step step) {
        return jobBuilderFactory
                .get("job")
                .start(step)
                .build();
    }

    @Bean
    Step step(ItemReader<Document> documentItemReader,
              ItemWriter<Document> documentItemWriter) {
        return stepBuilderFactory
                .get("step")
                .<Document, Document>chunk(10)
                .reader(documentItemReader)
                .writer(documentItemWriter)
                .build();
    }

    @Bean
    ItemReader<Document> documentItemReader() {
        return new FlatFileItemReaderBuilder<Document>()
                .resource(new FileSystemResource("input.txt"))
                .lineMapper((s, num) -> new Document(s))
                .saveState(false)
                .build();
    }

    @Bean
    ItemWriter<Document> documentItemWriter() {
        return new RepositoryItemWriterBuilder<Document>()
                .repository(repository)
                .methodName("save")
                .build();
    }
}
