package pl.sdacademy.ui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleInterface {

    public void chooseOption() {

        Scanner scanner = new Scanner(System.in);
        String greetings = "Witaj w aplikacji Biblioteka. Wybierz odpowiednia cyfre:  \n" +
                "1 - Sprawdz, czy ksiazka istnieje w systemie \n" +
                "2 - Skasuj ksiazke po tytule \n" +
                "3 - TU DODAJEMY KOLEJNE FUNKCJONALNOSCI";

        System.out.println(greetings);
        String userSelection = scanner.nextLine();
        Pattern templateRegex = Pattern.compile("\\d+");
        Matcher matcher = templateRegex.matcher(userSelection);

        if (matcher.matches()) {
            int number = Integer.valueOf(userSelection);
            if (number == 1) {
                BookFinder bookFinder = new BookFinder();
                bookFinder.isBookExists();
            } else if (number == 2) {
                BookFinder bookFinder = new BookFinder();
                bookFinder.deleteBook();
            } else {
                System.out.println("Nierozpoznana cyfra.");
            }
        } else {
            System.out.println("Wprowadzono niepoprawne dane.");
        }

    }


}

