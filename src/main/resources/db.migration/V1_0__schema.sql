CREATE TABLE IF NOT EXISTS application_user
(
    id       UUID PRIMARY KEY,
    nickname VARCHAR(250),
    email    VARCHAR(250),
    password VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS car
(
    id                  UUID PRIMARY KEY,
    brand               VARCHAR(250),
    model               VARCHAR(250),
    body_type           VARCHAR(250),
    price               INT,
    year_of_production  INT,
    mileage             INT,
    engine_power        INT,
    seller_description  VARCHAR(250),
    country_of_origin   VARCHAR(250),
    colour              VARCHAR(250),
    transmission_type   VARCHAR(250),
    fuel_type           VARCHAR(250),
    drive_type          VARCHAR(250),
    technical_condition VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS games_and_consoles
(
    id                  UUID PRIMARY KEY,
    name                VARCHAR(250),
    sub_category        VARCHAR(250),
    platform            VARCHAR(250),
    technical_condition VARCHAR(250),
    description         VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS music_and_education
(
    id            UUID PRIMARY KEY,
    category_type VARCHAR(250),
    name          VARCHAR(250),
    price         INT,
    description   VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS real_estate
(
    id              UUID PRIMARY KEY,
    sub_category    VARCHAR(250),
    housing_type    VARCHAR(250),
    price           INT,
    surface_area    INT,
    floor           VARCHAR(250),
    furnitured      VARCHAR(250),
    number_of_rooms INT,
    description     VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS sports
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(250),
    price       INT,
    condition   VARCHAR(250),
    description VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS various_services
(
    id              UUID PRIMARY KEY,
    service_options VARCHAR(250),
    description     VARCHAR(250),
    price_per_hour  INT
);

CREATE TABLE IF NOT EXISTS work
(
    id                  UUID PRIMARY KEY,
    employment_type     VARCHAR(50),
    working_hours       VARCHAR(50),
    experience_required VARCHAR(50),
    place_of_work       VARCHAR(100),
    city_where_is_work  VARCHAR(50),
    description         VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS role
(
    id UUID PRIMARY KEY,
    name VARCHAR(50)
);


