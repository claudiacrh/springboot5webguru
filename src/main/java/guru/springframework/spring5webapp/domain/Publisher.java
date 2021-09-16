package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String publisherName;
    private String publisherAddress;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;


    public Publisher() {
    }

    public Publisher(String publisherName, String publisherAddress) {
        this.publisherName = publisherName;
        this.publisherAddress = publisherAddress;
        this.books = new ArrayList<>();

    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> list_Book) {
        this.books = list_Book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
                ", publisherAddress='" + publisherAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, publisherName, publisherAddress);
    }
}
