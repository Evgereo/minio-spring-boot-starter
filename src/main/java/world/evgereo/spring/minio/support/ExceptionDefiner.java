package world.evgereo.spring.minio.support;

import static world.evgereo.spring.minio.constants.MessageConstants.DEFAULT_CLIENT_ERROR_MESSAGE;
import static world.evgereo.spring.minio.constants.MessageConstants.DEFAULT_COMMUNICATION_ERROR_MESSAGE;
import static world.evgereo.spring.minio.constants.MessageConstants.DEFAULT_SERVER_ERROR_MESSAGE;
import static world.evgereo.spring.minio.constants.MessageConstants.DEFAULT_UNKNOWN_ERROR_MESSAGE;

import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import world.evgereo.spring.minio.exception.AbstractMinioException;
import world.evgereo.spring.minio.exception.UncheckedMinioException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExceptionDefiner {
    private static final Pattern MESSAGE_PATTERN = Pattern.compile("Response code:\\s*(\\d{3})");

    public static AbstractMinioException define(String status, String message, Exception ex) {
        return new UncheckedMinioException(defineErrorCode(status), message, ex);
    }

    public static AbstractMinioException define(String message, Exception ex) {
        var matcher = MESSAGE_PATTERN.matcher(message);
        if (matcher.find()) {
            var status = matcher.group(1);
            return new UncheckedMinioException(defineErrorCode(status), message, ex);
        }
        return new UncheckedMinioException(DEFAULT_UNKNOWN_ERROR_MESSAGE, message, ex);
    }

    private static String defineErrorCode(String status) {
        if (status == null || status.length() != 3) {
            return DEFAULT_UNKNOWN_ERROR_MESSAGE;
        }

        var firstDigit = status.charAt(0);
        var secondDigit = status.charAt(1);
        return switch (firstDigit) {
            case '4' -> DEFAULT_CLIENT_ERROR_MESSAGE;
            case '5' -> defineServerErrorCode(secondDigit);
            default -> DEFAULT_UNKNOWN_ERROR_MESSAGE;
        };
    }

    private static String defineServerErrorCode(char secondDigit) {
        return switch (secondDigit) {
            case '2', '3', '4' -> DEFAULT_COMMUNICATION_ERROR_MESSAGE;
            default -> DEFAULT_SERVER_ERROR_MESSAGE;
        };
    }
}
