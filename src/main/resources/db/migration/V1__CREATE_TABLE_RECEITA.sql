create table 'receitas'(
    'id' bigint not null auto_increment,
    'descricao' longtext not null,
    'valor' double not null,
    'data' date not null,
    PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;