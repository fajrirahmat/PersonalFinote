CREATE DATABASE peronal_finote;
use peronal_finote;
create table transaksi(
	id bigint auto_increment not null,
    tanggal datetime not null,
    fromOrTo varchar(128) not null,
    deskripsi varchar(512) not null,
    kredit decimal default 0.0,
    debit decimal default 0.0,
    primary key(id)
);