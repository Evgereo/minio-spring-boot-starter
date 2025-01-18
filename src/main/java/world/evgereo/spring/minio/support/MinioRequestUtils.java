package world.evgereo.spring.minio.support;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinioRequestUtils {

    public static BucketExistsArgs buildBucketExistsRequest(String bucketName, String region) {
        return BucketExistsArgs.builder()
                .bucket(bucketName)
                .region(region)
                .build();
    }

    public static MakeBucketArgs buildMakeBucketRequest(String bucketName, String region) {
        return MakeBucketArgs.builder()
                .bucket(bucketName)
                .region(region)
                .build();
    }
}
