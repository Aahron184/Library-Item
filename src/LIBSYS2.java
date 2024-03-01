import java.util.ArrayList;
import java.util.List;

// Interface for library items
interface LibraryItem {
    void borrowItem();
    void returnItem();
    boolean isBorrowed();
    String toString();
}

// Book class implementing LibraryItem
class Book implements LibraryItem {
    private String title;
    private String author;
    private boolean borrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("Book \"" + title + "\" by " + author + " borrowed.");
        } else {
            System.out.println("Book \"" + title + "\" by " + author + " is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println("Book \"" + title + "\" by " + author + " returned.");
        } else {
            System.out.println("Book \"" + title + "\" by " + author + " is not currently borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String toString() {
        return "Book: \"" + title + "\" by " + author;
    }
}

// DVD class implementing LibraryItem
class DVD implements LibraryItem {
    private String title;
    private String director;
    private boolean borrowed;

    public DVD(String title, String director) {
        this.title = title;
        this.director = director;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("DVD \"" + title + "\" directed by " + director + " borrowed.");
        } else {
            System.out.println("DVD \"" + title + "\" directed by " + director + " is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println("DVD \"" + title + "\" directed by " + director + " returned.");
        } else {
            System.out.println("DVD \"" + title + "\" directed by " + director + " is not currently borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String toString() {
        return "DVD: \"" + title + "\" directed by " + director;
    }
}

// Abstract class for LibraryUser
abstract class LibraryUser {
    protected String name;
    protected List<LibraryItem> borrowedItems = new ArrayList<>();

    void borrowItem(LibraryItem item) {
        if (!item.isBorrowed()) {
            item.borrowItem();
            borrowedItems.add(item);
        }
    }

    void returnItem(LibraryItem item) {
        if (item.isBorrowed()) {
            item.returnItem();
            borrowedItems.remove(item);
        }
    }

    abstract void printItemsBorrowed();
}

// Student class extending LibraryUser
class Student extends LibraryUser {
    public Student(String name) {
        this.name = name;
    }

    @Override
    void printItemsBorrowed() {
        System.out.println("STUDENT: " + name);
        System.out.println("BORROWED ITEM:");
        for (LibraryItem item : borrowedItems) {
            System.out.println("- " + item.toString());
        }
        System.out.println();
    }
}

// Teacher class extending LibraryUser
class Teacher extends LibraryUser {
    public Teacher(String name) {
        this.name = name;
    }

    @Override
    void printItemsBorrowed() {
        System.out.println("TEACHER: " + name);
        System.out.println("BORROWED ITEM:");
        for (LibraryItem item : borrowedItems) {
            System.out.println("- " + item.toString());
        }
        System.out.println();
    }
}

// Main class
public class LIBSYS2 {
    public static void main(String[] args) {
        // Book, DVD, Student, Teacher objects
        Book book = new Book("Jumanji", "Aahron");
        Student student = new Student("Klent");
        student.borrowItem(book);

        DVD dvd = new DVD("SongBird", "ViceGanda");
        Teacher teacher = new Teacher("Kyla");
        teacher.borrowItem(dvd);

        // Simulate returning items
        book.returnItem();
        dvd.returnItem();

        // Print borrowed items
        student.printItemsBorrowed();
        teacher.printItemsBorrowed();
    }
}
