CREATE TABLE if not exists User(
  id BIGINT AUTO_INCREMENT NOT NULL,
   userName VARCHAR(10) NULL,
   password VARCHAR(255) NULL,
   expirationDate DATE(6) NULL,
   CONSTRAINT pk_ PRIMARY KEY (id)
);


