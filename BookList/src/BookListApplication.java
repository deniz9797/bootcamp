import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookListApplication {


    public static void initBookList(List<Book> bookList) {
        bookList.add(new Book("Suç ve Ceza", 250, "Dostoyevski", new Date()));
        bookList.add(new Book("Dorian Gray’in Portresi", 452, "Oscar Wilde", new Date()));
        bookList.add(new Book("Bozkırkurdu", 52, "Hermann Hesse", new Date()));
        bookList.add(new Book("Uğultulu Tepeler", 452, "Emily Brontë", new Date()));
        bookList.add(new Book("Ses ve Öfke", 65, "William Faulkner", new Date()));
        bookList.add(new Book("İki Şehrin Hikayesi", 87, "Charles Dickens", new Date()));
        bookList.add(new Book("Denemeler", 90, "Montaigne", new Date()));
        bookList.add(new Book("Saf ve Düşünceli Romancı", 162, "Orhan Pamuk", new Date()));
        bookList.add(new Book("Oblomov", 210, "İvan Gonçarov", new Date()));
        bookList.add(new Book("Satranç", 148, "Stefan Zweig", new Date()));
    }

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        initBookList(bookList);
        var bookNameAuthorNameMap = bookList.stream().collect(Collectors.toMap(Book::getName, Book::getAuthorName));

        bookNameAuthorNameMap.forEach((bookName, authorName) ->
                System.out.println("Book Name: " + bookName + "-> Author Name: " + authorName)
        );
        System.out.println("\n-------------------------------------------\n");

        List<Book> filteredListByPageNumber = bookList.stream().filter(book -> book.getNumberOfPage() > 100).collect(Collectors.toList());

        filteredListByPageNumber.forEach(book ->
                System.out.println("Book Name: " + book.getName() + "-> Author Name: " + book.getAuthorName() + "-> Page Number: " + book.getNumberOfPage())
        );
    }
}
