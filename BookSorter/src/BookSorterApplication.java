import java.util.*;

public class BookSorterApplication {
    public static void main(String[] args) {

        Set<Book> bookList = new LinkedHashSet<>();

        bookList.add(new Book("Suç ve Ceza", 250, "Dostoyevski", new Date()));
        bookList.add(new Book("Suç ve Ceza", 250, "Dostoyevski", new Date()));
        bookList.add(new Book("Dorian Gray’in Portresi", 452, "Oscar Wilde", new Date()));
        bookList.add(new Book("Bozkırkurdu", 52, "Hermann Hesse", new Date()));
        bookList.add(new Book("Uğultulu Tepeler", 452, "Emily Brontë", new Date()));
        bookList.add(new Book("Ses ve Öfke", 65, "William Faulkner", new Date()));

        bookList.forEach(book-> System.out.println("Name: " + book.getName()));

        System.out.println("\nAfter sort by Book Name : \n");
        Set<Book> treeSet = new TreeSet<>(bookList);
        treeSet.forEach(book-> System.out.println("Name: " + book.getName()));

        Queue<Book> priorityQueuePageNumber = new PriorityQueue<>(Comparator.comparingInt(Book::getNumberOfPage));
        priorityQueuePageNumber.addAll(bookList);
        System.out.println("--------------------");
        priorityQueuePageNumber.forEach(book-> System.out.println("PageNumber: " + book.getNumberOfPage()+" Name: "+book.getName()));

    }
}
