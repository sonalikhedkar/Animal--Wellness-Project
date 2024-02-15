package com.app.excepe;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartException extends RuntimeException{
			public CartException(String msg) {
				super(msg);
			}
}