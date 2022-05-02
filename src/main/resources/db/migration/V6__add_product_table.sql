drop table if exists product;
create table product
(
    id        bigint not null auto_increment primary key,
    price      numeric (19,2),
    product_name varchar(40),
    product_status varchar(40),
    created_date timestamp,
    updated_time timestamp
) engine = InnoDB;