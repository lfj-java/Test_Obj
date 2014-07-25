package action.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 14-7-24.
 */
public class Book implements Serializable{
    private Integer id;
    private String title;
    private String author;
    private int amount;

    public Book(Integer id) {
        this.id = id;
    }

    public Book(Integer id, String title, String author, int amount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
