CREATE TABLE IF NOT EXISTS application_user
(
    id       uuid PRIMARY KEY,
    username varchar(250) unique,
    password varchar(250)
);

CREATE TABLE IF NOT EXISTS car
(
    id                  uuid PRIMARY KEY,
    brand               varchar(250),
    model               varchar(250),
    body_type           smallint,
    price               int,
    year_of_production  int,
    mileage             int,
    engine_power        int,
    seller_description  varchar(250),
    country_of_origin   varchar(250),
    colour              varchar(250),
    transmission_type   smallint,
    fuel_type           smallint,
    drive_type          smallint,
    technical_condition smallint,
    application_user_id uuid,
    FOREIGN KEY (application_user_id) REFERENCES application_user (id)
);

CREATE TABLE IF NOT EXISTS games_and_consoles
(
    id                  uuid PRIMARY KEY,
    name                varchar(250),
    sub_category        smallint,
    platform            smallint,
    price               int,
    technical_condition smallint,
    description         varchar(250),
    application_user_id uuid,
    FOREIGN KEY (application_user_id) REFERENCES application_user (id)
);

CREATE TABLE IF NOT EXISTS music_and_education
(
    id                  uuid PRIMARY KEY,
    category_type       smallint,
    name                varchar(250),
    price               int,
    description         varchar(250),
    application_user_id uuid,
    FOREIGN KEY (application_user_id) REFERENCES application_user (id)
);

CREATE TABLE IF NOT EXISTS real_estate
(
    id                  uuid PRIMARY KEY,
    sub_category        smallint,
    housing_type        smallint,
    price               int,
    surface_area        int,
    floor               smallint,
    furnitured          smallint,
    number_of_rooms     int,
    description         varchar(250),
    application_user_id uuid,
    FOREIGN KEY (application_user_id) REFERENCES application_user (id)
);

CREATE TABLE IF NOT EXISTS sports
(
    id                  uuid PRIMARY KEY,
    name                varchar(250),
    price               int,
    condition           smallint,
    description         varchar(250),
    application_user_id uuid,
    FOREIGN KEY (application_user_id) REFERENCES application_user (id)
);

CREATE TABLE IF NOT EXISTS various_services
(
    id                  uuid PRIMARY KEY,
    service_options     smallint,
    description         varchar(250),
    price_per_hour      int,
    application_user_id uuid,
    FOREIGN KEY (application_user_id) REFERENCES application_user (id)
);

CREATE TABLE IF NOT EXISTS work
(
    id                  uuid PRIMARY KEY,
    employment_type     smallint,
    working_hours       smallint,
    experience_required smallint,
    place_of_work       smallint,
    city_where_is_work  varchar(250),
    description         varchar(250),
    application_user_id uuid,
    FOREIGN KEY (application_user_id) REFERENCES application_user (id)
);

CREATE TABLE IF NOT EXISTS role
(
    id   uuid PRIMARY KEY,
    name varchar(250)
);

CREATE TABLE IF NOT EXISTS application_user_role
(
    role_id             uuid,
    application_user_id uuid,
    FOREIGN KEY (role_id) REFERENCES role (id),
    FOREIGN KEY (application_user_id) REFERENCES application_user (id)
);

INSERT INTO role (id, name)
SELECT gen_random_uuid(), 'USER'
WHERE NOT EXISTS (SELECT * FROM role)