-- tables
-- Table: car
CREATE TABLE car (
    id bigint  NOT NULL,
    car_category_id bigint  NOT NULL,
    brand varchar(255)  NOT NULL,
    model varchar(255)  NOT NULL,
    production_year int  NOT NULL,
    mileage int  NOT NULL,
    color varchar(255)  NOT NULL,
    current_location_id bigint  NOT NULL,
    CONSTRAINT car_pk PRIMARY KEY (id)
);

-- Table: car_category
CREATE TABLE car_category (
    id bigint NOT NULL,
    name varchar(255)  NOT NULL,
    rental_value money  NOT NULL,
    CONSTRAINT car_category_pk PRIMARY KEY (id)
);

-- Table: car_equipment
CREATE TABLE car_equipment (
    id bigint  NOT NULL,
    equipment_id bigint  NOT NULL,
    car_id bigint  NOT NULL,
    start_date date  NOT NULL,
    end_date date  NULL,
    CONSTRAINT car_equipment_pk PRIMARY KEY (id)
);

-- Table: customer
CREATE TABLE customer (
    id bigint  NOT NULL,
    first_name varchar(255)  NOT NULL,
    last_name varchar(255)  NOT NULL,
    birth_date date  NOT NULL,
    gender char NOT NULL,
    driving_license_number varchar(255)  NOT NULL,
    driving_license_issue_dt date  NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY (id)
);

-- Table: equipment
CREATE TABLE equipment (
    id bigint  NOT NULL,
    name varchar(255)  NOT NULL,
    equipment_category_id bigint  NOT NULL,
    current_location_id bigint  NOT NULL,
    CONSTRAINT equipment_pk PRIMARY KEY (id)
);

-- Table: equipment_category
CREATE TABLE equipment_category (
    id bigint  NOT NULL,
    name varchar(255)  NOT NULL,
    rental_value numeric  NOT NULL,
    CONSTRAINT equipment_category_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
    id bigint  NOT NULL,
    street_address varchar(100)  NOT NULL,
    city varchar(50)  NOT NULL,
    state varchar(50)  NOT NULL,
    country varchar(50)  NOT NULL,
    zip varchar(50)  NOT NULL,
    CONSTRAINT location_zip_ux UNIQUE (zip) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: rental
CREATE TABLE rental (
    id bigint  NOT NULL,
    customer_id bigint  NOT NULL,
    car_id bigint  NOT NULL,
    pick_up_location_id bigint  NOT NULL,
    drop_off_location_id bigint  NOT NULL,
    start_date date  NOT NULL,
    end_date date  NULL,
    remarks text  NOT NULL,
    CONSTRAINT rental_pk PRIMARY KEY (id)
);

-- Table: rental_invoice
CREATE TABLE rental_invoice (
    id bigint  NOT NULL,
    rental_id bigint  NOT NULL,
    car_rent numeric  NOT NULL,
    equipment_rent_total numeric  NULL,
    insurance_cost_total numeric  NULL,
    service_tax numeric  NOT NULL,
    VAT numeric  NOT NULL,
    total_amount_payable numeric  NOT NULL,
    discount_amount numeric  NULL,
    net_amount_payable numeric  NOT NULL,
    CONSTRAINT rental_invoice_pk PRIMARY KEY (id)
);

-- Table: reservation
CREATE TABLE reservation (
    id bigint  NOT NULL,
    pick_up_location_id bigint  NOT NULL,
    drop_off_location_id bigint  NOT NULL,
    car_category_id bigint  NOT NULL,
    customer_id bigint  NOT NULL,
    CONSTRAINT reservation_pk PRIMARY KEY (id)
);

-- Table: reservation_equipment
CREATE TABLE reservation_equipment (
    reservation_id bigint  NOT NULL,
    equipment_category_id bigint  NOT NULL,
    CONSTRAINT reservation_equipment_pk PRIMARY KEY (reservation_id,equipment_category_id)
);

-- foreign keys
-- Reference: car_category (table: car)
ALTER TABLE car ADD CONSTRAINT car_category
    FOREIGN KEY (car_category_id)
    REFERENCES car_category (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: car_equipment_car (table: car_equipment)
ALTER TABLE car_equipment ADD CONSTRAINT car_equipment_car
    FOREIGN KEY (car_id)
    REFERENCES car (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: car_equipment_equipment (table: car_equipment)
ALTER TABLE car_equipment ADD CONSTRAINT car_equipment_equipment
    FOREIGN KEY (equipment_id)
    REFERENCES equipment (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: car_location (table: car)
ALTER TABLE car ADD CONSTRAINT car_location
    FOREIGN KEY (current_location_id)
    REFERENCES location (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: equipment_equipment_category (table: equipment)
ALTER TABLE equipment ADD CONSTRAINT equipment_equipment_category
    FOREIGN KEY (equipment_category_id)
    REFERENCES equipment_category (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: equipment_location (table: equipment)
ALTER TABLE equipment ADD CONSTRAINT equipment_location
    FOREIGN KEY (current_location_id)
    REFERENCES location (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: rental_car (table: rental)
ALTER TABLE rental ADD CONSTRAINT rental_car
    FOREIGN KEY (car_id)
    REFERENCES car (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: rental_customer (table: rental)
ALTER TABLE rental ADD CONSTRAINT rental_customer
    FOREIGN KEY (customer_id)
    REFERENCES customer (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: rental_invoice_rental (table: rental_invoice)
ALTER TABLE rental_invoice ADD CONSTRAINT rental_invoice_rental
    FOREIGN KEY (rental_id)
    REFERENCES rental (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: rental_location (table: rental)
ALTER TABLE rental ADD CONSTRAINT rental_location
    FOREIGN KEY (drop_off_location_id)
    REFERENCES location (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: rental_pick_up_location (table: rental)
ALTER TABLE rental ADD CONSTRAINT rental_pick_up_location
    FOREIGN KEY (pick_up_location_id)
    REFERENCES location (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: reservation_category (table: reservation)
ALTER TABLE reservation ADD CONSTRAINT reservation_category
    FOREIGN KEY (car_category_id)
    REFERENCES car_category (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: reservation_customer (table: reservation)
ALTER TABLE reservation ADD CONSTRAINT reservation_customer
    FOREIGN KEY (customer_id)
    REFERENCES customer (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: reservation_equipment_equipment_category (table: reservation_equipment)
ALTER TABLE reservation_equipment ADD CONSTRAINT reservation_equipment_equipment_category
    FOREIGN KEY (equipment_category_id)
    REFERENCES equipment_category (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: reservation_equipment_reservation (table: reservation_equipment)
ALTER TABLE reservation_equipment ADD CONSTRAINT reservation_equipment_reservation
    FOREIGN KEY (reservation_id)
    REFERENCES reservation (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: reservation_location (table: reservation)
ALTER TABLE reservation ADD CONSTRAINT reservation_location
    FOREIGN KEY (drop_off_location_id)
    REFERENCES location (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: reservation_pick_up_location (table: reservation)
ALTER TABLE reservation ADD CONSTRAINT reservation_pick_up_location
    FOREIGN KEY (pick_up_location_id)
    REFERENCES location (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- End of file.

