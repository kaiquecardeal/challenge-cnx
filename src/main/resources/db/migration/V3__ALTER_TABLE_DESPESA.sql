alter table 'despesa'
    ADD COLUMN 'categoria' int not null default '0' after 'data';