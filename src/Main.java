
import LibraryPackage.utils.Book;
import LibraryPackage.Library;
import LibraryPackage.Enum.LibraryRegex;
import LibraryPackage.utils.User;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
/**
 * This project is defined to manage a local library.
 * <br>
 *
 * @author Mohammad Hossein Hosseini
 * @version 1.0
 * @since 2024/13/01
 */

public class Main {
    /**
     * In this application, for any management action, such as: adding a book, deleting a book, adding a user,<br>
     * Reservation of books by the user, displaying the list of books, displaying the list of users, etc., are specific commands with specific entries.<br>
     * If any of the input commands differ even by one character from the predetermined command; You will get a "invalid command" message.<br>
     * Below is a partial description of each command. You can learn more about these commands by referring to the LibraryRegex section.
     * @see LibraryRegex
     */
    public static void main(String[] args) throws IOException {
        /*File file = new File()*/
        LibraryRegex regex = new LibraryRegex();
        Library library = new Library(/*"C:\\Users\\Negar\\IdeaProjects\\AP_Midterm_Project\\src\\usersInfo.txt",
                "C:\\Users\\Negar\\IdeaProjects\\AP_Midterm_Project\\src\\booksInfo"
                , */"jdbc:mysql://localhost:3306/jdbc", "root", "");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Matcher matcher;
        while (!command.equals("end")) {
            if (regex.createUserRegex.matcher(command).matches()) {
                matcher = regex.createUserRegex.matcher(command);
                matcher.find();
                System.out.println(library.addUser(new User(matcher.group(1), matcher.group(2), matcher.group(3))));
            } else if (regex.getUserRegex.matcher(command).matches()) {
                matcher = regex.getUserRegex.matcher(command);
                matcher.find();
                User user = library.getUser(Integer.parseInt(matcher.group(1)));
                if (user == null)
                    System.out.println("user not found");
                else
                    System.out.println(matcher.group(1) + " " + user.getName() + " " + user.getEmail());
            } else if (regex.getListOfUserRegex.matcher(command).matches()) {
                System.out.print(library.getAllUsers());
            } else if (regex.removeUserRegex.matcher(command).matches()) {
                matcher = regex.removeUserRegex.matcher(command);
                matcher.find();
                System.out.println(library.deleteUser(Integer.parseInt(matcher.group(1))));
            } else if (regex.createBookRegex.matcher(command).matches()) {
                matcher = regex.createBookRegex.matcher(command);
                matcher.find();
                System.out.println(library.addBook(new Book(matcher.group(1), matcher.group(2), matcher.group(3), "0")));
            } else if (regex.deleteBookRegex.matcher(command).matches()) {
                matcher = regex.deleteBookRegex.matcher(command);
                matcher.find();
                System.out.println(library.deleteBook(matcher.group(1)));
            } else if (regex.getBookRegex.matcher(command).matches()) {
                matcher = regex.getBookRegex.matcher(command);
                matcher.find();
                Book book = library.getBook(matcher.group(1));
                if (book != null)
                    System.out.println(book);
                else
                    System.out.println("book not found");
            } else if (regex.getListOfBookRegex.matcher(command).matches()) {
                System.out.print(library.getAllBook());
            } else if (regex.borrowBookRegex.matcher(command).matches()) {
                matcher = regex.borrowBookRegex.matcher(command);
                matcher.find();
                System.out.println(library.borrowBook(matcher.group(1), Integer.parseInt(matcher.group(2)), false));
            } else if (regex.returnBookRegex.matcher(command).matches()) {
                matcher = regex.returnBookRegex.matcher(command);
                matcher.find();
                System.out.println(library.returnBook(Integer.parseInt(matcher.group(2)), matcher.group(1)));
            } else {
                System.out.println("invalid command!");
            }
            command = scanner.nextLine();
        }
//        library.closeWriters();
    }
}