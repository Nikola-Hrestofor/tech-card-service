create table if not exists customer
(
    id              serial  primary key,
    title            varchar,
    name            varchar,
    lastName            varchar,
    phone            varchar
);
