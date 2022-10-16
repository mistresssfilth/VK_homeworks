import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Library {
    private List<Book> books;
    private List<Author> authors;

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
            if (author.getName().equals(name))
                return author;
        }
        return null;
    }

    private void bookToJson(Book book){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(book));
    }
}
