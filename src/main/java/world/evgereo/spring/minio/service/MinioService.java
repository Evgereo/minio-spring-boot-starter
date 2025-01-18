package world.evgereo.spring.minio.service;

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

public interface MinioService {

    StatObjectResponse statObject(StatObjectArgs args);

    GetObjectResponse getObject(GetObjectArgs args);

    void downloadObject(DownloadObjectArgs args);

    ObjectWriteResponse copyObject(CopyObjectArgs args);

    ObjectWriteResponse composeObject(ComposeObjectArgs args);

    String getPresignedObjectUrl(GetPresignedObjectUrlArgs args);

    Map<String, String> getPresignedPostFormData(PostPolicy policy);

    void removeObject(RemoveObjectArgs args);

    Iterable<Result<DeleteError>> removeObjects(RemoveObjectsArgs args);

    void restoreObject(RestoreObjectArgs args);

    Iterable<Result<Item>> listObjects(ListObjectsArgs args);

    List<Bucket> listBuckets();

    List<Bucket> listBuckets(ListBucketsArgs args);

    boolean bucketExists(BucketExistsArgs args);

    void makeBucket(MakeBucketArgs args);

    void setBucketVersioning(SetBucketVersioningArgs args);

    VersioningConfiguration getBucketVersioning(GetBucketVersioningArgs args);

    void setObjectLockConfiguration(SetObjectLockConfigurationArgs args);

    void deleteObjectLockConfiguration(DeleteObjectLockConfigurationArgs args);

    ObjectLockConfiguration getObjectLockConfiguration(GetObjectLockConfigurationArgs args);

    void setObjectRetention(SetObjectRetentionArgs args);

    Retention getObjectRetention(GetObjectRetentionArgs args);

    void enableObjectLegalHold(EnableObjectLegalHoldArgs args);

    void disableObjectLegalHold(DisableObjectLegalHoldArgs args);

    boolean isObjectLegalHoldEnabled(IsObjectLegalHoldEnabledArgs args);

    void removeBucket(RemoveBucketArgs args);

    ObjectWriteResponse putObject(PutObjectArgs args);

    ObjectWriteResponse uploadObject(UploadObjectArgs args);

    String getBucketPolicy(GetBucketPolicyArgs args);

    void setBucketPolicy(SetBucketPolicyArgs args);

    void deleteBucketPolicy(DeleteBucketPolicyArgs args);

    void setBucketLifecycle(SetBucketLifecycleArgs args);

    void deleteBucketLifecycle(DeleteBucketLifecycleArgs args);

    LifecycleConfiguration getBucketLifecycle(GetBucketLifecycleArgs args);

    NotificationConfiguration getBucketNotification(GetBucketNotificationArgs args);

    void setBucketNotification(SetBucketNotificationArgs args);

    void deleteBucketNotification(DeleteBucketNotificationArgs args);

    ReplicationConfiguration getBucketReplication(GetBucketReplicationArgs args);

    void setBucketReplication(SetBucketReplicationArgs args);

    void deleteBucketReplication(DeleteBucketReplicationArgs args);

    CloseableIterator<Result<NotificationRecords>> listenBucketNotification(ListenBucketNotificationArgs args);

    SelectResponseStream selectObjectContent(SelectObjectContentArgs args);

    void setBucketEncryption(SetBucketEncryptionArgs args);

    SseConfiguration getBucketEncryption(GetBucketEncryptionArgs args);

    void deleteBucketEncryption(DeleteBucketEncryptionArgs args);

    Tags getBucketTags(GetBucketTagsArgs args);

    void setBucketTags(SetBucketTagsArgs args);

    void deleteBucketTags(DeleteBucketTagsArgs args);

    Tags getObjectTags(GetObjectTagsArgs args);

    void setObjectTags(SetObjectTagsArgs args);

    void deleteObjectTags(DeleteObjectTagsArgs args);

    ObjectWriteResponse uploadSnowballObjects(UploadSnowballObjectsArgs args);
}
