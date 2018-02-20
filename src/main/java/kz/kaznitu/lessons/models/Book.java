package kz.kaznitu.lessons.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String bookName;
    private int years;
    private int countt;

    public Book() {
    }

    public Book(String bookName, int years, int countt) {
        this.bookName = bookName;
        this.years = years;
        this.countt = countt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getCountt() {
        return countt;
    }

    public void setCountt(int countt) {
        this.countt = countt;
    }
}
