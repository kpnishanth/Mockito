CREATE TABLE if not exists User(
  id BIGINT AUTO_INCREMENT NOT NULL,
   userName VARCHAR(10) NULL,
   password VARCHAR(255) NULL,
   isExpired BIT(1) NOT NULL,
   CONSTRAINT pk_ PRIMARY KEY (id)
);