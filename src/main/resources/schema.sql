CREATE TABLE IF NOT EXISTS Organization (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    full_name VARCHAR(60) NOT NULL,
    address VARCHAR(100) NOT NULL,
    inn VARCHAR(12) NOT NULL,
    kpp VARCHAR(9) NOT NULL,
    phone VARCHAR(15),
    is_active BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS Office (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    org_id INTEGER,
    FOREIGN KEY (org_id) REFERENCES Organization(id),
    name VARCHAR(60) NOT NULL,
    address VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    is_active BOOLEAN
);

CREATE TABLE IF NOT EXISTS type_of_document  (
    code INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(115) NOT NULL
);

CREATE TABLE IF NOT EXISTS country (
    code INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL
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
    citizenship_code INTEGER,
    FOREIGN KEY (citizenship_code) REFERENCES country(code),
    is_indentified BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS document (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    type INTEGER,
    doc_date DATE,
    doc_number INTEGER,
    doc_name VARCHAR(50),
    FOREIGN KEY (type) REFERENCES type_of_document(code),
    FOREIGN KEY (id) REFERENCES User(id)
);

//TODO поменять индексы

CREATE INDEX IX_Office_Org_Id ON Office (org_id);
CREATE INDEX IX_User_Office_Id ON User (office_id);
CREATE INDEX UX_Document_Id ON Document (id);
CREATE INDEX IX_Citizenship_Code ON user (citizenship_code);
CREATE INDEX IX_Document_Type ON Document(type);