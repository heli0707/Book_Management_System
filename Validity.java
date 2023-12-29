import java.util.Scanner;
import java.util.regex.Pattern;

public class Validity {

    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";

    // set validation from pattern class of util package
    private static Pattern PublishYear_Pattern=Pattern.compile("^\\d{4}$");
    private static Pattern AuthorTitle_Pattern=Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");

    Scanner sc = new Scanner(System.in);

    //check book id - only valid in digits
    public String validateId() {
        String bookid;
        while (true) {
            System.out.println("Enter Book ID ");
            bookid = sc.nextLine();
            if (!ID_PATTERN.matcher(bookid).matches()) {
                System.out.println(RED+"  SORRY ! PLEASE ENTER VALID BOOK ID  "+RESET);
            } else {
                break;
            }
        }
        return bookid;
    }

    // check book author & title - only valid in character capital/small
    public String validateAuthorTitle(String input){
        String result;
        while (true){
            if(input == "Title"){
                System.out.println("Enter Title");
            }else{
                System.out.println("Enter Author");
            }
            result=sc.nextLine();
            if(!AuthorTitle_Pattern.matcher(result).matches()){
                System.out.println(RED+"Please Enter Valid AuthorTitle"+input+RESET);
            } else {
                break;
            }
        }
        return result;
    }

    // check book publish year - only valid in 4 digits
    public String validatePublishYear(){
        String year;
        while(true){
            System.out.println("Enter Publish Year of Book ");
            year=sc.nextLine();
            if(!PublishYear_Pattern.matcher(year).matches()){
                System.out.println(RED+"Enter valid Publish Year"+RESET);
            }
            else{
                break;
            }
        }
        return year;
    }

}