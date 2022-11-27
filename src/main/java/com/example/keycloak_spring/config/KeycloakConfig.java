package com.example.keycloak_spring.config;

import org.keycloak.admin.client.Keycloak;

public class KeycloakConfig {

    static Keycloak keycloak = null;
    final static String serverUrl = "http://0.0.0.0:8080/"; //keycloak domain and port
    public final static String realm = "realm";
    final static String clientId = "clientId";
    final static String userName = "admin";
    final static String password = "admin";

    public KeycloakConfig() {
    }

    public static String getRealmName(){
        return realm;
    }
}
