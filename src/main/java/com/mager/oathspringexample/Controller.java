package com.mager.oathspringexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("/user")
    public Map<String,Object> user(@AuthenticationPrincipal OAuth2User principal){
        Map<String, Object> attributes = new HashMap<>();
        attributes.putAll(principal.getAttributes());
        return attributes;
    }
}
