package com.example.keycloak_spring.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakConfig {

    static Keycloak keycloak = null;
    final static String SERVER_URL = "http://0.0.0.0:8090/"; //keycloak domain and port
    public final static String REALM = "master";
    final static String CLIENT_ID = "spring_keycloak";
    final static String USERNAME = "admin";
    final static String PASSWORD = "admin";

    public KeycloakConfig() {
    }

    public static Keycloak getInstance(){
        if(keycloak == null){

            keycloak = KeycloakBuilder.builder()
                    .serverUrl(SERVER_URL)
                    .realm(REALM)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(USERNAME)
                    .password(PASSWORD)
                    .clientId(CLIENT_ID)
                    .resteasyClient(new ResteasyClientBuilder()
                            .connectionPoolSize(10)
                            .build()
                    )
                    .build();
        }
        return keycloak;
    }

    public static String getRealmName(){
        return REALM;
    }
}
