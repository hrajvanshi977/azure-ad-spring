package com.learn.azuread.controller;

import com.learn.azuread.config.AzureAdJwtToken;
import com.learn.azuread.config.JwtTokenUtil;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final OAuth2AuthorizedClientService authClientService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

//    @Autowired
//    private AzureAdJwtToken azureAdJwtToken;

    public HelloController(OAuth2AuthorizedClientService authClientService) {
        this.authClientService = authClientService;
    }

//    @GetMapping("/home")
//    public Object hello(Authentication authentication) {
////        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
////        return ((UserPrincipal) authentication.getPrincipal()).getName();
//        return authentication.getPrincipal();
//    }

    @GetMapping("/home")
    public String user(OAuth2AuthenticationToken authentication) throws JSONException {
        DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
        OAuth2AuthorizedClient authClient = authClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getName());
        OAuth2AccessToken authAccessToken = authClient.getAccessToken();
        return authAccessToken.getTokenValue();
    }

    @GetMapping("/getUsername")
    public String getUsername(OAuth2AuthenticationToken authentication) throws JSONException {
        DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
        OAuth2AuthorizedClient authClient = authClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getName());
        OAuth2AccessToken authAccessToken = authClient.getAccessToken();
        AzureAdJwtToken azureAdJwtToken = new AzureAdJwtToken( authAccessToken.getTokenValue());
        return azureAdJwtToken.getName();
    }

    @GetMapping("/getToken")
    public String getToken(OAuth2AuthenticationToken authentication) throws JSONException {
        DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
        OAuth2AuthorizedClient authClient = authClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getName());
        OAuth2AccessToken authAccessToken = authClient.getAccessToken();
        return authAccessToken.getTokenValue();
    }

    @GetMapping("/getIpAddress")
    public String ipAddress(OAuth2AuthenticationToken authentication) throws JSONException {
        DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
        OAuth2AuthorizedClient authClient = authClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getName());
        OAuth2AccessToken authAccessToken = authClient.getAccessToken();
        String token = authAccessToken.getTokenValue();
        AzureAdJwtToken azureAdJwtToken = new AzureAdJwtToken(token);
        return azureAdJwtToken.getIpAddr();
    }


}