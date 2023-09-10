create table if not exists card
(
    id              serial  primary key,
    name            varchar UNIQUE NOT NULL
);

create table if not exists card_relation_component
(
    id              serial  primary key,
    card_id         serial,
    component_id    serial,
    qty             float
);

create table if not exists component
(
    id              serial  primary key,
    name            varchar,
    unit            varchar,
    category_id     serial,
    code            varchar
);

create table if not exists category
(
    id              serial  primary key,
    name            varchar
);