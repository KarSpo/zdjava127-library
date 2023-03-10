package pl.sdacademy;



import javax.persistence.EntityManager;
import java.util.Scanner;
import pl.sdacademy.bookDaoInterface.AuthorInterface;
import pl.sdacademy.bookDaoInterface.AuthorInterfaceImpl;
import pl.sdacademy.ui.ConsoleInterface;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    ConsoleInterface consoleInterface= new ConsoleInterface();
    consoleInterface.chooseOption();

        List<String> cos = new ArrayList<>();

        AuthorInterface authorInterface = new AuthorInterfaceImpl();
        List<Author> all = authorInterface.findAll();




  }
  public static void isRegistrationNumberexist() {
    System.out.println("Podaj nr do sprawdzenia: ");
    Scanner scanner = new Scanner(System.in);
    String numberToCheck = scanner.nextLine();
    EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
    entityManager.getTransaction().begin();
    BookRegistration r = entityManager.createQuery("from BookRegistration br where br.registrationNumber = :n", BookRegistration.class)
            .setParameter("n", numberToCheck)
            .getSingleResult();
    System.out.println(r);
  }
    }
