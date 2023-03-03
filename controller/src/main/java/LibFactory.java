import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class LibFactory {
    private static Library library;
    private List<Book> books;
    private List<Author> authors;
    private GsonBuilder gsonBuilder = new GsonBuilder();
    private Gson gson;

    public Library create(){
        booksFromJson();
        authorsFromJson();
        library = new Library(books, authors);
        return library;
    }
    private void booksFromJson() {
        try {
            InputStreamReader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("books.json"));
            gson = gsonBuilder.create();
            Type type = new TypeToken<List<Book>>() {
            }.getType();
            books = gson.fromJson(reader, type);
        } catch (JsonIOException e) {
            System.out.println("Cannot parsing");
        }
    }
    private void authorsFromJson(){
        try {
            InputStreamReader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("authors.json"));
            gson = gsonBuilder.create();
            Type type = new TypeToken<List<Author>>(){}.getType();
            authors = gson.fromJson(reader, type);
        } catch (JsonIOException e) {
            System.out.println("Cannot parsing");
        }
    }

}
