package com.klym.kbpm.shared.exception;

public class KbpmException extends RuntimeException {

    public enum Errors {
        MalformedURL, IO, Generic
    }
    
    private Errors kogitoErrorCode;
    private String kogitoErrorMessage;


    public KbpmException(Throwable cause, Errors kogitoErrorCode, String kogitoErrorMessage) {
        super(kogitoErrorMessage, cause);
        this.kogitoErrorCode = kogitoErrorCode;
        this.kogitoErrorMessage = kogitoErrorMessage;
    }


    public Errors getKogitoErrorCode() {
        return kogitoErrorCode;
    }
    public void setKogitoErrorCode(Errors kogitoErrorCode) {
        this.kogitoErrorCode = kogitoErrorCode;
    }
    public String getKogitoErrorMessage() {
        return kogitoErrorMessage;
    }
    public void setKogitoErrorMessage(String kogitoErrorMessage) {
        this.kogitoErrorMessage = kogitoErrorMessage;
    }

    
}
