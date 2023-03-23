CREATE TABLE if not exists Employee (
  id BIGINT AUTO_INCREMENT NOT NULL,
   reader VARCHAR(255) NULL,
   isbn VARCHAR(255) NULL,
   title VARCHAR(255) NULL,
   author VARCHAR(255) NULL,
   address VARCHAR(255) NULL,
   description VARCHAR(255) NULL,
CONSTRAINT pk_employee PRIMARY KEY (id)
);