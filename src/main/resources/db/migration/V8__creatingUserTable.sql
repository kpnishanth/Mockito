CREATE TABLE if not exists User(
  id BIGINT AUTO_INCREMENT NOT NULL,
   userName VARCHAR(10) NULL,
   password VARCHAR(255) NULL,
   expirationDate VARCHAR(8) NULL,
   CONSTRAINT pk_user PRIMARY KEY (id)
);


