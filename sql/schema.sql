create table category_news
(
    id            bigint unsigned auto_increment not null,
    category_name varchar(50) not null,
    primary key (id)
);

create table news
(
    id           bigint unsigned auto_increment not null,
    heading_name varchar(250) not null,
    news_text    text         not null,
    primary key (id)
);

create table news_link
(
    id          bigint unsigned auto_increment not null,
    category_id bigint unsigned not null,
    foreign key (category_id) references category_news (id),
    news_id     bigint unsigned not null,
    foreign key (news_id) references news (id),
    primary key (id)
);

