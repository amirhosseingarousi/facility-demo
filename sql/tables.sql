CREATE DATABASE 'facilities';
USE facilities;

create table private_customer (
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    father_name varchar(50) NOT NULL ,
    date_of_birth date NOT NULL,
    national_id varchar(20) NOT NULL,
    number varchar(50),
    PRIMARY KEY (id)
);

insert into private_customer (first_name, last_name, father_name, date_of_birth, national_id)
values ('Ali', 'Ahmadi', 'Mohammda', '1998-03-12', '1234321');