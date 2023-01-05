package pl.sdacademy;


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
}