DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS ordered;
DROP TABLE IF EXISTS ordered_detail;

CREATE TABLE category
(
  code SERIAL PRIMARY KEY,
  name TEXT
);

CREATE TABLE item
(
  code SERIAL PRIMARY KEY,
  category_code INTEGER,
  name TEXT,
  price INTEGER
);

CREATE TABLE customer
(
  code SERIAL PRIMARY KEY,
  name TEXT,
  address TEXT,
  tel TEXT,
  email TEXT
);

CREATE TABLE ordered
(
  code SERIAL PRIMARY KEY,
  customer_code INTEGER,
  ordered_date DATE,
  total_price INTEGER
);

CREATE TABLE ordered_detail
(
  ordered_code INTEGER,
  item_code INTEGER,
  num INTEGER
);

INSERT INTO category(name) VALUES('本');
INSERT INTO category(name) VALUES('BD/DVD');
INSERT INTO category(name) VALUES('家電');
INSERT INTO category(name) VALUES('服・シューズ');
INSERT INTO category(name) VALUES('パソコン・オフィス用品');

INSERT INTO item(category_code,name,price) VALUES(1,'やさしくわかるJava',2700);
INSERT INTO item(category_code,name,price) VALUES(1,'プロ野球選手名鑑',530);
INSERT INTO item(category_code,name,price) VALUES(1,'美味しい料理レシピ',1000);
INSERT INTO item(category_code,name,price) VALUES(1,'HTML/CSS入門',2000);
INSERT INTO item(category_code,name,price) VALUES(1,'東京グルメスポット',800);

INSERT INTO item(category_code,name,price) VALUES(2,'スターウォーズシリーズBOX',18000);
INSERT INTO item(category_code,name,price) VALUES(2,'アルマゲドン',2000);
INSERT INTO item(category_code,name,price) VALUES(2,'本当にあった怖い話',1500);
INSERT INTO item(category_code,name,price) VALUES(2,'ソーシャルネットワーク',1900);
INSERT INTO item(category_code,name,price) VALUES(2,'stand by me',1000);

INSERT INTO item(category_code,name,price) VALUES(3,'一眼レフカメラ',70000);
INSERT INTO item(category_code,name,price) VALUES(3,'電子レンジ',12000);
INSERT INTO item(category_code,name,price) VALUES(3,'高音質イヤホン',4000);
INSERT INTO item(category_code,name,price) VALUES(3,'ミュージックプレイヤー',17000);
INSERT INTO item(category_code,name,price) VALUES(3,'LED電球',3000);

INSERT INTO item(category_code,name,price) VALUES(4,'ポロシャツ',2000);
INSERT INTO item(category_code,name,price) VALUES(4,'カーディガン',5000);
INSERT INTO item(category_code,name,price) VALUES(4,'ジーンズ',12000);
INSERT INTO item(category_code,name,price) VALUES(4,'スニーカー',6000);
INSERT INTO item(category_code,name,price) VALUES(4,'ランニングシューズ',10000);

INSERT INTO item(category_code,name,price) VALUES(5,'高機能マウス',3000);
INSERT INTO item(category_code,name,price) VALUES(5,'タブレット端末',20000);
INSERT INTO item(category_code,name,price) VALUES(5,'筆記用具セット',1400);
INSERT INTO item(category_code,name,price) VALUES(5,'プリンター',7000);
INSERT INTO item(category_code,name,price) VALUES(5,'電話機',8400);


CREATE TABLE member
(
  id SERIAL PRIMARY KEY,
  name VARCHAR,
  address VARCHAR,
  tel VARCHAR,
  gender VARCHAR,
  login_id VARCHAR,
  login_pass VARCHAR
);
