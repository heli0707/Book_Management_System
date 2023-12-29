import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServices implements BookServiceInterface {

    //declare color for color text
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    public static final String GREEN="\u001B[32m";
    public static final String CYAN="\u001B[36m";

    Scanner sc = new Scanner(System.in);

    Validity validity=new Validity();
    List<Book> books = new ArrayList<>();

    // create book class object and check all validation of books also add book in Arraylist of Book
    @Override
    public void addBook() {

        String bookid= validity.validateId();
        String Author=validity.validateAuthorTitle("Author");
        String Title=validity.validateAuthorTitle("Title");
        String year=validity.validatePublishYear();

        Book book = new Book(bookid,Author,Title,year,"Available");
        books.add(book);
        System.out.println(GREEN+"Book Added Successfully !!!"+RESET);

    }

    @Override
    public void showAllBooks() {
        boolean flag=false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format(CYAN+"%s%15s%15s%20s%15s","ID","TITLE","AUTHOR","PUBLISH YEAR","STATUS"+RESET);
        System.out.println("\n----------------------------------------------------------------------------------------------");

        for (Book book:books){
            System.out.format("%s%15s%15s%15s%15s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(),book.getStatus());
            System.out.println();
            flag=true;
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if(flag==false)
            System.out.println(RED+"There are no Books in Library"+RESET);
    }
    public void showAllAvailableBooks(){
        boolean flag=false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format(CYAN+"%s%15s%15s%15s%15s","ID","TITLE","AUTHOR","PUBLISH YEAR","STATUS"+RESET);
        System.out.println("\n----------------------------------------------------------------------------------------------");

        if(books.size()>0){
            for (Book book:books){
                if(book.getStatus() == "Available"){
                    System.out.format("%s%15s%15s%15s%20s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(),book.getStatus());
                    System.out.println();
                    flag=true;
                }
            }
        }
        else {
            System.out.println(RED+"No Books Available in the library"+RESET);
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if(flag==false)
            System.out.println(RED+"There are no books with status Available"+RESET);

    }

    // any book borrow by user that it will auto unavailable
    public void borrowBook(){
        String bookid= validity.validateId();
        boolean flag=false;
        for(Book book:books){
            if(book.getId().equals(bookid) && book.getStatus().equals("Available")){
                flag=true;
                System.out.println(GREEN+"Book Borrowed Successfully !!!"+RESET);
                book.setStatus("Not Available");
                System.out.println("Borrowed Book Details: "+book);
            }
        }
        if(flag==false)
            System.out.println(RED+"This book is not available to borrow"+RESET);
    }

    public void returnBook(){
        boolean flag=false;
        String bookid= validity.validateId();
        for(Book book:books){
            if(book.getId().equals(bookid) && book.getStatus().equals("Not Available")){
                flag=true;
                System.out.println(GREEN+"Book Returned Successfully !!!"+RESET);
                book.setStatus("Available");
                System.out.println("Returned Book Details: "+book);
            }
        }
        if(flag==false)
            System.out.println(RED+"We can not return this book"+RESET);
    }
}