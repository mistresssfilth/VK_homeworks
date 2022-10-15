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
}
