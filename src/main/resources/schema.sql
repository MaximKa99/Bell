CREATE TABLE IF NOT EXISTS Organization (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL UNIQUE,
    full_name VARCHAR(60) NOT NULL UNIQUE,
    address VARCHAR(100) NOT NULL,
    inn VARCHAR(12) NOT NULL UNIQUE,
    kpp VARCHAR(9) NOT NULL UNIQUE,
    phone VARCHAR(15),
    is_active BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS Office (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    org_id INTEGER,
    FOREIGN KEY (org_id) REFERENCES Organization(id),
    name VARCHAR(60) NOT NULL,
    address VARCHAR(100) NOT NULL,
    phone VARCHAR(20) UNIQUE,
    is_active BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS type_of_document  (
    id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(115) NOT NULL,
    code INTEGER NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS document (
    id INTEGER PRIMARY KEY NOT NULL,
    type INTEGER,
    FOREIGN KEY (type) REFERENCES type_of_document(id),
    doc_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS country (
    id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    code INTEGER NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS User (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    office_id INTEGER,
    FOREIGN KEY (office_id) REFERENCES Office(id),
    first_name VARCHAR(30) NOT NULL,
    second_name VARCHAR(30) NOT NULL,
    middle_name VARCHAR(30) NOT NULL,
    position VARCHAR(50) NOT NULL,
    phone VARCHAR(15),
    FOREIGN KEY (id) REFERENCES document(id),
    citizenship_id INTEGER,
    FOREIGN KEY (citizenship_id) REFERENCES country(id),
    is_indentified BOOLEAN NOT NULL
);

CREATE INDEX IX_Organization_Id ON Organization (id);
CREATE INDEX IX_Office_Id ON Office (id);
CREATE INDEX UX_Document_Id ON document (id);
CREATE INDEX IX_County_Id ON country (id);
CREATE INDEX IX_Type_Of_Document_Id ON type_of_document(id);