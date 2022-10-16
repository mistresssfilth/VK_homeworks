import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        System.out.print("Author: ");
        Scanner scanner = new Scanner(System.in);
        String authorName = scanner.nextLine();
        LibFactory libFactory = new LibFactory();
        Library library = libFactory.create();
        library.booksFromJson();
        library.authorsFromJson();
        library.getBooksByAuthor(authorName);
    }
}
