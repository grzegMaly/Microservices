package com.eazybytes.gatewayserver.config;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(@NonNull Jwt source) {

        if (!(source.getClaims().get("realm_access") instanceof Map<?, ?> rA)
                || rA.isEmpty() || !(rA.get("roles") instanceof List<?> rV)) {
            return new ArrayList<>();
        }

        return rV.stream()
                .filter(String.class::isInstance)
                .map(String.class::cast)
                .map("ROLE_"::concat)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
