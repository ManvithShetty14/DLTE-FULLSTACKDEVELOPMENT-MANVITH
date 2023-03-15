package dlte.proj1;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc =new Scanner(System.in);
        StudConnect sconnect=new StudConnect();
        int ch;
        do{
        System.out.println("Enter your choice");

        System.out.println("1. Insert");
        System.out.println("2. Display");
        System.out.println("3. Exit");
        ch=sc.nextInt();

        switch(ch){
            case 1:
                sconnect.insertData();
                break;
            case 2:
                sconnect.displayData();
                break;
            case 3:
                return;

        }
    }while(ch!=5);
}
}
