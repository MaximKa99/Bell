/*
organizations
*/

insert into organization (id, name, full_name, address, inn, kpp, phone, is_active) values (1, 'sberbank', 'ПАО СБЕРБАНК', 'Moscow', '780204893183', '771443001', '8-916-292-45-87', true);
insert into organization (id, name, full_name, address, inn, kpp, phone, is_active) values (2, 'gazprom', 'ПАО ГАЗПРОМ', 'Moscow', '780204893184', '771853001', '8-916-292-45-97', true);
insert into organization (id, name, full_name, address, inn, kpp, phone, is_active) values (3, 'rosneft', 'OAO ROSNEFT', 'Moscow', '780204893185', '771843001', '8-916-292-46-87', true);
insert into organization (id, name, full_name, address, inn, kpp, phone, is_active) values (4, 'YUKOS', 'NK YUKOS', 'Moscow', '780204893187', '771843002', '8-916-292-55-87', false);

/*
offices
*/

insert into office (id, org_id, name, address, phone, is_active) values (1, 1, 'Президент плаза', 'Кутузовский проспект, 32', '8 (495) 208-63-30', true);
insert into office (id, org_id, name, address, phone, is_active) values (2, 2, 'Здание штаб-квартиры «Газпрома»', 'ул. Наметкина, 16', '+7 495 719-30-01', true);
insert into office (id, org_id, name, address, phone, is_active) values (3, 3, 'Роснефть', 'ул. Софийская набережная, 26/1', '+7 (499) 517-88-99', true);
insert into office (id, org_id, name, address, phone, is_active) values (4, 4, 'ЮКОС', 'ул. Дубининская, д. 17, стр. 13', '', false);

/*
documents
*/

insert into document (id, name, code) values (1, 'Свидетельство о рождении', 03);
insert into document (id, name, code) values (2, 'Военный билет ', 07);
insert into document (id, name, code) values (3, 'Временное удостоверение, выданное взамен военного билета', 08);
insert into document (id, name, code) values (4, 'Паспорт иностранного гражданина', 10);
insert into document (id, name, code) values (5, 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу', 11);
insert into document (id, name, code) values (6, 'Вид на жительство в Российской Федерации', 12);
insert into document (id, name, code) values (7, 'Удостоверение беженца', 13);
insert into document (id, name, code) values (8, 'Разрешение на временное проживание в Российской Федерации', 15);
insert into document (id, name, code) values (9, 'Свидетельство о предоставлении временного убежища на территории Российской Федерации', 18);
insert into document (id, name, code) values (10, 'Паспорт гражданина Российской Федерации', 21);
insert into document (id, name, code) values (11, 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства', 23);
insert into document (id, name, code) values (12, 'Удостоверение личности военнослужащего Российской Федерации', 24);
insert into document (id, name, code) values (13, 'Иные документы', 91);

/*
counties
*/

insert into country (id, name, code) values (1, 'Российская Федерация', 643);

/*
users
*/

insert into user (id, office_id, org_id, first_name, second_name, middle_name, position, phone, doc_id, doc_date, citizenship_id, is_indentified)
    values (1, 1, 1, 'Максим', 'Валентинович', 'Походин', 'стажер', '8-916-908-03-01', 10, '2019-10-05', 1, true);
insert into user (id, office_id, org_id, first_name, second_name, middle_name, position, phone, doc_id, doc_date, citizenship_id, is_indentified)
    values (2, 1, 1, 'Максим', 'Валентинович', 'Походин', 'стажер', '8-916-908-03-01', 10, '2019-10-05', 1, true);
insert into user (id, office_id, org_id, first_name, second_name, middle_name, position, phone, doc_id, doc_date, citizenship_id, is_indentified)
    values (3, 1, 1, 'Петр', 'Иванович', 'Понурый', 'вахтер', '8-916-292-74-22', 10, '1980-07-09', 1, true);
insert into user (id, office_id, org_id, first_name, second_name, middle_name, position, phone, doc_id, doc_date, citizenship_id, is_indentified)
    values (4, 1, 1, 'Иван', 'Семенович', 'Простой', 'эйчар', '8-916-292-23-74', 10, '2000-09-07', 1, true);