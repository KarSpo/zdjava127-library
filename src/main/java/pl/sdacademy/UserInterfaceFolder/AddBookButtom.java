package pl.sdacademy.UserInterfaceFolder;

import pl.sdacademy.Author;
import pl.sdacademy.Book;
import pl.sdacademy.HibernateUtil;
import pl.sdacademy.Publisher;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AddBookButtom extends JFrame implements ActionListener {

    JButton addBook;
    JTextField isbn;
    JTextField title;
    JTextField publisherId;
    JTextField author1name;
    JTextField author1lastName;
    JTextField author2name;
    JTextField author2lastName;
    JTextField author3name;
    JTextField author3lastName;
    JTextField bookRegistrationNumber2;

    public AddBookButtom() {
        super("dodawanie nowej ksiązki"); //nazwa ramki
        setSize(500, 500); //rozmiar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //działanie przycisku zamknięcia

        JLabel ISBNnumber = new JLabel("ISBN", JLabel.LEFT);
        isbn = new JTextField(13);
        add(ISBNnumber);
        add(isbn);

        JLabel TitleBook = new JLabel("Tytuł książki", JLabel.LEFT);
        title = new JTextField(40);
        add(TitleBook);
        add(title);

        JLabel publisher = new JLabel("Publisher", JLabel.LEFT);
        publisherId = new JTextField(13);
        add(publisher);
        add(publisherId);

        JLabel AuthorBook = new JLabel("Autorzy", JLabel.LEFT);
        add(AuthorBook);
        author1name = new JTextField(15);
        add(author1name);
        author1lastName = new JTextField(15);
        add(author1lastName);
        author2name = new JTextField(15);
        add(author2name);
        author2lastName = new JTextField(15);
        add(author2lastName);
        author3name = new JTextField(15);
        add(author3name);
        author3lastName = new JTextField(15);
        add(author3lastName);

        JLabel bookRegistrationNumber = new JLabel("Numer rejestracyjny książki", JLabel.LEFT);
        bookRegistrationNumber2 = new JTextField(13);
        add(bookRegistrationNumber);
        add(bookRegistrationNumber2);


        FlowLayout flowLayout = new FlowLayout();  //polecenie wymuszające ułożenie przycisków
        setLayout(flowLayout);
        addBook = new JButton("zatwierdź");
        add(addBook);
        setVisible(true);
        addBook.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addBook) {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            entityManager.getTransaction().begin();
            String isbnNumber = isbn.getText();
            String bookTitle = title.getText();
            String bookPublisher = publisherId.getText();
            String bookAuthor1name = author1name.getText();
            String bookAuthor1lastName = author1lastName.getText();
            String bookAuthor2name = author2name.getText();
            String bookAuthor2lastName = author2lastName.getText();
            String bookAuthor3name = author3name.getText();
            String bookAuthor3lastName = author3lastName.getText();
            Book book = new Book(bookTitle, isbnNumber);
            Publisher publisher = new Publisher(bookPublisher);
            book.setPublisher(publisher);
            Author author1 = new Author(bookAuthor1name, bookAuthor1lastName);
            Author author2 = new Author(bookAuthor2name, bookAuthor2lastName);
            Author author3 = new Author(bookAuthor3name, bookAuthor3lastName);
            book.setAuthors(Arrays.asList(author1, author2, author3));
            entityManager.persist(publisher);
            entityManager.persist(author1);
            entityManager.persist(author2);
            entityManager.persist(author3);
            entityManager.persist(book);
            entityManager.getTransaction().commit();
            HibernateUtil.shutdown();

        }

    }
}


