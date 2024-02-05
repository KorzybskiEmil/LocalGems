CREATE TABLE application_user
(
    id       UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    nickname VARCHAR(50) NOT NULL UNIQUE,
    email    VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE car
(
    id                 UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    brand              VARCHAR(50)  NOT NULL,
    model              VARCHAR(50)  NOT NULL,
    bodyType           VARCHAR(50)  NOT NULL,
    price              INT          NOT NULL,
    yearOfProduction   INT          NOT NULL,
    mileage            INT          NOT NULL,
    enginePower        INT          NOT NULL,
    sellerDescription  VARCHAR(100) NOT NULL,
    countryOfOrigin    VARCHAR(50)  NOT NULL,
    colour             VARCHAR(50)  NOT NULL,
    transmissionType   VARCHAR(50)  NOT NULL,
    fuelType           VARCHAR(50)  NOT NULL,
    driveType          VARCHAR(50)  NOT NULL,
    technicalCondition VARCHAR(50)  NOT NULL
);

CREATE TABLE games_and_consoles
(
    id                 UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name               VARCHAR(50)  NOT NULL,
    subCategory        VARCHAR(50)  NOT NULL,
    platform           VARCHAR(50)  NOT NULL,
    price              INT          NOT NULL,
    technicalCondition VARCHAR(50)  NOT NULL,
    description        VARCHAR(100) NOT NULL
);

CREATE TABLE music_and_education
(
    id           UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    categoryType VARCHAR(50)  NOT NULL,
    name         VARCHAR(50)  NOT NULL,
    price        INT          NOT NULL,
    description  VARCHAR(100) NOT NULL
);

CREATE TABLE real_estate
(
    id            UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    subcategory   VARCHAR(50)  NOT NULL,
    housingType   VARCHAR(50)  NOT NULL,
    price         INT          NOT NULL,
    surfaceArea   INT          NOT NULL,
    floor         VARCHAR(50)  NOT NULL,
    furnitured    VARCHAR(50)  NOT NULL,
    numberOfRooms INT          NOT NULL,
    description   VARCHAR(100) NOT NULL
);

CREATE TABLE sports
(
    id          UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name        VARCHAR(50)  NOT NULL,
    price       INT          NOT NULL,
    condition   VARCHAR(50)  NOT NULL,
    description VARCHAR(100) NOT NULL
);

CREATE TABLE various_services
(
    id             UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    serviceOptions VARCHAR(50)  NOT NULL,
    description    VARCHAR(100) NOT NULL,
    pricePerHour   INT          NOT NULL
);

CREATE TABLE work
(
    id                 UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    employmentType     VARCHAR(50)  NOT NULL,
    workingHours       VARCHAR(50)  NOT NULL,
    experienceRequired VARCHAR(50)  NOT NULL,
    placeOfWork        VARCHAR(50)  NOT NULL,
    cityWhereIsWork    Varchar(50)  NOT NULL,
    description        VARCHAR(100) NOT NULL
);