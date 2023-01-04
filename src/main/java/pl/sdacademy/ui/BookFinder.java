package pl.sdacademy.ui;

import pl.sdacademy.Book;
import pl.sdacademy.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class BookFinder {
    public void isBookExists() {

        System.out.println("Wpisz tytul szukanej ksiazki: ");
        Scanner scanner = new Scanner(System.in);
        String lookingTitle = scanner.nextLine();
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();
        List<Book> books = entityManager.createQuery("from Book b where b.title= :t", Book.class)
                .setParameter("t", lookingTitle).getResultList();

        if (books.size() > 0) {
            System.out.println("Ksiazka istnieje w systemie");
        } else {
            System.out.println("Brak ksiazki w systemie");
        }
        entityManager.getTransaction().commit();

    }

    public void deleteBook() {
        System.out.println("Wpisz tytul ksiazki do skasowania:");
        Scanner scanner = new Scanner(System.in);
        String titleToDelete = scanner.nextLine();
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery("DELETE from Book b where b.title= :t")
                .setParameter("t", titleToDelete).executeUpdate();

        entityManager.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
