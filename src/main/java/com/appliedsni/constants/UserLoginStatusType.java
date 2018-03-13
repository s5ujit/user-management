package com.appliedsni.constants;



public enum UserLoginStatusType {

    /**
     * This is an enumerated UserLoginStatusType constant to specify user change
     * station success.
     */
    USER_CHANGE_STATION_SUCCESS,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * credentials incorrect.
     */
    USER_LOGIN_CREDENTIALS_INCORRECT,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * invalid carrier.
     */
    USER_LOGIN_INVALID_CARRIER,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * invalid password.
     */
    USER_LOGIN_INVALID_PASSWORD,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * office invalid.
     */
    USER_LOGIN_OFFICE_INVALID,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * office not alphanumeric.
     */
    USER_LOGIN_OFFICE_NOT_ALPHANUMERIC,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * password expired.
     */
    USER_LOGIN_PASSWORD_EXPIRED,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * password mandatory.
     */
    USER_LOGIN_PASSWORD_MANDATORY,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * password not alphanumeric.
     */
    USER_LOGIN_PASSWORD_NOT_ALPHANUMERIC,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * password not empty.
     */
    USER_LOGIN_PASSWORD_NOT_EMPTY,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * station invalid.
     */
    USER_LOGIN_STATION_INVALID,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * station not alphanumeric.
     */
    USER_LOGIN_STATION_NOT_ALPHANUMERIC,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * userId locked.
     */
    USER_LOGIN_USER_ID_LOCKED,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * userId mandatory.
     */
    USER_LOGIN_USER_ID_MANDATORY,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * userId not founds.
     */
    USER_LOGIN_USER_ID_NOT_FOUND,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * userId not alphanumeric.
     */
    USER_LOGIN_USERID_NOT_APLHANUMERIC,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user
     * session expired.
     */
    USER_SESSION_EXPIRED,

    /**
     * This is an enumerated UserLoginStatusType constant to specify if sso is not enabled
     * for user
     */
    USER_SSO_NOT_ENABLED,

    /**
     * This is an enumerated UserLoginStatusType constant to specify if sso is enabled
     * for user
     */
    USER_SSO_ENABLED,

    
    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * password mandatory.
     */
    USER_OFFICE_MANDATORY,

    /**
     * This is an enumerated UserLoginStatusType constant to specify user login
     * password format is incorrect
     */
    USER_LOGIN_PASSWORD_FORMAT_INCORRECT,

    /**
     *This is an enumerated UserLoginStatusType constant to specify user windowsId
     * is not detected.
     */
    WINDOWS_ID_NOT_DETECTED;
    /**
     * This method <code>fromValue</code> returns the enumerated value.
     * <p>
     * It is a type of create,find,update,delete operation.<br>
     * <p>
     * 
     * @param pValue
     *            <code>String</code><br>
     *            The value of enumerated type.<br>
     *            </p>
     *            <p>
     * @return the enumerated value of the action type.<br>
     *         </p>
     */
    public static UserLoginStatusType fromValue(final String pValue) {
        return valueOf(pValue);
    }

    /**
     * The <code>value</code> method gives the string format of action type.
     * <p>
     * 
     * @return <code>String</code><br>
     *         Returns the enumerated value of the action type.<br>
     */
    public String value() {
        return this.name();
    }
}
