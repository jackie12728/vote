-- 插入 vote_items 資料表的預設資料
INSERT INTO vote_items (item_name) VALUES
('滿意'),
('普通'),
('不滿意');

-- 插入 vote_records 資料表的預設資料
INSERT INTO vote_records (voter, item_id) VALUES
('Alice', 1),
('Bob', 2),
('Charlie', 3),
('Dave', 1),
('Eve', 2);
