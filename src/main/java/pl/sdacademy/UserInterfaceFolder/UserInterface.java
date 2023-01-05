package pl.sdacademy.UserInterfaceFolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame implements ActionListener {

    JButton addBook;
    JButton delBook;
    JButton searchBook;
    JButton verNumber;

    public UserInterface() {
        super("Biblioteka - Interfejs użytkownika"); //nazwa ramki
        setSize(400, 1000); //rozmiar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //działanie przycisku zamknięcia
        setLookAndFeel();


        GridLayout gLayout = new GridLayout(7, 1);  //polecenie wymuszające ułożenie przycisków
        setLayout(gLayout);

        addBook = new JButton("dodanie nowej książki");
        addBook.addActionListener(this::actionPerformed);
        delBook = new JButton("Usunięcie książki");
        delBook.addActionListener(this::actionPerformed);
        verNumber = new JButton("wefyfikacja numeru inwentaryzacyjnego");
        verNumber.addActionListener(this::actionPerformed);
        searchBook = new JButton("Wyszukiwanie książki");
        searchBook.addActionListener(this::actionPerformed);
        add(addBook);
        add(delBook);
        add(verNumber);
        add(searchBook);
        setVisible(true); //ramka dzięki temu będzie widoczna
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addBook) {
            AddBookButtom addBookButton = new AddBookButtom();
        } else if (source == searchBook) {
            SearchBookButtom searchBookButton = new SearchBookButtom();
        } else if (source == delBook) {
            DeleteBookButtom deleteBookButtom = new DeleteBookButtom();
        } else if (source == verNumber) {
            VeryficationBookButtom veryficationBookButtom = new VeryficationBookButtom();
        }
    }
}


