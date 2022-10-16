
public class LibFactory {
    private static Library library;

    public Library create(){
        library = new Library();
        return library;
    }

}
