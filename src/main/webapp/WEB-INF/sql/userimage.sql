# Oracle
create table USERIMAGE (
SEQ number primary key, 
IMAGENAME varchar2(50) not null,
IMAGECONTENT varchar2(4000),
IMAGE1 varchar2(200));

create sequence SEQ_USERIMAGE nocycle nocache;


# MySQL
create table userimage (
seq int(10) primary key auto_increment, 
imageName varchar(50),
imageContent varchar(4000),
imageFileName varchar(100) not null,
imageOriginalName varchar(100) not null);