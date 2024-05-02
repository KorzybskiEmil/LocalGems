create table if not exists application_user
(
    id       uuid not null,
    email    varchar(255) unique,
    nickname varchar(255) unique,
    password varchar(255),
    primary key (id)
);

create table if not exists car
(
    body_type           smallint check (body_type between 0 and 3),
    drive_type          smallint check (drive_type between 0 and 2),
    engine_power        integer not null,
    fuel_type           smallint check (fuel_type between 0 and 2),
    mileage             integer not null,
    price               integer not null,
    technical_condition smallint check (technical_condition between 0 and 2),
    transmission_type   smallint check (transmission_type between 0 and 1),
    year_of_production  integer not null,
    id                  uuid    not null,
    user_id             uuid,
    brand               varchar(255),
    colour              varchar(255),
    country_of_origin   varchar(255),
    model               varchar(255),
    seller_description  varchar(255),
    primary key (id)
);

create table if not exists games_and_consoles
(
    platform            smallint check (platform between 0 and 3),
    price               integer not null,
    sub_category        smallint check (sub_category between 0 and 2),
    technical_condition smallint check (technical_condition between 0 and 2),
    id                  uuid    not null,
    user_id             uuid,
    description         varchar(255),
    name                varchar(255),
    primary key (id)
);

create table if not exists music_and_education
(
    category_type smallint check (category_type between 0 and 3),
    price         integer not null,
    id            uuid    not null,
    user_id       uuid,
    description   varchar(255),
    name          varchar(255),
    primary key (id)
);

create table if not exists real_estate
(
    floor           smallint check (floor between 0 and 4),
    furnitured      smallint check (furnitured between 0 and 1),
    housing_type    smallint check (housing_type between 0 and 1),
    number_of_rooms integer not null,
    price           integer not null,
    sub_category    smallint check (sub_category between 0 and 2),
    surface_area    integer not null,
    id              uuid    not null,
    user_id         uuid,
    description     varchar(255),
    primary key (id)
);

create table if not exists role
(
    id   uuid not null,
    name varchar(255),
    primary key (id)
);

create table if not exists sports
(
    condition   smallint check (condition between 0 and 2),
    price       integer not null,
    id          uuid    not null,
    user_id     uuid,
    description varchar(255),
    name        varchar(255),
    primary key (id)
);

create table if not exists user_role
(
    role_id uuid not null,
    user_id uuid not null
);

create table if not exists users
(
    id       uuid not null,
    email    varchar(255),
    password varchar(255),
    primary key (id)
);

create table if not exists various_services
(
    price_per_hour  integer not null,
    service_options smallint check (service_options between 0 and 5),
    id              uuid    not null,
    user_id         uuid,
    description     varchar(255),
    primary key (id)
);

create table if not exists work
(
    employment_type     smallint check (employment_type between 0 and 1),
    experience_required smallint check (experience_required between 0 and 1),
    place_of_work       smallint check (place_of_work between 0 and 1),
    working_hours       smallint check (working_hours between 0 and 1),
    id                  uuid not null,
    user_id             uuid,
    city_where_is_work  varchar(255),
    description         varchar(255),
    primary key (id)
);

alter table if exists car
    add constraint PK_CAR foreign key (user_id) references application_user;

alter table if exists games_and_consoles
    add constraint PK_GAC foreign key (user_id) references application_user;

alter table if exists music_and_education
    add constraint PK_MAE foreign key (user_id) references application_user;

alter table if exists real_estate
    add constraint PK_RE foreign key (user_id) references application_user;

alter table if exists sports
    add constraint PK_SPORTS foreign key (user_id) references application_user;

alter table if exists user_role
    add constraint PK_UR1 foreign key (role_id) references role;

alter table if exists user_role
    add constraint PK_UR2 foreign key (user_id) references users;

alter table if exists various_services
    add constraint PK_VS foreign key (user_id) references application_user;

alter table if exists work
    add constraint PK_WORK foreign key (user_id) references application_user;

insert into role (id, name)
VALUES (gen_random_uuid(), 'USER');§