DROP TABLE IF EXISTS worked_events;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS positions;
DROP TABLE IF EXISTS employee_positions;
DROP TABLE IF EXISTS organization_units;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE employees
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    outer_id  VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL
);

CREATE TABLE positions
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name            VARCHAR NOT NULL,
    organization_id VARCHAR NOT NULL,
    CONSTRAINT positions_id_idx UNIQUE (id)
);

CREATE TABLE employee_positions
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    external_id INTEGER NOT NULL,
    card_number VARCHAR NOT NULL,
    CONSTRAINT employee_positions_id_idx UNIQUE (id)
);

CREATE TABLE organization_units
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    outer_id VARCHAR NOT NULL,
    title    VARCHAR
);

CREATE TABLE worked_events
(
    id                   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    typename             VARCHAR NOT NULL,
    status               VARCHAR NOT NULL,
    type                 VARCHAR NOT NULL,
    day_type             VARCHAR,
    lunch_time           DECIMAL,
    employee_id          INTEGER,
    position_id          INTEGER NOT NULL,
    employee_position_id INTEGER NOT NULL,
    start_date_time      TIMESTAMP,
    end_date_time        TIMESTAMP,
    FOREIGN KEY (employee_id) REFERENCES employees (id),
    FOREIGN KEY (position_id) REFERENCES positions (id),
    FOREIGN KEY (employee_position_id) REFERENCES employee_positions (id)
);