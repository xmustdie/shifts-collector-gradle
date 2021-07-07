DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS positions;
DROP TABLE IF EXISTS employee_positions;
DROP TABLE IF EXISTS worked_events;
DROP TABLE IF EXISTS organization_unit;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE worked_events
(
    id                   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    status               VARCHAR NOT NULL,
    type                 VARCHAR NOT NULL,
    day_type             VARCHAR NOT NULL,
    lunch_time           DECIMAL,
    employee_id          INTEGER NOT NULL,
    position_id          INTEGER NOT NULL,
    employee_position_id INTEGER NOT NULL,
    start_date_time      TIMESTAMP,
    end_date_time        TIMESTAMP
);
CREATE UNIQUE INDEX shifts_unique_id_idx ON worked_events (id);

CREATE TABLE employees
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    outer_id  VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    CONSTRAINT employees_outer_id_idx UNIQUE (id, outer_id),
    FOREIGN KEY (id) REFERENCES worked_events (id)
);

CREATE TABLE positions
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name            VARCHAR NOT NULL,
    organization_id INTEGER NOT NULL,
    CONSTRAINT positions_id_idx UNIQUE (id),
    FOREIGN KEY (id) REFERENCES worked_events (id)
);

CREATE TABLE employee_positions
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    external_id INTEGER NOT NULL,
    card_number INTEGER NOT NULL,
    CONSTRAINT employee_positions_id_idx UNIQUE (id),
    FOREIGN KEY (id) REFERENCES worked_events (id)
);

CREATE TABLE organization_units
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    outer_id VARCHAR NOT NULL
)