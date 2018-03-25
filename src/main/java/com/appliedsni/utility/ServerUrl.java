package com.appliedsni.utility;

public final class ServerUrl {
	public final static String rootUrl = "/rest/secure";
	public final static String login = "/login";
	public final static String logout = "/secure/logout";
	public final static String createUser = "/createUser";
	public final static String usersList = "/usersList";
	public final static String userById = "/user/{id}";
	public final static String companyList = "/companyList";
	public final static String companyById = "/compnay/{id}";
	public final static String projectList = "/projectList";
	public final static String projectById = "/project/{id}";
	public final static String projectByCompany = "/compnay/{comapnyId}/projectList/{projectId}";

}
