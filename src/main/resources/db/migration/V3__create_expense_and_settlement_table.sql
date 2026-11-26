
CREATE TABLE expenses (

    id BIGINT NOT NULL AUTO_INCREMENT ,
    trip_id BIGINT NOT NULL ,
    paid_by_user_id BIGINT NOT NULL ,
    title VARCHAR(150) NOT NULL ,
    description VARCHAR(1000) NOT NULL ,
    expense_category VARCHAR(20) NOT NULL ,
    amount DECIMAL(12,2) NOT NULL ,
    expense_paid_date DATETIME(6) NOT NULL ,
    created_at DATETIME(6) NOT NULL ,
    updated_at DATETIME(6) NOT NULL ,

    CONSTRAINT pk_expenses_id PRIMARY KEY ( id ) ,
    CONSTRAINT fk_expenses_trip_id FOREIGN KEY ( trip_id ) REFERENCES trips ( id ) ,
    CONSTRAINT fk_expenses_paid_by_user_id FOREIGN KEY ( paid_by_user_id ) REFERENCES users ( id ) ,
    CONSTRAINT chk_expenses_amount_paid CHECK ( amount > 0 )

);

CREATE INDEX idx_expenses_trip_id_and_expense_paid_date ON expenses ( trip_id , expense_paid_date ) ;
CREATE INDEX idx_expenses_paid_by_user_id ON expenses ( paid_by_user_id ) ;


CREATE TABLE expenses_split (

    id BIGINT NOT NULL AUTO_INCREMENT ,
    expense_id BIGINT NOT NULL ,
    user_id BIGINT NOT NULL ,
    split_amount DECIMAL(12,2) NOT NULL ,
    created_at DATETIME(6) NOT NULL ,
    updated_at DATETIME(6) NOT NULL ,

    CONSTRAINT pk_expenses_split_id PRIMARY KEY ( id ) ,
    CONSTRAINT uk_expenses_split_users UNIQUE ( expense_id , user_id ) ,
    CONSTRAINT fk_expenses_split_expense_id FOREIGN KEY ( expense_id ) REFERENCES expenses ( id ) ,
    CONSTRAINT fk_expenses_split_user_id FOREIGN KEY ( user_id ) REFERENCES users ( id ) ,
    CONSTRAINT chk_expenses_split_amount CHECK ( split_amount >= 0 )

);

CREATE INDEX idx_expenses_split_user_id ON expenses_split ( user_id ) ;

CREATE TABLE settlements (

    id BIGINT NOT NULL AUTO_INCREMENT ,
    trip_id BIGINT NOT NULL ,
    payer_id BIGINT NOT NULL ,
    payee_id BIGINT NOT NULL ,
    settlement_amount DECIMAL(12,2) NOT NULL ,
    settlement_amount_paid_date DATETIME(6) NOT NULL ,
    settlement_note VARCHAR(500) NOT NULL ,
    created_at DATETIME(6) NOT NULL ,
    updated_at DATETIME(6) NOT NULL ,

    CONSTRAINT pk_settlements_id PRIMARY KEY ( id ) ,
    CONSTRAINT fk_settlements_trip_id FOREIGN KEY ( trip_id ) REFERENCES trips ( id ) ,
    CONSTRAINT fk_settlements_payer_id FOREIGN KEY ( payer_id ) REFERENCES users ( id ) ,
    CONSTRAINT fk_settlements_payee_id FOREIGN KEY ( payee_id ) REFERENCES users ( id ) ,
    CONSTRAINT chk_settlements_amount CHECK ( settlement_amount > 0 ) ,
    CONSTRAINT chk_settlements_different_users CHECK ( payer_id <> payee_id )

);

CREATE INDEX idx_settlements_trip_id_and_settle_amount_paid_date ON settlements ( trip_id , settlement_amount_paid_date ) ;