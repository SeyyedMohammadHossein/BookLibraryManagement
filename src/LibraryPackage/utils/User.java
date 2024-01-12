package LibraryPackage.utils;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    
    List<Book> borrowedBooks;

    public User(String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
        borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addToBorrowedList(Book book){
        borrowedBooks.add(book);
    }

    public void removeFromBorrowedList(Book book){
        /*borrowedBooks.forEach(book1 -> {
            if (book1.getISBN().equals(book.getISBN())) {
                borrowedBooks.remove(book1);
                return;
            }
        });*/
        for (Book tempBook : borrowedBooks) {
            if (tempBook.getISBN().equals(book.getISBN())){
                borrowedBooks.remove(tempBook);
                return;
            }
        }
        throw new RuntimeException("Book not found!");
    }

    public List<Book> getBorrowedList(){
        return borrowedBooks;
    }

    public String toString(){
        String output = this.getName() + " " + this.getEmail() + " " + this.getPassword() + "\n";
        for (Book book : borrowedBooks) {
            output += "    " + book.toString() + "\n";
        }
        output += "------------------";
        return output;
    }
}
