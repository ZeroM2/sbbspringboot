package com.mysite.sbb.user;


import lombok.Getter;

@Getter //상수 자료형이므로 Setter 없이 Getter만 사용
public enum UserRole { //enum은 열거 자료형
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    UserRole(String value) {
        this.value = value;
    }

    private String value;
}