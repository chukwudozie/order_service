create table category (
                          id bigint not null auto_increment primary key,
                          description varchar(50),
                          created_date timestamp,
                          updated_time timestamp
);

create table product_category (
                                  product_id bigint not null,
                                  category_id bigint not null,
                                  primary key (product_id, category_id),
                                  constraint pc_product_id_fk FOREIGN KEY (product_id) references product(id),
                                  constraint pc_category_id_fk FOREIGN KEY (category_id) references category(id)
);

insert into product (product_name, product_status, created_date, updated_time)
values ('PRODUCT1', 'NEW', now(), now());

insert into product (product_name, product_status, created_date, updated_time)
values ('PRODUCT2', 'NEW', now(), now());

insert into product (product_name, product_status, created_date, updated_time)
values ('PRODUCT3', 'NEW', now(), now());

insert into product (product_name, product_status, created_date, updated_time)
values ('PRODUCT4', 'NEW', now(), now());

insert into category (description, created_date, updated_time) VALUES
    ('CAT1', now(), now());

insert into category (description, created_date, updated_time) VALUES
    ('CAT2', now(), now());

insert into category (description, created_date, updated_time) VALUES
    ('CAT3', now(), now());

insert into product_category (product_id, category_id)
SELECT p.id, c.id FROM product p, category c
where p.product_name = 'PRODUCT1' and c.description = 'CAT1';

insert into product_category (product_id, category_id)
SELECT p.id, c.id FROM product p, category c
where p.product_name = 'PRODUCT2' and c.description = 'CAT1';

insert into product_category (product_id, category_id)
SELECT p.id, c.id FROM product p, category c
where p.product_name = 'PRODUCT1' and c.description = 'CAT3';

insert into product_category (product_id, category_id)
SELECT p.id, c.id FROM product p, category c
where p.product_name = 'PRODUCT4' and c.description = 'CAT3';