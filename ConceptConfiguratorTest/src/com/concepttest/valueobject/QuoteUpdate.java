package com.concepttest.valueobject;

public class QuoteUpdate {
    
    private String serialNumber;
    private String status;
    
    
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
