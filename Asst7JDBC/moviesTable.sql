create table movies (
    id number(9) primary key,
    name varchar2(50) unique,
    language varchar2(50),
    relasedate Date
);