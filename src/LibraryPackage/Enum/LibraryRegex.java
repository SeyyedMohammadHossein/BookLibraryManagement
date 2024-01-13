package LibraryPackage.Enum;

import java.util.regex.Pattern;

public class LibraryRegex {
    /**
     * To define each user, your input command must like the command below:<br>
     *     --create-user mohammad hossein@gmail.com 121584789
     */
    public Pattern createUserRegex = Pattern.compile("create-user (\\w+) ([\\w.\\d]+@\\w+.\\w+) (.+)"),
    /**
     * To find a user in the list of users in the library, proceed as follows (Note that to delete a user, you must enter the desired user ID):<br>
     *      --get_user 1
     */
            getUserRegex = Pattern.compile("get_user (\\d+)"),
    /**
     * To see the list of all users, you must use the following command:<br>
     *      --getـlist_of_users
     */
            getListOfUserRegex = Pattern.compile("getـlist_of_users"),
    /**
     * To remove a user from the list of library users, use the following command(Note that to delete a user, you must enter the desired user ID):<br>
     *      --delete-user 1
     */
            removeUserRegex = Pattern.compile("delete-user (\\d+)"),
    /**
     * To add a book to the list of available books, follow the instructions below:<br>
     *      --create-book Farar_Az_ZNU Dr.Hosseini 12348
     * @implNote Note that each book must have a unique ISBN, and adding a book with a duplicate ISBN will result in an error.
     */
            createBookRegex = Pattern.compile("create-book ([\\w,.,_]+) ([\\w,.]+) (\\d+)"),
    /**
     * To remove a book from the list of available books, you must enter the ISBN of the desired book in the console like the following command:<br>
     *      --delete-book 12348
     */
            deleteBookRegex = Pattern.compile("delete-book (\\d+)"),
    /**
     * You can use the following command to find a book in the list of books in the library and to check the loan status of the book:<br>
     *      --get_book 12348
     */
            getBookRegex = Pattern.compile("get_book (\\d+)"),
    /**
     * Use the command below to see the list of all available books.<br>
     *      --getـlist_of_books
     */
            getListOfBookRegex = Pattern.compile("getـlist_of_books"),
    /**
     * To register lending a book to a user according to the following command, first enter the ISBN of the book and then the ID of the desired user.<br>
     *      --borrow_book 12348 to 1
     */
            borrowBookRegex = Pattern.compile("borrow_book (\\d+) to (\\d+)"),
    /**
     * To register the return of a book by the user according to the following command, first enter the ISBN of the book and then the desired user ID.<br>
     *      --return_book 12348 from 1
     */
            returnBookRegex = Pattern.compile("return_book (\\d+) from (\\d+)");
}
