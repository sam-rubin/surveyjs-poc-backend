package com.example.demo.user;

public enum Role {
    LOCAL_ADMIN, ADMIN;

    String authority() {
        return "ROLE_" + this.name();
    }
}
