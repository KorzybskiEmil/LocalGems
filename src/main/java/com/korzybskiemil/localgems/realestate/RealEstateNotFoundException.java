package com.korzybskiemil.localgems.realestate;

public class RealEstateNotFoundException extends RuntimeException{

    public RealEstateNotFoundException(String message) {
        super(message);
    }
}
