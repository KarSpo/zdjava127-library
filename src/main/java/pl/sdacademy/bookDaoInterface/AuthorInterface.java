package pl.sdacademy.bookDaoInterface;

import pl.sdacademy.Author;

import java.util.List;

public interface AuthorInterface {

    Author findAuthorId (Integer id);

    List<Author> findAll();

    Author persist(Author entity);




}
