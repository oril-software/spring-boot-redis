package com.constants;


public class Constants {

	/*GENERAl FIELDS*/
	public static final String LOCALHOST = "127.0.0.1";
	public static final int REDIS_PORT = 6379;
	public static final String ALL_KEYS = "*";

	/*LOGGING MESSAGES*/
	public static final String ADD_REQUEST_LOG_MSG = "##### -> in add(): ";
	public static final String LIST_ALL_REQUEST_LOG_MSG = "##### -> in listAll()";
	public static final String GET_ONE_REQUEST_LOG_MSG = "##### -> in get(), key: ";
	public static final String DELETE_ONE_REQUEST_LOG_MSG = "##### -> in delete(), key: ";

	/*RESPONSE MESSAGES*/
	public static final String KEY_DELETED = "deleted key: ";

}
