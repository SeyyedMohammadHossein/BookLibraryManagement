import java.util.regex.Pattern;

public class LibraryRegex {
    Pattern createUserRegex = Pattern.compile("create-user (\\w+) ([\\w.\\d]+@\\w+.\\w+) (.+)"),
            getUserRegex = Pattern.compile("get_user (\\d+)"),
            getListOfUserRegex = Pattern.compile("getـlist_of_users"),
            removeUserRegex = Pattern.compile("delete-user (\\d+)"),
            createBookRegex = Pattern.compile("create-book ([\\w,.,_]+) ([\\w,.]+) (\\d+)"),
            deleteBookRegex = Pattern.compile("delete-book (\\d+)"),
            getBookRegex = Pattern.compile("get_book (\\d+)"),
            getListOfBookRegex = Pattern.compile("getـlist_of_books"),
            borrowBookRegex = Pattern.compile("borrow_book (\\d+) to (\\d+)"),
            returnBookRegex = Pattern.compile("return_book (\\d+) from (\\d+)");
}
