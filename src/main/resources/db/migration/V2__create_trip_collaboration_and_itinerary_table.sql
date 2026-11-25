
CREATE TABLE trip_members (

    id BIGINT NOT NULL AUTO_INCREMENT ,
    trip_id BIGINT NOT NULL ,
    user_id BIGINT NOT NULL ,
    trip_member_role VARCHAR(20) NOT NULL DEFAULT 'VIEWER' ,
    joined_at DATETIME(6) NOT NULL ,
    created_at DATETIME(6) NOT NULL ,
    updated_at DATETIME(6) NOT NULL ,

    CONSTRAINT pk_trip_members PRIMARY KEY ( id ) ,
    CONSTRAINT uk_trip_members_user_id_and_trip_id UNIQUE ( trip_id , user_id ) ,
    CONSTRAINT fk_trip_members_trip_id FOREIGN KEY ( trip_id ) REFERENCES trips ( id ) ,
    CONSTRAINT fk_trip_members_user_id FOREIGN KEY ( user_id ) REFERENCES users ( id )

);

CREATE INDEX idx_trip_members_user_id ON trip_members ( user_id ) ;

CREATE TABLE invitations (

    id BIGINT NOT NULL AUTO_INCREMENT ,
    trip_id BIGINT NOT NULL ,
    invited_by_user_id BIGINT NOT NULL ,
    invitee_email VARCHAR(150) NOT NULL ,
    proposed_role VARCHAR(20) NOT NULL DEFAULT 'VIEWER' ,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING' ,
    expires_at DATETIME(6) NOT NULL ,
    created_at DATETIME(6) NOT NULL ,
    updated_at DATETIME(6) NOT NULL ,

    CONSTRAINT pk_invitations PRIMARY KEY ( id ) ,
    CONSTRAINT fk_invitations_trip_id FOREIGN KEY ( trip_id ) REFERENCES trips ( id ) ,
    CONSTRAINT fk_invitations_invited_by_user_id FOREIGN KEY ( invited_by_user_id ) REFERENCES users ( id )

);

CREATE INDEX idx_invitations_invitee_email_and_status ON invitations ( invitee_email , status ) ;

CREATE TABLE itineraries (

    id BIGINT NOT NULL AUTO_INCREMENT ,
    trip_id BIGINT NOT NULL ,
    itinerary_date DATETIME(6) NOT NULL ,
    notes VARCHAR(1000) NOT NULL ,
    created_at DATETIME(6) NOT NULL ,
    updated_at DATETIME(6) NOT NULL ,

    CONSTRAINT pk_itineraries PRIMARY KEY ( id ) ,
    CONSTRAINT uk_itineraries_trip_date UNIQUE ( trip_id , itinerary_date ) ,
    CONSTRAINT fk_itineraries_trip_id FOREIGN KEY ( trip_id ) REFERENCES trips ( id )

);

CREATE INDEX idx_itineraries_trip_id_and_itinerary_date ON itineraries ( trip_id , itinerary_date ) ;

CREATE TABLE activities (

    id BIGINT NOT NULL AUTO_INCREMENT ,
    itinerary_id BIGINT NOT NULL ,
    title VARCHAR(150) NOT NULL ,
    description VARCHAR(1000) NOT NULL ,
    location VARCHAR(250) NOT NULL ,
    start_time DATETIME(6) NOT NULL ,
    end_time DATETIME(6) NOT NULL ,
    estimated_cost DECIMAL(12,2) NOT NULL ,
    display_order INT NOT NULL ,
    created_at DATETIME(6) NOT NULL ,
    updated_at DATETIME(6) NOT NULL ,

    CONSTRAINT pk_activities PRIMARY KEY ( id ) ,
    CONSTRAINT fk_itinerary_id FOREIGN KEY ( itinerary_id ) REFERENCES itineraries ( id )

);

CREATE INDEX idx_activities_itinerary_id_and_display_order ON activities ( itinerary_id , display_order ) ;