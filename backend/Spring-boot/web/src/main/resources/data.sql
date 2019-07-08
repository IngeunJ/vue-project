DROP TABLE IF EXISTS customers;
CREATE TABLE customers (
id INT AUTO_INCREMENT PRIMARY KEY,
customer_id VARCHAR(15) UNIQUE NOT NULL,
password VARCHAR(50) NOT NULL,
customer_name VARCHAR(15) NOT NULL,
email VARCHAR(110) NOT NULL,
phone VARCHAR(50) NOT NULL,
city VARCHAR(110) NOT NULL,
address VARCHAR(110) NOT NULL,
postalcode VARCHAR(50) NOT NULL,
introduction VARCHAR(200) NOT NULL

)DEFAULT CHARSET=utf8;
 insert into customers(customer_id,password,customer_name,email,phone,city,address,postalcode,introduction) values ('haha','1234','changha kim','kon0147@naver.com','01076794338','광주광역시','광산구 사암로 306(월곡동) 금호아파트 13동408호','62347','안녕');
commit; 

DROP TABLE IF EXISTS Board;
CREATE TABLE Board (
bno INT AUTO_INCREMENT,
title VARCHAR(15)  NOT NULL,
content VARCHAR(50) NOT NULL,
)
DEFAULT CHARSET=utf8;
insert into Board(title,content) values ('하이','인근이야');
insert into Board(title,content) values ('하이2','인근이야');
commit; 
