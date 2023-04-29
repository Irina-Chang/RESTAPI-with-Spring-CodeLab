package codelab.spring.springboot2.exception;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionalDetails extends ExceptionDetails{
    private final String fields;
    private final String fieldsMessage;
}
