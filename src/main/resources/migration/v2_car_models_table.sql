create table car_models
(
    id  uuid primary key,
    name varchar not null
);

insert into car_models (id, name) values
    (gen_random_uuid (), 'BMW X5'),
    (gen_random_uuid (), 'BMW X6'),
    (gen_random_uuid (), 'BMW X7');