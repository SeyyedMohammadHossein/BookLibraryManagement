import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;


public class Main {
    public static void main(String[] args) throws IOException {
        /*File file = new File()*/
        LibraryRegex regex = new LibraryRegex();
        Library library = new Library("C:\\Users\\Negar\\IdeaProjects\\AP_Midterm_Project\\src\\usersInfo.txt",
                "C:\\Users\\Negar\\IdeaProjects\\AP_Midterm_Project\\src\\booksInfo");
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
                System.out.println(library.borrowBook(matcher.group(1), Integer.parseInt(matcher.group(2))));
            } else if (regex.returnBookRegex.matcher(command).matches()) {
                matcher = regex.returnBookRegex.matcher(command);
                matcher.find();
                System.out.println(library.returnBook(Integer.parseInt(matcher.group(2)), matcher.group(1)));
            }
            command = scanner.nextLine();
        }
        library.closeWriters();
    }
}