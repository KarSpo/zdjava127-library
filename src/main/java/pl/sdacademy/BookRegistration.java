package pl.sdacademy;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BookRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_record_id")
    private Integer bookRecordId;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column
    private LocalDate borrowDate;

    public BookRegistration(String registrationNumber, LocalDate borrowDate,  Reader reader) {
        this.registrationNumber = registrationNumber;
        this.borrowDate = borrowDate;

        this.reader = reader;
    }
    public BookRegistration(){};


    //    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "book")
//    private Book book;
    @OneToMany(mappedBy = "bookRegistration")
    private List<Book> books;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reader")
    private Reader reader;

    public Integer getBookRecordId() {
        return bookRecordId;
    }

    public void setBookRecordId(Integer bookRecordId) {
        this.bookRecordId = bookRecordId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }





    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "BookRegistration: " +
                "bookRecordId= " + bookRecordId +
                ", registrationNumber= '" + registrationNumber + '\'' +
                ", borrowDate= " + borrowDate +

                ", reader= " + reader;
    }
}
