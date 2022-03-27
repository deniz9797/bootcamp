import java.util.Date;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private String name;
    private int numberOfPage;
    private String authorName;
    private Date publicationDate;

    public Book(String name, int numberOfPage, String authorName, Date publicationDate) {
        this.name = name;
        this.numberOfPage = numberOfPage;
        this.authorName = authorName;
        this.publicationDate = publicationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public int compareTo(Book o) {
        var bookName2 = o.name;
        return name.compareTo(bookName2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPage == book.numberOfPage && Objects.equals(name, book.name) && Objects.equals(authorName, book.authorName) && Objects.equals(publicationDate, book.publicationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfPage, authorName, publicationDate);
    }
}



