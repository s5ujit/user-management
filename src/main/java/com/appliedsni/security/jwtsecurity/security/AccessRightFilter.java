package com.appliedsni.security.jwtsecurity.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import com.appliedsni.entity.AccessRight;
import com.appliedsni.utility.AsscessRightUtility;
import com.appliedsni.utility.UrlMatcher;
import com.appliedsni.utility.UrlPattern;

@Component
public class AccessRightFilter extends GenericFilterBean {

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request; 
		SecurityContextHolder.getContext().getAuthentication();
		SimpleGrantedAuthority role= (SimpleGrantedAuthority) SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0];
		List<AccessRight> accessRightList = AsscessRightUtility.getAcessRightList().stream()
				.filter(a -> a.getRole().name().equalsIgnoreCase(role.toString())
						&& ((a.isReadAccess() && "GET".equalsIgnoreCase(httpRequest.getMethod())) || a.isWriteAccess()))
				.collect(Collectors.toList());
		AccessRight accessRight=null;
		for(AccessRight aAaccessRight:accessRightList)
		{
			 UrlMatcher urlPattern = new UrlPattern(aAaccessRight.getUrl());
			 if(urlPattern.matches(httpRequest.getServletPath())){
				 accessRight=aAaccessRight;
				 break;
			 }
			
		}
		if(accessRight==null)	
			throw new RuntimeException("not access");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}