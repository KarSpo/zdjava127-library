package pl.sdacademy.UserInterfaceFolder;

import pl.sdacademy.HibernateUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBookButtom extends JFrame implements ActionListener {

    String tekst;
    JTextField title;
    JButton deleteBook;


    public DeleteBookButtom() {
        super("usuwanie ksiązki"); //nazwa ramki
        setSize(500, 500); //rozmiar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //działanie przycisku zamknięcia

        JLabel TitleBook = new JLabel("Tytuł książki", JLabel.LEFT);
        add(TitleBook);
        title = new JTextField(40);
        add(title);

        FlowLayout flowLayout = new FlowLayout();  //polecenie wymuszające ułożenie przycisków
        setLayout(flowLayout);
        deleteBook = new JButton("usuń");
        add(deleteBook);
        deleteBook.addActionListener(this::actionPerformed);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == deleteBook) {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            entityManager.getTransaction().begin();
            tekst = title.getText();
            entityManager.createQuery("DELETE from Book b where b.title = :t")
                    .setParameter("t", tekst)
                    .executeUpdate();

            entityManager.getTransaction().commit();
            HibernateUtil.shutdown();
        }

    }
}
