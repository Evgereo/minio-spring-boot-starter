package world.evgereo.spring.minio.support;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinioRequestUtils {

    public static BucketExistsArgs buildBucketExistsRequest(String bucketName, String region) {
        var agrsBuilder = BucketExistsArgs.builder()
                .bucket(bucketName);
        Optional.ofNullable(region).ifPresent(agrsBuilder::region);
        return agrsBuilder.build();
    }

    public static MakeBucketArgs buildMakeBucketRequest(String bucketName, String region) {
        var agrsBuilder = MakeBucketArgs.builder()
                .bucket(bucketName);
        Optional.ofNullable(region).ifPresent(agrsBuilder::region);
        return agrsBuilder.build();
    }
}
