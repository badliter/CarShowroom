create table clients
(
    id  uuid primary key,
    phone_number varchar not null,
    fio varchar not null
);

insert into clients (id, fio, phone_number) values
    (gen_random_uuid (), 'Иванов Сергей', '+79107891122'),
    (gen_random_uuid (), 'Коробкин Олег', '+79107891155'),
    (gen_random_uuid (), 'Олейкин Роман', '+79107891166');