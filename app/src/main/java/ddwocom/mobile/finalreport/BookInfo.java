package ddwocom.mobile.finalreport;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class BookInfo implements Serializable {
    private int imageId;
    private int id;
    private String name;
    private String author;
    private String publisher;
    private String rate;
    private String comment;

    public BookInfo(){
        this.imageId = 0;
        this.id = 0;
        this.name = null;
        this.author = null;
        this.publisher = null;
    }

    public BookInfo(int imageId, int id, String name, String author, String publisher, String rate, String plot) {
        this.imageId = imageId;
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @NonNull
    @Override
    public String toString() {
        return name + ", " + author + ", " + publisher;
    }
}
