package world.evgereo.spring.minio.exception;

public class UncheckedMinioException extends AbstractMinioException {

    public UncheckedMinioException(String errorCode, String originalMessage, Throwable throwable) {
        super(errorCode, originalMessage, throwable);
    }

    public UncheckedMinioException(String errorCode, String originalMessage) {
        super(errorCode, originalMessage);
    }

    public UncheckedMinioException(String errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public UncheckedMinioException(String errorCode) {
        super(errorCode);
    }
}
