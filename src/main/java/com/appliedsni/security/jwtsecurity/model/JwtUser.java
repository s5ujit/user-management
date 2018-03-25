package com.appliedsni.security.jwtsecurity.model;

public class JwtUser {
    private String userName;
    private String idKey;
    private String role;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(String idKey) {
        this.idKey = idKey;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getId() {
        return idKey;
    }

    public String getRole() {
        return role;
    }
    public String toString() {
        return role;
    }
}
