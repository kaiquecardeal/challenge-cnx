package br.com.alura.challenge.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_perfis_acesso", joinColumns = {
            @JoinColumn(name = "id_usuario")}, inverseJoinColumns = {@JoinColumn(name = "id_perfil_acesso")})
    private Set<PerfilAcesso> perfisAcesso;
}