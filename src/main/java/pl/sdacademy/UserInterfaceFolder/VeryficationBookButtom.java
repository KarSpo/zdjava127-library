package pl.sdacademy.UserInterfaceFolder;

import pl.sdacademy.BookRegistration;
import pl.sdacademy.HibernateUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeryficationBookButtom extends JFrame implements ActionListener {
    String tekst;
    JTextField veryficationNumber;
    JButton searchNumber;
    JTextField result;

    public VeryficationBookButtom() {
        super("wyszukiwanie numeru inwentaryzacyjnego"); //nazwa ramki
        setSize(500, 500); //rozmiar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //działanie przycisku zamknięcia

        JLabel TitleBook = new JLabel("Numer inwentaryzacyjny", JLabel.LEFT);
        add(TitleBook);
        veryficationNumber = new JTextField(40);
        add(veryficationNumber);
        result = new JTextField(100);
        add(result);

        FlowLayout flowLayout = new FlowLayout();  //polecenie wymuszające ułożenie przycisków
        setLayout(flowLayout);
        searchNumber = new JButton("zatwierdź");
        add(searchNumber);
        searchNumber.addActionListener(this::actionPerformed);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e2) {
        Object source2 = e2.getSource();
        if (source2 == searchNumber) {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            entityManager.getTransaction().begin();
            tekst = veryficationNumber.getText();
            BookRegistration rn = entityManager.createQuery("from BookRegistration br where br.registrationNumber = :rn", BookRegistration.class)
                    .setParameter("rn", tekst)
                    .getSingleResult();
            result.setText(rn.toString());
            entityManager.getTransaction().commit();
            HibernateUtil.shutdown();
        }
    }
}
