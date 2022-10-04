create table 'usuarios_perfis_acesso'(
    'id_usuario' bigint not null,
    'id_perfil_acesso' bigint not null,
    KEY 'usuarios_perfis_acesso_FK' ('id_usuarios'),
    KEY 'usuarios_perfis_acesso_FK_1'('id_perfil_acesso'),
    CONSTRAINT 'usuarios_perfis_acesso_FK' FOREIGN ('id_usuario') REFERENCES 'usuarios' ('id'),
    CONSTRAINT 'usuarios_perfis_acesso_FK_1' FOREIGN ('id_perfil_acesso') REFERENCES 'perfis_acesso' ('id')
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;