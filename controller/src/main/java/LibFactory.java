import java.util.List;

public class LibFactory {
    private static Library library;
    private List<Book> books;
    private List<Author> authors;

    public Library create(){
        library = new Library(books, authors);
        return library;
    }


}
