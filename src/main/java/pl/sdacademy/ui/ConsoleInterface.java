package pl.sdacademy.ui;

import pl.sdacademy.Book;
import pl.sdacademy.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class ConsoleInterface {
    public void printInterface() {
        Scanner scanner = new Scanner(System.in);
        String greetings = "Witaj w programie Biblioteka";
        System.out.println(greetings);
        System.out.println("Czego szukasz? Wpisz tytul ksiazki: ");
        String lookingTitle = scanner.nextLine();
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Book book = entityManager.createQuery("from Book b where b.title= :t", Book.class)
                .setParameter("t", lookingTitle)
                .getSingleResult();

        System.out.println(book);
        entityManager.getTransaction().commit();
    }
}

