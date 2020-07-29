package com.example.staxeventreader;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

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
    Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(ElementClass.class);
        return marshaller;
    }

    @Bean
    ItemReader<ElementClass> itemReader(Jaxb2Marshaller jaxb2Marshaller) {
        return new StaxEventItemReaderBuilder<ElementClass>()
                .name("reader")
                .saveState(false)
                .addFragmentRootElements("element")
                .resource(new ClassPathResource("example.xml"))
                .unmarshaller(jaxb2Marshaller)
                .build();
    }

    @Bean
    ItemWriter<ElementClass> itemWriter() {
        return new FlatFileItemWriterBuilder<ElementClass>()
                .name("writer")
                .saveState(false)
                .resource(new FileSystemResource("output.txt"))
                .lineAggregator(ElementClass::toString)
                .build();
    }

    @Bean
    Step step(ItemReader<ElementClass> itemReader,
              ItemWriter<ElementClass> itemWriter) {
        return stepBuilderFactory
                .get("step")
                .<ElementClass, ElementClass>chunk(5)
                .reader(itemReader)
                .writer(itemWriter)
                .build();
    }

    @Bean
    Job job(Step step) {
        return jobBuilderFactory
                .get("job")
                .start(step)
                .build();
    }
}
