import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Author> authors;
    private GsonBuilder gsonBuilder = new GsonBuilder();
    private Gson gson;

    public void getBooksByAuthor(String name){
        Author author = getAuthorByName(name);
        if (author != null){
            for(Book book : books){
                if (book.getAuthor().equals(name))
                    bookToJson(book);
            }
        }
        else
            System.out.println("Author not found");
    }
    private Author getAuthorByName(String name){
        for(Author author : authors){
            if (author.equals(name))
                return author;
        }
        return null;
    }
    private void booksFromJson(){
        try {
            InputStreamReader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("books.json"));
            gson = gsonBuilder.create();
            Type type = new TypeToken<List<Book>>(){}.getType();
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
    private void bookToJson(Book book){
        gson = gsonBuilder.create();
        System.out.println(gson.toJson(book));
    }
}
