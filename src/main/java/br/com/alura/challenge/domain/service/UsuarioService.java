package br.com.alura.challenge.domain.service;

import br.com.alura.challenge.domain.entity.Usuario;
import br.com.alura.challenge.domain.repository.UsuarioRepository;
import br.com.alura.challenge.dto.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        UserDetails usuarioDetails = usuario.map(usuarioMapper::toDetalharResponse).orElse(null);

        if (Objects.isNull(usuarioDetails)) {
            throw new UsernameNotFoundException("Email " + email + " não encontrado!");
        }
        return usuarioDetails;
    }

    public UserDetails findByNome(String nome) throws UsernameNotFoundException{
        Optional<Usuario> usuario = usuarioRepository.findByNome(nome);
        UserDetails usuarioNome = usuario.map(usuarioMapper::toDetalharResponse).orElse(null);

        if(Objects.isNull(usuarioNome)){
            throw new UsernameNotFoundException("Nome " + nome + " não encontrado!");
        }
        return usuarioNome;
    }
}