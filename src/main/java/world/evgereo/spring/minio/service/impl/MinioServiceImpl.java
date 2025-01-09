package world.evgereo.spring.minio.service.impl;

import io.minio.BucketExistsArgs;
import io.minio.CloseableIterator;
import io.minio.ComposeObjectArgs;
import io.minio.CopyObjectArgs;
import io.minio.DeleteBucketEncryptionArgs;
import io.minio.DeleteBucketLifecycleArgs;
import io.minio.DeleteBucketNotificationArgs;
import io.minio.DeleteBucketPolicyArgs;
import io.minio.DeleteBucketReplicationArgs;
import io.minio.DeleteBucketTagsArgs;
import io.minio.DeleteObjectLockConfigurationArgs;
import io.minio.DeleteObjectTagsArgs;
import io.minio.DisableObjectLegalHoldArgs;
import io.minio.DownloadObjectArgs;
import io.minio.EnableObjectLegalHoldArgs;
import io.minio.GetBucketEncryptionArgs;
import io.minio.GetBucketLifecycleArgs;
import io.minio.GetBucketNotificationArgs;
import io.minio.GetBucketPolicyArgs;
import io.minio.GetBucketReplicationArgs;
import io.minio.GetBucketTagsArgs;
import io.minio.GetBucketVersioningArgs;
import io.minio.GetObjectArgs;
import io.minio.GetObjectLockConfigurationArgs;
import io.minio.GetObjectResponse;
import io.minio.GetObjectRetentionArgs;
import io.minio.GetObjectTagsArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.IsObjectLegalHoldEnabledArgs;
import io.minio.ListBucketsArgs;
import io.minio.ListObjectsArgs;
import io.minio.ListenBucketNotificationArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PostPolicy;
import io.minio.PutObjectArgs;
import io.minio.RemoveBucketArgs;
import io.minio.RemoveObjectArgs;
import io.minio.RemoveObjectsArgs;
import io.minio.RestoreObjectArgs;
import io.minio.Result;
import io.minio.SelectObjectContentArgs;
import io.minio.SelectResponseStream;
import io.minio.SetBucketEncryptionArgs;
import io.minio.SetBucketLifecycleArgs;
import io.minio.SetBucketNotificationArgs;
import io.minio.SetBucketPolicyArgs;
import io.minio.SetBucketReplicationArgs;
import io.minio.SetBucketTagsArgs;
import io.minio.SetBucketVersioningArgs;
import io.minio.SetObjectLockConfigurationArgs;
import io.minio.SetObjectRetentionArgs;
import io.minio.SetObjectTagsArgs;
import io.minio.StatObjectArgs;
import io.minio.StatObjectResponse;
import io.minio.UploadObjectArgs;
import io.minio.UploadSnowballObjectsArgs;
import io.minio.messages.Bucket;
import io.minio.messages.DeleteError;
import io.minio.messages.Item;
import io.minio.messages.LifecycleConfiguration;
import io.minio.messages.NotificationConfiguration;
import io.minio.messages.NotificationRecords;
import io.minio.messages.ObjectLockConfiguration;
import io.minio.messages.ReplicationConfiguration;
import io.minio.messages.Retention;
import io.minio.messages.SseConfiguration;
import io.minio.messages.Tags;
import io.minio.messages.VersioningConfiguration;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.evgereo.spring.minio.service.MinioService;
import world.evgereo.spring.minio.support.ExceptionHandler;

@Service
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {
    private final MinioClient minioClient;

    @Override
    public StatObjectResponse statObject(StatObjectArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.statObject(args));
    }

    @Override
    public GetObjectResponse getObject(GetObjectArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getObject(args));
    }

    @Override
    public void downloadObject(DownloadObjectArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.downloadObject(args));
    }

    @Override
    public ObjectWriteResponse copyObject(CopyObjectArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.copyObject(args));
    }

    @Override
    public ObjectWriteResponse composeObject(ComposeObjectArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.composeObject(args));
    }

    @Override
    public String getPresignedObjectUrl(GetPresignedObjectUrlArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getPresignedObjectUrl(args));
    }

    @Override
    public Map<String, String> getPresignedPostFormData(PostPolicy policy) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getPresignedPostFormData(policy));
    }

    @Override
    public void removeObject(RemoveObjectArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.removeObject(args));
    }

    @Override
    public Iterable<Result<DeleteError>> removeObjects(RemoveObjectsArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.removeObjects(args));
    }

    @Override
    public void restoreObject(RestoreObjectArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.restoreObject(args));
    }

    @Override
    public Iterable<Result<Item>> listObjects(ListObjectsArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.listObjects(args));
    }

    @Override
    public List<Bucket> listBuckets() {
        return ExceptionHandler.supplyExceptionally(minioClient::listBuckets);
    }

    @Override
    public List<Bucket> listBuckets(ListBucketsArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.listBuckets(args));
    }

    @Override
    public boolean bucketExists(BucketExistsArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.bucketExists(args));
    }

    @Override
    public void makeBucket(MakeBucketArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.makeBucket(args));
    }

    @Override
    public void setBucketVersioning(SetBucketVersioningArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.setBucketVersioning(args));
    }

    @Override
    public VersioningConfiguration getBucketVersioning(GetBucketVersioningArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getBucketVersioning(args));
    }

    @Override
    public void setObjectLockConfiguration(SetObjectLockConfigurationArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.setObjectLockConfiguration(args));
    }

    @Override
    public void deleteObjectLockConfiguration(DeleteObjectLockConfigurationArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.deleteObjectLockConfiguration(args));
    }

    @Override
    public ObjectLockConfiguration getObjectLockConfiguration(GetObjectLockConfigurationArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getObjectLockConfiguration(args));
    }

    @Override
    public void setObjectRetention(SetObjectRetentionArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.setObjectRetention(args));
    }

    @Override
    public Retention getObjectRetention(GetObjectRetentionArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getObjectRetention(args));
    }

    @Override
    public void enableObjectLegalHold(EnableObjectLegalHoldArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.enableObjectLegalHold(args));
    }

    @Override
    public void disableObjectLegalHold(DisableObjectLegalHoldArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.disableObjectLegalHold(args));
    }

    @Override
    public boolean isObjectLegalHoldEnabled(IsObjectLegalHoldEnabledArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.isObjectLegalHoldEnabled(args));
    }

    @Override
    public void removeBucket(RemoveBucketArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.removeBucket(args));
    }

    @Override
    public ObjectWriteResponse putObject(PutObjectArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.putObject(args));
    }

    @Override
    public ObjectWriteResponse uploadObject(UploadObjectArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.uploadObject(args));
    }

    @Override
    public String getBucketPolicy(GetBucketPolicyArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getBucketPolicy(args));
    }

    @Override
    public void setBucketPolicy(SetBucketPolicyArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.setBucketPolicy(args));
    }

    @Override
    public void deleteBucketPolicy(DeleteBucketPolicyArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.deleteBucketPolicy(args));
    }

    @Override
    public void setBucketLifecycle(SetBucketLifecycleArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.setBucketLifecycle(args));
    }

    @Override
    public void deleteBucketLifecycle(DeleteBucketLifecycleArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.deleteBucketLifecycle(args));
    }

    @Override
    public LifecycleConfiguration getBucketLifecycle(GetBucketLifecycleArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getBucketLifecycle(args));
    }

    @Override
    public NotificationConfiguration getBucketNotification(GetBucketNotificationArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getBucketNotification(args));
    }

    @Override
    public void setBucketNotification(SetBucketNotificationArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.setBucketNotification(args));
    }

    @Override
    public void deleteBucketNotification(DeleteBucketNotificationArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.deleteBucketNotification(args));
    }

    @Override
    public ReplicationConfiguration getBucketReplication(GetBucketReplicationArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getBucketReplication(args));
    }

    @Override
    public void setBucketReplication(SetBucketReplicationArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.setBucketReplication(args));
    }

    @Override
    public void deleteBucketReplication(DeleteBucketReplicationArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.deleteBucketReplication(args));
    }

    @Override
    public CloseableIterator<Result<NotificationRecords>> listenBucketNotification(ListenBucketNotificationArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.listenBucketNotification(args));
    }

    @Override
    public SelectResponseStream selectObjectContent(SelectObjectContentArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.selectObjectContent(args));
    }

    @Override
    public void setBucketEncryption(SetBucketEncryptionArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.setBucketEncryption(args));
    }

    @Override
    public SseConfiguration getBucketEncryption(GetBucketEncryptionArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getBucketEncryption(args));
    }

    @Override
    public void deleteBucketEncryption(DeleteBucketEncryptionArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.deleteBucketEncryption(args));
    }

    @Override
    public Tags getBucketTags(GetBucketTagsArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getBucketTags(args));
    }

    @Override
    public void setBucketTags(SetBucketTagsArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.setBucketTags(args));
    }

    @Override
    public void deleteBucketTags(DeleteBucketTagsArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.deleteBucketTags(args));
    }

    @Override
    public Tags getObjectTags(GetObjectTagsArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.getObjectTags(args));
    }

    @Override
    public void setObjectTags(SetObjectTagsArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.setObjectTags(args));
    }

    @Override
    public void deleteObjectTags(DeleteObjectTagsArgs args) {
        ExceptionHandler.runExceptionally(() -> minioClient.deleteObjectTags(args));
    }

    @Override
    public ObjectWriteResponse uploadSnowballObjects(UploadSnowballObjectsArgs args) {
        return ExceptionHandler.supplyExceptionally(() -> minioClient.uploadSnowballObjects(args));
    }
}
