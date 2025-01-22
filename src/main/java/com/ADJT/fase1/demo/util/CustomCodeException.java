package com.ADJT.fase1.demo.util;

import org.springframework.http.HttpStatus;

public final class CustomCodeException {
    public static final String CODE_500 = HttpStatus.INTERNAL_SERVER_ERROR.toString();
    public static final String CODE_400 = HttpStatus.BAD_REQUEST.toString();
}