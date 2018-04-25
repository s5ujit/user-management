package com.appliedsni.security.jwtsecurity.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.appliedsni.security.jwtsecurity.model.JwtAuthenticationToken;
import com.appliedsni.security.jwtsecurity.model.JwtUser;
import com.appliedsni.security.jwtsecurity.model.JwtUserDetails;
import com.appliedsni.services.UserService;
import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationProvider.class);
    @Autowired
    private JwtValidator validator;
    @Autowired
    private UserService userService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();

        JwtUser jwtUser=null;
		try {
			jwtUser = validator.validate(token);
			userService.isVlaidSession(jwtUser.getUserName(), token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			LOGGER.debug(e.getStackTrace().toString());
		}

        if (jwtUser == null) {
            throw new RuntimeException("Token  incorrect");
        }

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(jwtUser.getRole());
        return new JwtUserDetails(jwtUser.getUserName(), jwtUser.getId(),
                token,
                grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
