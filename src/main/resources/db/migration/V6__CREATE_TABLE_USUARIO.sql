CREATE TABLE IF NOT EXISTS 'usuarios' (
    'id' bigint not null auto_increment,
    'nome' varchar(255) default null,
    'email' varchar(255) default null,
    'senha' varchar(255) default null,
    PRIMARY KEY('id')
    UNIQUE KEY 'uk_email' ('email'),
    UNIQUE KEY 'uk_nome' ('nome')
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;