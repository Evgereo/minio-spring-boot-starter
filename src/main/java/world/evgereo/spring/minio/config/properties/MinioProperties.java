package world.evgereo.spring.minio.config.properties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "spring.data.minio")
public class MinioProperties {

    @NotBlank
    private final String url;

    @NotBlank
    private final String accessKey;

    @NotBlank
    private final String secretKey;

    private final String region;

    private final Bucket bucket;

    /**
     * Unsupported
     */
    private final Repositories repositories;

    @NotNull
    private final Duration connectTimeout = Duration.ofSeconds(10);

    @NotNull
    private final Duration writeTimeout = Duration.ofSeconds(60);

    @NotNull
    private final Duration readTimeout = Duration.ofSeconds(30);

    @Getter
    @AllArgsConstructor
    public static class Repositories {

        private final boolean enabled = false;
    }

    @Getter
    @AllArgsConstructor
    public static class Bucket {

        @NotBlank
        @Size(min = 3)
        private final String name;

        private final boolean create = false;
    }
}
