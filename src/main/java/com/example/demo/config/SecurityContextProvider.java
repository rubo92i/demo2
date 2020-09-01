package com.example.demo.config;

import com.example.demo.model.Authority;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class SecurityContextProvider {


    @Autowired
    private ResourceServerTokenServices resourceServerTokenServices;

    @Autowired
    private TokenProvider tokenProvider;

    @SuppressWarnings("unchecked")
    public User getByAuthentication(OAuth2Authentication oAuth2Authentication) {


        OAuth2AccessToken oAuth2AccessToken = resourceServerTokenServices.readAccessToken(tokenProvider.getTokenValue(oAuth2Authentication));
        Map<String, Object> additional = oAuth2AccessToken.getAdditionalInformation();

        User user = new User();
        user.setId((Integer) additional.get("userId"));
        user.setUsername(additional.get("username").toString());
        user.setName(additional.get("name").toString());

        HashMap<Integer, String> roles = (HashMap<Integer, String>) additional.get("roles");
        Set<Authority> authorities = new HashSet<>();
        roles.forEach((key, value) -> authorities.add(new Authority(key, value)));
        //user.setAuthorities(authorities);

        return user;
    }

    public String readTokenValue(OAuth2Authentication auth2Authentication) {
        return tokenProvider.getTokenValue(auth2Authentication);
    }
}
