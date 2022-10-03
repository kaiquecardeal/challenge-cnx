package br.com.alura.challenge.dto.mapper;

import br.com.alura.challenge.domain.entity.Usuario;
import br.com.alura.challenge.dto.response.UsuarioDetalharResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDetalharResponse toDetalharResponse(Usuario usuario);
}