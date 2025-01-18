package world.evgereo.spring.minio.support;

import static world.evgereo.spring.minio.constants.MessageConstants.DEFAULT_UNKNOWN_ERROR_MESSAGE;

import io.minio.errors.ErrorResponseException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import world.evgereo.spring.minio.exception.AbstractMinioException;
import world.evgereo.spring.minio.exception.UncheckedMinioException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExceptionHandler {

    public static <T> T supplyExceptionally(ExceptionalSupplier<T, Exception> supplier) {
        try {
            return supplier.get();
        } catch (Exception ex) {
            throw handle(ex);
        }
    }

    public static void runExceptionally(ExceptionalRunnable<Exception> runnable) {
        try {
            runnable.run();
        } catch (Exception ex) {
            throw handle(ex);
        }
    }

    public static AbstractMinioException handle(Exception ex) {
        if (ex instanceof InvalidResponseException invalidResponseException) {
            return handleInvalidResponseException(invalidResponseException);
        } else if (ex instanceof ServerException serverException) {
            return handleServerException(serverException);
        } else if (ex instanceof ErrorResponseException errorResponseException) {
            return handleErrorResponseException(errorResponseException);
        } else {
            return handleDefaultError(ex);
        }
    }

    private static AbstractMinioException handleErrorResponseException(ErrorResponseException ex) {
        var status = ex.response().code();
        var errorMessage = ex.errorResponse().message();
        return ExceptionDefiner.define(String.valueOf(status), errorMessage, ex);
    }

    private static AbstractMinioException handleInvalidResponseException(InvalidResponseException ex) {
        return ExceptionDefiner.define(ex.getMessage(), ex);
    }

    private static AbstractMinioException handleServerException(ServerException ex) {
        var status = ex.statusCode();
        var errorMessage = ex.getMessage();
        return ExceptionDefiner.define(String.valueOf(status), errorMessage, ex);
    }

    private static AbstractMinioException handleDefaultError(Exception ex) {
        return new UncheckedMinioException(DEFAULT_UNKNOWN_ERROR_MESSAGE, ex);
    }
}
