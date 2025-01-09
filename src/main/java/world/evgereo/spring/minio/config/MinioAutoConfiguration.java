package world.evgereo.spring.minio.config;

import io.minio.MinioClient;
import java.util.Optional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import world.evgereo.spring.minio.config.properties.MinioProperties;
import world.evgereo.spring.minio.service.MinioService;
import world.evgereo.spring.minio.service.impl.MinioServiceImpl;
import world.evgereo.spring.minio.support.MinioRequestUtils;

@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(MinioProperties.class)
public class MinioAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(MinioClient.class)
    public MinioClient minioClient(MinioProperties minioProperties) {
        var minioClientBuilder = MinioClient.builder()
                .endpoint(minioProperties.getUrl())
                .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey());
        Optional.ofNullable(minioProperties.getRegion()).ifPresent(minioClientBuilder::region);
        var minioClient = minioClientBuilder.build();

        configureMinio(minioProperties, minioClient);
        return minioClient;
    }

    @Bean
    public MinioService minioServiceImpl(MinioClient minioClient) {
        return new MinioServiceImpl(minioClient);
    }

    @SneakyThrows
    private void configureMinio(MinioProperties minioProperties, MinioClient minioClient) {
        var bucketName = minioProperties.getBucket().getName();
        if (bucketName != null) {
            var region = minioProperties.getRegion();
            if (!minioClient.bucketExists(MinioRequestUtils.buildBucketExistsRequest(bucketName, region))) {
                if (minioProperties.getBucket().isCreate()) {
                    minioClient.makeBucket(MinioRequestUtils.buildMakeBucketRequest(bucketName, region));
                } else {
                    throw new IllegalStateException("Bucket with name: " + bucketName + " and region: " + region + " not exists");
                }
            }
        }

        minioClient.setTimeout(
                minioProperties.getConnectTimeout().toMillis(),
                minioProperties.getWriteTimeout().toMillis(),
                minioProperties.getWriteTimeout().toMillis()
        );
    }
}
