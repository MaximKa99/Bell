CREATE TABLE IF NOT EXISTS Organization (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER default 0,
    name VARCHAR(30) NOT NULL,
    full_name VARCHAR(60) NOT NULL,
    address VARCHAR(100) NOT NULL,
    inn VARCHAR(12) NOT NULL,
    kpp VARCHAR(9) NOT NULL,
    phone VARCHAR(15),
    is_active BOOLEAN
);

CREATE TABLE IF NOT EXISTS Office (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER default 0,
    org_id INTEGER,
    FOREIGN KEY (org_id) REFERENCES Organization(id),
    name VARCHAR(60) NOT NULL,
    address VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    is_active BOOLEAN
);

CREATE TABLE IF NOT EXISTS type_of_document  (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER default 0,
    code INTEGER NOT NULL,
    name VARCHAR(115) NOT NULL
);

CREATE TABLE IF NOT EXISTS country (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER default 0,
    code INTEGER  NOT NULL,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS User (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER default 0,
    office_id INTEGER,
    FOREIGN KEY (office_id) REFERENCES Office(id),
    first_name VARCHAR(30) NOT NULL,
    second_name VARCHAR(30),
    middle_name VARCHAR(30),
    position VARCHAR(50) NOT NULL,
    phone VARCHAR(15),
    citizenship_id INTEGER,
    FOREIGN KEY (citizenship_id) REFERENCES country(id),
    is_identified BOOLEAN
);

CREATE TABLE IF NOT EXISTS document (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER default 0,
    type_id INTEGER,
    doc_date DATE,
    doc_number VARCHAR(15),
    doc_name VARCHAR(50),
    FOREIGN KEY (type_id) REFERENCES type_of_document(id),
    FOREIGN KEY (id) REFERENCES User(id)
);

CREATE INDEX IX_Office_Org_Id ON Office (org_id);
CREATE INDEX IX_User_Office_Id ON User (office_id);
CREATE INDEX IX_Citizenship_Id ON user (citizenship_id);
CREATE INDEX IX_Document_Id ON Document(type_id);