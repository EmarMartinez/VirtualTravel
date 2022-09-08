package com.virtualtravelappback.error;

import java.util.Date;

public class CustomError {
    private Date timestamp;
    private int httpCode;
    private String mensaje;



    public CustomError(Date timestamp, String message, int httpCode) {
        super();
        this.timestamp = timestamp;
        this.mensaje = message;

        this.httpCode=httpCode;
    }

    public int getHttpCode() { return httpCode; }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }


}
