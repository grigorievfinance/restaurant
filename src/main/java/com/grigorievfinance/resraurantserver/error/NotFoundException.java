package com.grigorievfinance.resraurantserver.error;

public class NotFoundException extends IllegalRequestDataException {
    public NotFoundException(String msg) {
        super(msg);
    }
}
