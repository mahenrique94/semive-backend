create table countries (
    id integer not null,
    description varchar(30) not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkcontries primary key (id),
    constraint ukcontries01 unique (description)
);

create table documents_types (
    id integer not null auto_increment,
    description varchar(30) not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkdocuments_types primary key (id),
    constraint ukdocuments_types01 unique (description)
);

create table states (
    id integer not null,
    id_country integer not null,
    description varchar(30) not null,
    state char(2) not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkstates primary key (id),
    constraint fkstates01 foreign key (id_country) references countries (id),
    constraint ukstates01 unique (description),
    constraint ukstates02 unique (state)
);

create table cities (
    id integer not null,
    id_state integer not null,
    description varchar(60) not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkstates primary key (id),
    constraint fkcities01 foreign key (id_state) references states (id)
);

create table unities (
    id integer not null auto_increment,
    description varchar(30) not null,
    unity char(2) not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkunities primary key (id),
    constraint ukunities01 unique (description),
    constraint ukunities02 unique (unity)
);



create table persons (
    id bigint not null auto_increment,
    name varchar(120) not null,
    sex char(1) not null,
    date_born date not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkpersons primary key (id)
);

create table persons_addresses (
    id bigint not null auto_increment,
    id_person bigint not null,
    id_city integer not null,
    type varchar (10) not null,
    address varchar (60) not null,
    number varchar (10) not null,
    zipcode varchar (10) not null,
    complement varchar (60),
    district varchar (60) not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkpersons_addresses primary key (id),
    constraint fkpersons_addresses01 foreign key (id_person) references persons (id),
    constraint fkpersons_addresses02 foreign key (id_city) references cities (id),
    constraint ukpersons_addresses01 unique (id_person, id_city, type, address, number, zipcode, district)
);

create table persons_contacts (
    id bigint not null auto_increment,
    id_person bigint not null,
    name varchar(120) not null,
    area_code integer,
    telephone varchar(9),
    cellphone varchar(10),
    email varchar(255),
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkpersons_contacts primary key (id),
    constraint fkpersons_contacts01 foreign key (id_person) references persons (id)
);

create table persons_documents (
    id bigint not null auto_increment,
    id_person bigint not null,
    id_type integer not null,
    value varchar(30) not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkpersons_documents primary key (id),
    constraint fkpersons_documents01 foreign key (id_person) references persons (id),
    constraint fkpersons_documents02 foreign key (id_type) references documents_types (id),
    constraint ukpersons_documents01 unique (id_person, id_type),
    constraint ukpersons_documents02 unique (value)
);

create table persons_groups (
    id integer not null auto_increment,
    description varchar(30) not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkpersons_groups primary key (id),
    constraint ukpersons_groups01 unique (description)
);

create table persons_definitions (
    id bigint not null auto_increment,
    id_person bigint not null,
    id_group integer not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkpersons_definitions primary key (id),
    constraint fkpersons_definitions01 foreign key (id_person) references persons (id),
    constraint fkpersons_definitions02 foreign key (id_group) references persons_groups (id),
    constraint ukpersons_definitions01 unique (id_person, id_group)
);



create table products_cattegories (
    id bigint not null auto_increment,
    description varchar(30) not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkproducts_cattegories primary key (id),
    constraint ukproducts_cattegories01 unique (description)
);

create table products_types (
    id bigint not null auto_increment,
    id_cattegory bigint not null,
    description varchar(30) not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkproducts_types primary key (id),
    constraint fkproducts_types01 foreign key (id_cattegory) references products_cattegories (id),
    constraint ukproducts_types01 unique (id_cattegory, description)
);

create table products (
    id bigint not null auto_increment,
    id_type bigint not null,
    id_unity integer not null,
    description varchar(120) not null,
    brand varchar(30),
    bar_code varchar(30),
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkproducts primary key (id),
    constraint fkproducts01 foreign key (id_type) references products_types (id),
    constraint fkproducts02 foreign key (id_unity) references unities (id),
    constraint ukproducts01 unique (description),
    constraint ukproducts02 unique (bar_code)
);

create table products_stocks (
    id bigint not null auto_increment,
    id_product bigint not null,
    count numeric(18, 2) not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkproducts_stocks primary key (id),
    constraint fkproducts_stocks01 foreign key (id_product) references products (id),
    constraint ckproducts_stocks01 check (count >= 0)
);

create table products_values (
    id bigint not null auto_increment,
    id_product bigint not null,
    value numeric(18, 2) not null,
    date_created timestamp not null,
    date_updated timestamp not null,
    constraint pkproducts_values primary key (id),
    constraint fkproducts_values01 foreign key (id_product) references products (id),
    constraint ckproducts_values01 check (value >= 0)
);