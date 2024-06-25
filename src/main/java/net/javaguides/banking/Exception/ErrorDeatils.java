package net.javaguides.banking.Exception;

import java.time.LocalDateTime;

public record ErrorDeatils(LocalDateTime timestamp,
                           String message,
                           String details,
                           String errorCode) {
}
