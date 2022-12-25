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
  
  CREATE TABLE books_authors (
author_id int,
book_id int,
FOREIGN KEY (author_id) REFERENCES library_school.author(author_id),
FOREIGN KEY (book_id) REFERENCES library_school.book(book_id)
);

CREATE TABLE book_registration (
book_record_id int,
book_id int,
borrowDate date,
reader_id int,
registration_number varchar(15),
PRIMARY KEY (book_record_id),
FOREIGN KEY (book_id) REFERENCES library_school.book(book_id),
FOREIGN KEY (reader_id) REFERENCES library_school.reader(reader_id)
);




