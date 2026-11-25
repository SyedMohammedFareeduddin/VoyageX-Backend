
CREATE TABLE users (

    id BIGINT NOT NULL AUTO_INCREMENT ,
    fullname VARCHAR(100) NOT NULL ,
    email VARCHAR(150) NOT NULL ,
    password_hash VARCHAR(100) NOT NULL ,
    role VARCHAR(20) NOT NULL DEFAULT 'USER' ,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' ,
    created_at DATETIME(6) NOT NULL ,
    updated_at DATETIME(6) NOT NULL ,

    CONSTRAINT pk_users PRIMARY KEY ( id ) ,
    CONSTRAINT uk_users_email UNIQUE ( email )

);

CREATE TABLE trips (

    id BIGINT NOT NULL AUTO_INCREMENT ,
    title VARCHAR(150) NOT NULL ,
    destination VARCHAR(150) NOT NULL ,
    description VARCHAR(1000) NOT NULL ,
    budget DECIMAL(12,2) NOT NULL ,
    trip_start_date DATETIME(6) NOT NULL ,
    trip_end_date DATETIME(6) NOT NULL ,
    trip_status VARCHAR(20) NOT NULL DEFAULT 'PLANNED' ,
    trip_owner_id BIGINT NOT NULL ,
    created_at DATETIME(6) NOT NULL ,
    updated_at DATETIME(6) NOT NULL ,

    CONSTRAINT pk_trips PRIMARY KEY ( id ) ,
    CONSTRAINT fk_trips_owner FOREIGN KEY ( trip_owner_id ) REFERENCES users ( id )

);