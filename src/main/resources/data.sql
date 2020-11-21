/*
organizations
*/

insert into organization (id, name, full_name, address, inn, kpp, phone, is_active) values (1, 'sberbank', 'ПАО СБЕРБАНК', 'Moscow', '780204893183', '771443001', '8-916-292-45-87', true);
insert into organization (id, name, full_name, address, inn, kpp, phone, is_active) values (2, 'gazprom', 'ПАО ГАЗПРОМ', 'Moscow', '780204893184', '771853001', '8-916-292-45-97', true);
insert into organization (id, name, full_name, address, inn, kpp, phone, is_active) values (3, 'rosneft', 'OAO ROSNEFT', 'Moscow', '780204893185', '771843001', '8-916-292-46-87', true);
insert into organization (id, name, full_name, address, inn, kpp, phone, is_active) values (4, 'YUKOS', 'NK YUKOS', 'Moscow', '780204893187', '771843002', '', false);

/*
offices
*/

insert into office (id, org_id, name, address, phone, is_active) values (1, 1, 'Президент плаза', 'Кутузовский проспект, 32', '8 (495) 208-63-30', true);
insert into office (id, org_id, name, address, phone, is_active) values (2, 2, 'Здание штаб-квартиры «Газпрома»', 'ул. Наметкина, 16', '+7 495 719-30-01', true);
insert into office (id, org_id, name, address, phone, is_active) values (3, 3, 'Роснефть', 'ул. Софийская набережная, 26/1', '+7 (499) 517-88-99', true);
insert into office (id, org_id, name, address, phone, is_active) values (4, 4, 'ЮКОС', 'ул. Дубининская, д. 17, стр. 13', '', false);

/*
type of documents
*/

insert into type_of_document (code, name) values (03, 'Свидетельство о рождении');
insert into type_of_document (code, name) values (07, 'Военный билет ');
insert into type_of_document (code, name) values (08, 'Временное удостоверение, выданное взамен военного билета');
insert into type_of_document (code, name) values (10, 'Паспорт иностранного гражданина');
insert into type_of_document (code, name) values (11, 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу');
insert into type_of_document (code, name) values (12, 'Вид на жительство в Российской Федерации');
insert into type_of_document (code, name) values (13, 'Удостоверение беженца');
insert into type_of_document (code, name) values (15, 'Разрешение на временное проживание в Российской Федерации');
insert into type_of_document (code, name) values (18, 'Свидетельство о предоставлении временного убежища на территории Российской Федерации');
insert into type_of_document (code, name) values (21, 'Паспорт гражданина Российской Федерации');
insert into type_of_document (code, name) values (23, 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');
insert into type_of_document (code, name) values (24, 'Удостоверение личности военнослужащего Российской Федерации');
insert into type_of_document (code, name) values (91, 'Иные документы');

/*
counties
*/

insert into country (code, name) values (643, 'Российская Федерация');

/*
users
*/

insert into user (id, office_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_indentified)
    values (1, 1, 'Максим', 'Валентинович', 'Походин', 'стажер', '8-916-908-03-01', 643, true);
insert into user (id, office_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_indentified)
    values (2, 1, 'Максим', 'Валентинович', 'Походин', 'стажер', '8-916-908-03-01', 643, true);
insert into user (id, office_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_indentified)
    values (3, 1, 'Петр', 'Иванович', 'Понурый', 'вахтер', '8-916-292-74-22', 643, true);
insert into user (id, office_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_indentified)
    values (4, 1, 'Иван', 'Семенович', 'Простой', 'эйчар', '8-916-292-23-74', 643, true);

/*
documents
*/

insert into document (id, type, doc_date, doc_number) values (1, 21, '2019-10-05', 133444);
insert into document (id, type, doc_date, doc_number) values (2, 21, '2019-10-05', 228322);
insert into document (id, type, doc_date, doc_number) values (3, 21, '1980-07-09', 322228);
insert into document (id, type, doc_date, doc_number) values (4, 21, '2000-09-07', 133737);