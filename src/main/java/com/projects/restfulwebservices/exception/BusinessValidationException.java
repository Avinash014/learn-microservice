package com.projects.restfulwebservices.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class BusinessValidationException extends RuntimeException {
    private final String errorName;
    private final String errorDesc;

    public BusinessValidationException(String errorName, String errorDesc) {
        this.errorName = errorName;
        this.errorDesc = errorDesc;
    }

    public String getErrorName() {
        return errorName;
    }

    public String getErrorDesc() {
        return errorDesc;
    }


}
