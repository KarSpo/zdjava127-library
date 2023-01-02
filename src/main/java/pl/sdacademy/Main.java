package pl.sdacademy;


import javax.persistence.EntityManager;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

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