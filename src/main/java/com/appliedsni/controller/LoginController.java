package com.appliedsni.controller;



import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.appliedsni.entity.User;
import com.appliedsni.services.UserService;
import com.appliedsni.utility.ServerUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
@RestController
@RequestMapping("/rest")
public class LoginController {
	private static final String GOOGLE_CLIENT_ID = " ";
	@Autowired
	UserService userService;

	@PostMapping(value = ServerUrl.LOGIN)
	public @ResponseBody User login(@RequestBody final User pUserRequest,HttpServletResponse response) throws Exception {
	
		User user = userService.loginUser(pUserRequest, response);
		return user;
	}
	
	@PostMapping(value = ServerUrl.LOGOUT)
	public void logout(@RequestBody final User pUserLoginRequest,HttpServletRequest request) throws Exception {
		 String header = request.getHeader("Authorisation");
		 userService.deleteSession(pUserLoginRequest.getEmailAddress(),header);
	}
	@PostMapping(value = ServerUrl.USER)
	public @ResponseBody User createUser(@RequestBody final User pUserLoginRequest) throws Exception {
		User userLoginResponse = userService.createUser(pUserLoginRequest);
		return userLoginResponse;
	}
	@GetMapping
	public User googleLogin(HttpServletRequest httpServletRequest) throws IOException, GeneralSecurityException{

		String tokenString = httpServletRequest.getHeader("Authorisation");
        JacksonFactory jacksonFactory = new JacksonFactory();
        GoogleIdTokenVerifier googleIdTokenVerifier =
                            new GoogleIdTokenVerifier(new NetHttpTransport(), jacksonFactory);

        GoogleIdToken token = GoogleIdToken.parse(jacksonFactory, tokenString);
        GoogleIdToken.Payload payload;
        if (googleIdTokenVerifier.verify(token)) {
        	payload = token.getPayload();
            if (!GOOGLE_CLIENT_ID.equals(payload.getAudience())) {
                throw new IllegalArgumentException("Audience mismatch");
            } else if (!GOOGLE_CLIENT_ID.equals(payload.getAuthorizedParty())) {
                throw new IllegalArgumentException("Client ID mismatch");
            }
            
        } else {
            throw new IllegalArgumentException("id token cannot be verified");
        }
    User user=new User();
    user.setEmailAddress(payload.getEmail());
		return null;
	}
	
}
