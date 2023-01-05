package pl.sdacademy.bookDaoInterface;

import pl.sdacademy.Book;
import pl.sdacademy.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class BookDao implements DaoInterface<Book, Integer> {

    public void connection(){
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();
    }

    @Override
    public void persist(Book entity) {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public Book findById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Book entity) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
