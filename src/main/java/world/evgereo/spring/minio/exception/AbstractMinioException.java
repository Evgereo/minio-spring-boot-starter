package world.evgereo.spring.minio.exception;

import lombok.Getter;

@Getter
public abstract class AbstractMinioException extends RuntimeException {
    private final String originalMessage;
    private final String errorCode;

    protected AbstractMinioException(String errorCode, String originalMessage, Throwable throwable) {
        super(originalMessage, throwable);
        this.originalMessage = originalMessage;
        this.errorCode = errorCode;
    }

    protected AbstractMinioException(String errorCode, String originalMessage) {
        super(originalMessage);
        this.originalMessage = originalMessage;
        this.errorCode = errorCode;
    }

    protected AbstractMinioException(String errorCode, Throwable throwable) {
        super(throwable);
        this.originalMessage = null;
        this.errorCode = errorCode;
    }

    protected AbstractMinioException(String errorCode) {
        this.originalMessage = null;
        this.errorCode = errorCode;
    }
}
