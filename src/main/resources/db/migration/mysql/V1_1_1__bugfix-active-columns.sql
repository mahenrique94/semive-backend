alter table addresses_types add active boolean not null default true;
alter table documents_types add active boolean not null default true;
alter table persons add active boolean not null default true;
alter table persons_addresses add active boolean not null default true;
alter table persons_contacts add active boolean not null default true;
alter table persons_definitions add active boolean not null default true;
alter table persons_documents add active boolean not null default true;
alter table persons_groups add active boolean not null default true;
alter table products add active boolean not null default true;
alter table products_cattegories add active boolean not null default true;
alter table products_types add active boolean not null default true;
