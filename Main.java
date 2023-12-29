import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        BookServiceInterface service = new BookServices();

        // Welcome msg and list of services
        do{

            System.out.println("\nWelcome to Library Management System");
            System.out.println("\n1.Add Book\n"+
                    "2.Show All Books\n"+
                    "3.Show Available Books\n"+
                    "4.Borrow Book\n"+
                    "5.Return Book\n"+
                    "6.Exit\n");

            // Enter your choice as int data according to the list show above
            System.out.print("Enter Your Choice !  ");
            int ch = sc.nextInt();

            // For each operation method call using switch case
            switch (ch) {
                case 1:
                    service.addBook();
                    break;
                case 2:
                    service.showAllBooks();
                    break;
                case 3:
                    service.showAllAvailableBooks();
                    break;
                case 4:
                    service.borrowBook();
                    break;
                case 5:
                    service.returnBook();
                    break;
                case 6:
                    System.out.println("\nThank you for visiting..!!");
                    System.exit(0);
                    break;
                default:
                    System.out.print("\nPlease Enter Valid Choice !  ");

            }
        }
        while(true);
    }
}