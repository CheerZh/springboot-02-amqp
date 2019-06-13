package ustc.sse.amqp.bean;

/**
 * @author ZHGQ
 * @project springboot-02-amqp
 * @Package ustc.sse.amqp.bean
 * @date 2019/6/12-14:39
 * @Copyright: (c) 2019 USTC. All rights reserved.
 * @Description:
 */
public class Book {
    private String bookName;
    private String author;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
