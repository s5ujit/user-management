package com.appliedsni.security.jwtsecurity.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.appliedsni.controller.ResponseModifierAdvice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtSuccessHandler implements AuthenticationSuccessHandler{
	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseModifierAdvice.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        LOGGER.debug("Successfully Authentication");
    }
}
