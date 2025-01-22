CREATE DATABASE IF NOT EXISTS vote;

-- 投票項目資料表
CREATE TABLE IF NOT EXISTS vote_items (
    item_id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 投票項目編號，設為主鍵，並自動遞增
    item_name VARCHAR(255) NOT NULL            -- 投票項目名稱，設為非空
);
ALTER TABLE vote_records                       -- 建立與投票紀錄資料表的關聯
ADD CONSTRAINT fk_vote_items
FOREIGN KEY (item_id) REFERENCES vote_items(item_id)
ON DELETE CASCADE;

-- 建立投票紀錄資料表
CREATE TABLE IF NOT EXISTS vote_records (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 投票編號，設為主鍵，並自動遞增
    voter VARCHAR(255) NOT NULL,          -- 投票人名稱，設為非空
    item_id BIGINT,                       -- 外鍵欄位，關聯到 vote_items 資料表的 item_id
    CONSTRAINT fk_vote_items FOREIGN KEY (item_id) REFERENCES vote_items(item_id) ON DELETE CASCADE -- 外鍵約束，當投票項目被刪除時，相關投票紀錄會被刪除
);
