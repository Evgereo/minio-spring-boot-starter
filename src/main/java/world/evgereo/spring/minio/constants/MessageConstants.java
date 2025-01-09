package world.evgereo.spring.minio.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MessageConstants {
    public static final String DEFAULT_COMMUNICATION_ERROR_MESSAGE = "minio.communication.error";
    public static final String DEFAULT_CLIENT_ERROR_MESSAGE = "minio.client.error";
    public static final String DEFAULT_SERVER_ERROR_MESSAGE = "minio.server.error";
    public static final String DEFAULT_UNKNOWN_ERROR_MESSAGE = "minio.unknown.error";
}
