create table reports
(
    id  uuid primary key,
    date_purchase date not null,
    model_id uuid references car_models (id) not null,
    client_id uuid references clients (id) not null,
    count int not null,
    cost decimal(12,2) not null
);

insert into reports (id, date_purchase, model_id, client_id, count, cost) values
    (gen_random_uuid (), '2021-10-01', (select id from car_models where name = 'BMW X5'), (select id from clients where phone_number = '+79107891122'), 1, 2000000),
    (gen_random_uuid (), '2021-10-02', (select id from car_models where name = 'BMW X6'), (select id from clients where phone_number = '+79107891155'), 2, 3500000),
    (gen_random_uuid (), '2021-10-02', (select id from car_models where name = 'BMW X7'), (select id from clients where phone_number = '+79107891166'), 1, 2000000),
    (gen_random_uuid (), '2021-10-02', (select id from car_models where name = 'BMW X7'), (select id from clients where phone_number = '+79107891155'), 1, 2000000),
    (gen_random_uuid (), '2021-10-02', (select id from car_models where name = 'BMW X5'), (select id from clients where phone_number = '+79107891155'), 2, 2000000),
    (gen_random_uuid (), '2021-10-03', (select id from car_models where name = 'BMW X6'), (select id from clients where phone_number = '+79107891122'), 1, 3000000);