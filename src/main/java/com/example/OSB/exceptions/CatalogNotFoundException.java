package com.example.OSB.exceptions;

import org.springframework.beans.factory.annotation.Value;

public class CatalogNotFoundException extends RuntimeException {
    public CatalogNotFoundException(Long id) {
        super(new StringBuilder().append(ExceptionMessage.catalogNotFound).append(id).toString());
    }
}
