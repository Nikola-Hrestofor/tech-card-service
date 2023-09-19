Insert into category(name)
SELECT 'Ткань'
UNION
SELECT 'Пуговицы'
UNION
SELECT 'Кнопки'
UNION
SELECT 'Упаковочный материалы'
UNION
SELECT 'Пластик для воротника'
UNION
SELECT 'Пластиковые зажимы'
UNION
SELECT 'Картон';

INSERT INTO component(name, unit, category_id, code)
SELECT 'Белый сатен', 'meter',id, 'A0000001'
from category where name = 'Ткань'
UNION
SELECT 'Большая пуговица белая',   'piece',id, 'B0000002'
from category where name = 'Пуговицы'
UNION
SELECT 'Маленькая пуговица белая', 'piece',id, 'C0000003'
from category where name = 'Пуговицы'
UNION
SELECT 'Кнопка серебраяная', 'piece',id, 'D0000001'
from category where name = 'Кнопки'
UNION
SELECT 'Клеевая ткань', 'piece',id, 'D0000001' --наверное это упаковка?
from category where name = 'Ткань'
UNION
SELECT 'Пластиковый прямоугольный зажим', 'piece',id, 'E0000001'
from category where name = 'Пластиковые зажимы'
UNION
SELECT 'Пластиковый зажим', 'piece',id, 'E0000002'
from category where name = 'Пластиковые зажимы'
UNION
SELECT 'Пластикова бабочка для вставки в воротник', 'piece',id, 'F0000001'
from category where name = 'Пластик для воротника'
UNION
SELECT 'Пластиковый вкладыш для воротника стойка', 'piece',id, 'F0000002'
from category where name = 'Пластик для воротника'
UNION
SELECT 'Упаковка', 'piece',id, 'G0000001'
from category where name = 'Упаковочный материалы'
UNION
SELECT 'Пластиковый вкладыш для воротника', 'piece',id, 'F0000003'
from category where name = 'Пластик для воротника'
UNION
SELECT 'Картонная манишка', 'piece',id ,'D0000001'
from category where name = 'Картон';

INSERT INTO card(name)
SELECT '01-07-401'
UNION
SELECT '01-61-401';

----------------------model1
INSERT INTO card_relation_component(card_id, component_id, qty)
SELECT (select id from card where name = '01-07-401'), (select id from component where name = 'Белый сатен'), 2
UNION
SELECT (select id from card where name = '01-07-401'), (select id from component where name = 'Большая пуговица белая'), 7
UNION
SELECT (select id from card where name = '01-07-401'), (select id from component where name = 'Маленькая пуговица белая'), 2
UNION
SELECT (select id from card where name = '01-07-401'), (select id from component where name = 'Кнопка серебраяная'), 3
UNION
SELECT (select id from card where name = '01-07-401'), (select id from component where name = 'Клеевая ткань'), 1
UNION
SELECT (select id from card where name = '01-07-401'), (select id from component where name = 'Картонная манишка'), 1
UNION
SELECT (select id from card where name = '01-07-401'), (select id from component where name = 'Пластиковый прямоугольный зажим'), 1
UNION
SELECT (select id from card where name = '01-07-401'), (select id from component where name = 'Пластикова бабочка для вставки в воротник'), 1
UNION
SELECT (select id from card where name = '01-07-401'), (select id from component where name = 'Упаковка'), 1
UNION
SELECT (select id from card where name = '01-07-401'), (select id from component where name = 'Пластиковый вкладыш для воротника'), 1;



----------------------model2
INSERT INTO card_relation_component(card_id, component_id, qty)
SELECT (select id from card where name = '01-61-401'), (select id from component where name = 'Белый сатен'), 2
UNION
SELECT (select id from card where name = '01-61-401'), (select id from component where name = 'Большая пуговица белая'), 7
UNION
SELECT (select id from card where name = '01-61-401'), (select id from component where name = 'Маленькая пуговица белая'), 2
UNION
SELECT (select id from card where name = '01-61-401'), (select id from component where name = 'Кнопка серебраяная'), 3
UNION
SELECT (select id from card where name = '01-61-401'), (select id from component where name = 'Клеевая ткань'), 1
UNION
SELECT (select id from card where name = '01-61-401'), (select id from component where name = 'Картонная манишка'), 1
UNION
SELECT (select id from card where name = '01-61-401'), (select id from component where name = 'Пластиковый прямоугольный зажим'), 1
UNION
SELECT (select id from card where name = '01-61-401'), (select id from component where name = 'Пластикова бабочка для вставки в воротник'), 1
UNION
SELECT (select id from card where name = '01-61-401'), (select id from component where name = 'Упаковка'), 1
UNION
SELECT (select id from card where name = '01-61-401'), (select id from component where name = 'Пластиковый вкладыш для воротника'), 1






