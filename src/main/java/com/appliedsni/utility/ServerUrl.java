package com.appliedsni.utility;

public final class ServerUrl {
	public final static String ROOT_URL = "/rest/secure";
	public final static String LOGIN = "/login";
	public final static String LOGOUT = "/secure/logout";
	
	public final static String USERS = "/users";
	public final static String CREATE_USERS = "/user";
	public final static String USER = "/user/{id}";
	public final static String USER_COMPANYS = "/user/{id}/companys";
	public final static String USER_PROJECTS = "/user/{id}/projects";
	
	public final static String COMPANY_BY_ID = "/company/{id}";
	public final static String COMPANY = "/compnay";
	public final static String COMPANY_PROJECTS = "/compnay/{comapnyId}/projects";
	public final static String COMPANYS = "/companys";
	public final static String PROJECT = "/project/{id}";

}
