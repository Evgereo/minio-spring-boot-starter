package world.evgereo.spring.minio.config.properties;

import static world.evgereo.spring.minio.constants.MessageConstants.BUCKET_NAME_SIZE_VALIDATION_MESSAGE;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Duration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "spring.data.minio")
public class MinioProperties {

    @NotBlank
    private String url;

    @NotBlank
    private String accessKey;

    @NotBlank
    private String secretKey;

    @NotBlank
    private String region = "us-east-1";

    private Bucket bucket;

    /**
     * Unsupported
     */
    private Repositories repositories;

    @NotNull
    private Duration connectTimeout = Duration.ofSeconds(10);

    @NotNull
    private Duration writeTimeout = Duration.ofSeconds(60);

    @NotNull
    private Duration readTimeout = Duration.ofSeconds(30);

    @Getter
    @Setter
    @Validated
    public static class Repositories {

        private boolean enabled = false;
    }

    @Getter
    @Setter
    @Validated
    public static class Bucket {

        @NotBlank
        @Size(min = 3, message = BUCKET_NAME_SIZE_VALIDATION_MESSAGE)
        private String name;

        private boolean create = false;
    }
}
