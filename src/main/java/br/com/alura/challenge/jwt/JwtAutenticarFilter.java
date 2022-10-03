package br.com.alura.challenge.jwt;

import br.com.alura.challenge.domain.entity.Usuario;
import br.com.alura.challenge.dto.response.UsuarioDetalharResponse;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAutenticarFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRES = 600_000;

    public static final String TOKEN_PASS = "8edd1baf-222a-4b4a-bfef-7d7fba087afa";

    private final AuthenticationManager authenticationManager;

    @Override
    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        usuario.getNome(),
                        usuario.getSenha()
                ));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UsuarioDetalharResponse usuarioDetalharResponse =
                (UsuarioDetalharResponse) authResult
                        .getPrincipal();

        String token = JWT.create()
                .withSubject(usuarioDetalharResponse.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRES))
                .sign(Algorithm.HMAC256(TOKEN_PASS));

        response.getWriter().write(token);
        response.getWriter().flush();
    }
}