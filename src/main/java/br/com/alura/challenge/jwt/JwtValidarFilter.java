package br.com.alura.challenge.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class JwtValidarFilter extends BasicAuthenticationFilter {

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";

    public JwtValidarFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        super.doFilterInternal(request, response, chain);

        String atributo = request.getHeader(HEADER);

        if (Objects.isNull(atributo)) {
            chain.doFilter(request, response);
            return;
        }

        if (!atributo.startsWith(PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                getUsernamePasswordAuthenticationToken(atributo.replace(PREFIX, ""));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String token) {
        String usuario = JWT.require(Algorithm.HMAC512(JwtAutenticarFilter.TOKEN_PASS))
                .build()
                .verify(token)
                .getSubject();

        if (Objects.isNull(usuario)) {
            return null;
        }
        return new UsernamePasswordAuthenticationToken(usuario, null, new ArrayList<>());
    }
}