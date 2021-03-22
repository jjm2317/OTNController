package com.woorinet.plugin.demo.ROLE.PORTAL;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PortalRole {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String value;

}