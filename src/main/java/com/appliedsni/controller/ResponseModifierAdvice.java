package com.appliedsni.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.appliedsni.dto.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@ControllerAdvice
public class ResponseModifierAdvice extends ResponseEntityExceptionHandler implements ResponseBodyAdvice<Object> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseModifierAdvice.class);
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		// TODO Auto-generated method stub

		ResponseObject responseObject = new ResponseObject();
		responseObject.setObject(body);
		responseObject.setStatus("Success");
		return responseObject;

	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseObject> processRuntimeException(HttpServletRequest req, RuntimeException ex)
			throws Exception {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setObject("exception");
		responseObject.setStatus("Fail");
		responseObject.setExceptionMessage(ex.getLocalizedMessage());
		LOGGER.debug(ex.getStackTrace().toString());
		return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.valueOf(HttpStatus.EXPECTATION_FAILED.value()));
	}
}