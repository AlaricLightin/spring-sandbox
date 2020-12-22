package com.example.swaggerexperiment;

import com.example.swaggerexperiment.controllers.ErrorDto;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.converter.ResolvedSchema;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    @Bean
    OpenApiCustomiser openApiCustomiser() {
        return openApi -> {
            Components components = openApi.getComponents();
            ResolvedSchema resolvedSchema = ModelConverters.getInstance().resolveAsResolvedSchema(
                    new AnnotatedType(ErrorDto.class));
            components.addSchemas("ErrorDto", resolvedSchema.schema);

            Schema<?> refSchema = new Schema<>();
            refSchema.setName("ErrorDto");
            refSchema.set$ref("#/components/schemas/ErrorDto");

            Content errorContent = new Content().addMediaType(
                    "application/json", (new MediaType()).schema(refSchema));
            components
                    .addResponses("demoException", new ApiResponse()
                            .description("Demo Exception")
                            .content(errorContent)
                    );
        };
    }
}
