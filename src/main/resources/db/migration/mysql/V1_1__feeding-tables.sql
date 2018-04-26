insert into documents_types(id, description, date_created, date_updated) values (0, '', current_timestamp, current_timestamp);
update documents_types set id = 0 where description = '';
insert into documents_types(id, description, date_created, date_updated) values (1, 'CPF', current_timestamp, current_timestamp);
insert into documents_types(id, description, date_created, date_updated) values (2, 'RG', current_timestamp, current_timestamp);



insert into persons_groups(id, description, date_created, date_updated) values (0, '', current_timestamp, current_timestamp);
update persons_groups set id = 0 where description = '';
insert into persons_groups(id, description, date_created, date_updated) values (1, 'Cliente', current_timestamp, current_timestamp);
insert into persons_groups(id, description, date_created, date_updated) values (2, 'Fornecedor', current_timestamp, current_timestamp);