truncate table news_link;
truncate table news;
truncate table category_news;

insert into category_news (id, category_name)
values (1, 'Спорт'),
       (2, 'Политика'),
       (3, 'Оброзование и наука');

insert into news(heading_name, news_text)
    value ('text',
            'They read their partners text messages and that when you realised what had gone on the week you and
            Sian were separated.'),
    ('world', 'I made a promise once to an old friend. We can finance our own digs. We''ll travel all
    over the world.'),
    ( 'crime', 'A great crime had been committed; a great calamity had fallen upon the inhabitants
    of the house with the green blinds.'),
    ( 'text', 'Firstly, he was READING text messages, and secondly, it wasn''t his phone, remember?'),
    ( 'world', 'And she wept. She wept for the loss of her baby. She wept for herself. She wept for
    the whole sick world.');

insert into news_link(category_id, news_id)
    value (1, 1),
    (1, 2),
    (2, 1),
    (2, 2),
    (3, 1);