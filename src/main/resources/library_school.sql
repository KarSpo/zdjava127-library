use library_school;
CREATE TABLE book (
  book_id       INT AUTO_INCREMENT NOT NULL,
  title         VARCHAR(100) NOT NULL,
  ISBN          VARCHAR(13) NOT NULL UNIQUE,
  publisher_id  INT,
  PRIMARY KEY(book_id),
  FOREIGN KEY (publisher_id) REFERENCES library_school.publisher(publisher_id)
  );


  CREATE TABLE author (
  author_id     INT AUTO_INCREMENT NOT NULL,
  first_name    VARCHAR(100) NOT NULL,
  last_name     VARCHAR(100) NOT NULL,
  PRIMARY KEY(author_id));


  CREATE TABLE publisher (
  publisher_id  INT AUTO_INCREMENT NOT NULL,
  name          VARCHAR(100) NOT NULL,
  PRIMARY KEY (publisher_id));

  CREATE TABLE reader (
  reader_id        INT NOT NULL AUTO_INCREMENT,
  first_name       VARCHAR(100) NOT NULL,
  last_name         VARCHAR(100) NOT NULL,
  identity_number   VARCHAR(11) NOT NULL UNIQUE,
  PRIMARY KEY(reader_id));




