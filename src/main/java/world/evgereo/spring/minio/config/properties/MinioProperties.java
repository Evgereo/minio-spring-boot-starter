package world.evgereo.spring.minio.config.properties;

import jakarta.validation.constraints.NotBlank;
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

    private final Bucket bucket = new Bucket();

    /**
     * Unsupported
     */
    private final Repositories repositories = new Repositories();

    private final Duration connectTimeout = Duration.ofSeconds(10); //todo not work

    private final Duration writeTimeout = Duration.ofSeconds(60);

    private final Duration readTimeout = Duration.ofSeconds(30);

    @Getter
    @AllArgsConstructor
    public static class Repositories {
        private final boolean enabled = false;
    }

    @Getter
    @AllArgsConstructor
    public static class Bucket {
        private final String name = null;
        private final boolean create = false;
    }
}
