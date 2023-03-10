package pl.sdacademy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column
    private String title;

    @Column
    private String ISBN;
    private String id;


    //konstruktory
    public Book(String title, String warAndPeace, String leoTolstoy) {
    }

    public Book(String title, String ISBN) {
        this.title = title;
        this.ISBN = ISBN;

    }

//    @OneToOne(mappedBy = "book",
//            fetch = FetchType.EAGER)
//    private BookRegistration bookRegistration;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookRegistration")
    private BookRegistration bookRegistration;


    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;


    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = {
                    @JoinColumn(name = "author_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "book_id")}
    )
    @Column
    private List<Author> authors = new ArrayList<>();

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public BookRegistration getBookRegistration() {
        return bookRegistration;
    }

    public void setBookRegistration(BookRegistration bookRegistration) {
        this.bookRegistration = bookRegistration;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

//    @Override
//    public String toString() {
//        return "Book " +
//                "bookId= " + bookId +
//                ", title= " + title +
//                ", ISBN= " + ISBN +
//                ", Registration number: "+ getBookRegistration().getRegistrationNumber();
//    }


    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", bookRegistration=" + bookRegistration.getRegistrationNumber() +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
