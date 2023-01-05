package pl.sdacademy.UserInterfaceFolder;

import pl.sdacademy.Book;
import pl.sdacademy.HibernateUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchBookButtom extends JFrame implements ActionListener {

    String tekst;
    JTextField title;
    JButton searchBook;
    JTextField result;

    public SearchBookButtom() {
        super("wyszukiwanie ksiązki"); //nazwa ramki
        setSize(500, 500); //rozmiar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //działanie przycisku zamknięcia

        JLabel TitleBook = new JLabel("Tytuł książki", JLabel.LEFT);
        add(TitleBook);
        title = new JTextField(40);
        add(title);
        result = new JTextField(100);
        add(result);

        FlowLayout flowLayout = new FlowLayout();  //polecenie wymuszające ułożenie przycisków
        setLayout(flowLayout);
        searchBook = new JButton("zatwierdź");
        add(searchBook);
        searchBook.addActionListener(this::actionPerformed);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e2) {
        Object source2 = e2.getSource();
        if (source2 == searchBook) {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            entityManager.getTransaction().begin();
            tekst = title.getText();
//            Book book = entityManager.createQuery("from Book b where b.title = :t", Book.class)
//                    .setParameter("t", tekst)
//                    .getSingleResult();
           List<Book> books = entityManager.createQuery("from Book b where b.title = :t", Book.class)
                    .setParameter("t", tekst)
                    .getResultList();
            result.setText(books.toString());
//            System.out.println(book);
            entityManager.getTransaction().commit();
            HibernateUtil.shutdown();
        }
    }
}


