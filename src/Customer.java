import java.sql.*;
import java.util.Scanner;

public class Customer extends Bank {
Customer () throws SQLException {
    super();
    System.out.println("Hello There !");
}
public int getVisa(){
    System.out.println("Enter Your Card");
    int value= new Scanner(System.in).nextInt();
    return value;
}
    protected int getPass(){
        System.out.println("Enter Your Password");
        int value= new Scanner(System.in).nextInt();
        return value;
    }
    protected String Name()
    {
        System.out.println("Enter Your Name");
        String value= new Scanner(System.in).nextLine();
        return value;
    }
    protected int ChangePaas(){
        System.out.println("Enter Your new password .\n\t Must be 6 digits");
        int value= new Scanner(System.in).nextInt();
        System.out.println("Enter Your password again to confirm");
        int value2= new Scanner(System.in).nextInt();
        if (String.valueOf(value).length()==6&&value==value2) //use string to check if number of digits in pass equal 6 or not
        return value;
        else
            System.out.println("Unacceptable Password ");
        return 0;
    }

    protected int getWithdraw(){
        System.out.println("Your Bill is = "+bill+" How Much You Want");
        int value= new Scanner(System.in).nextInt();
        if (value<=bill)
        return value;
        else System.out.println("You haven't Enough Money ");
        return 0;
    }
    protected int getDeposit(){
        System.out.println("Enter the count of Money");
        int value= new Scanner(System.in).nextInt();
        return value;
    }
}
