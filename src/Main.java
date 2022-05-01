import java.sql.SQLException;
import java.util.Scanner;

class Test{
    public static void main(String[] args) throws SQLException {
        Customer c=new Customer();
        c.connect();
    if (c.Verification(c.getVisa())){
       A: if (c.isValidPass(c.getPass())){
      int op=0;
           System.out.println("Hello Mr. "+c.name);
      while (op!=9){
          System.out.println("\n1-Account Balance\n2-Change Name\n3-Change Password\n4-Withdraw Money\n5-Deposit Money\n9-to cancel");
        op=new Scanner(System.in).nextInt();
          switch (op){
          case 1:
              System.out.println("Your Account Balance = "+c.bill);;break;
          case 2:c.ChangName(c.Name());break;
          case 3:c.ChangPass(c.ChangePaas());break;
          case 4:c.Withdraw(c.getWithdraw());break;
          case 5:c.Deposit(c.getDeposit());break;
          case 9:break;
          default:
              System.out.println("Wrong Choise");
      }}
        }
        else {
           System.out.println("Try again Invalid Password");
           break A;
       }
    }
    else {
        System.out.println("Invalid Card");
    }


    }
}