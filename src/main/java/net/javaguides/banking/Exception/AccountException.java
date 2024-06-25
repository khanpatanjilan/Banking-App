package net.javaguides.banking.Exception;

import org.springframework.web.bind.annotation.RestController;

public class AccountException extends  RuntimeException{
    public AccountException(String message) {
        super(message);
    }
}
