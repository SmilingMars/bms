create table book
(
    id        bigint(20) primary key auto_increment,
    name      varchar(64),
    author    varchar(16),
    isbn      varchar(24),
    user_id   bigint(20),
    is_delete tinyint(1)
);