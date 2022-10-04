INSERT INTO usuarios
(id, nome, email, senha)
VALUES(1, 'ADM', 'adm@gmail.com', '12345'),
(2, 'Usuario', 'usuario@gmail.com' '12345')

INSERT INTO usuarios_perfis_acesso
(id_usuario, id_perfil_acesso)
VALUES(1, 2), (1, 1), (2, 1);