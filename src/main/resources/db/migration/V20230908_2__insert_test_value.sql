insert into card (name, code)
select 'card1', 'code1'

UNION
select 'card2', 'code2';

insert into category (name)
select 'textile';

insert into category (name)
select 'button';

insert into component (name, unit, category_id, code)
select 'white textile', 'metr', id, 'tk01'
from category
where name = 'textile';

insert into component (name, unit, category_id, code)
select 'green textile', 'metr', id, 'tk02'
from category
where name = 'textile';

insert into component (name, unit, category_id, code)
select 'white button', 'piece', id, 'bt01'
from category
where name = 'button';

insert into component (name, unit, category_id, code)
select 'red button', 'piece', id, 'bt02'
from category
where name = 'button';

insert into card_relation_component (card_id, component_id, qty)
select
    (select id from card where name = 'card1'),
    (select id from component where name = 'white textile'),
    5;

insert into card_relation_component (card_id, component_id, qty)
select
    (select id from card where name = 'card1'),
    (select id from component where name = 'red button'),
    7;

insert into card_relation_component (card_id, component_id, qty)
select
    (select id from card where name = 'card2'),
    (select id from component where name = 'green textile'),
    3;

insert into card_relation_component (card_id, component_id, qty)
select
    (select id from card where name = 'card2'),
    (select id from component where name = 'white button'),
    13;

