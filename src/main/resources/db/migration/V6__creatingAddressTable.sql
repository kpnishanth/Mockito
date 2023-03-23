CREATE TABLE if not exists Address(
  id BIGINT AUTO_INCREMENT NOT NULL,
   houseNumber VARCHAR(10) NULL,
   StreetName VARCHAR(255) NULL,
   state VARCHAR(20) NULL,
   zip VARCHAR(10) NULL,

   CONSTRAINT pk_address PRIMARY KEY (id)
);


insert into Address (id, houseNumber, streetName,state,zip) values (1,'161','Garnet Drive','Acworth','30101');