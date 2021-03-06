package com.appliedsni.utility;

public final class ServerUrl {
	public final static String ROOT_URL = "/rest/secure";
	public final static String LOGIN = "/login";
	public final static String LOGOUT = "/secure/logout";
	
	public final static String USERS = "/user";
	public final static String USER = "/user/{id}";
	public final static String USER_COMPANYS = "/user/{id}/companys";
	public final static String USER_PROJECTS = "/user/{id}/projects";
	
	public final static String COMPANY_BY_ID = "/company/{id}";
	public final static String COMPANY = "/company";
	public final static String COMPANY_PROJECTS = "/company/{companyId}/projects";
	public final static String COMPANYS = "/companys";
	public final static String PROJECT = "/project/{id}";
	public final static String PROJECTS = "/project";
	public final static String REPORTS = "/report";

}
