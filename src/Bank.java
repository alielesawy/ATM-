import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class Bank {
    Connection connect =DriverManager.getConnection(     "jdbc:mysql://localhost/ATM?serverTimezone=UTC", "Ali", "2030");
    Statement s=connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ResultSet r=s.executeQuery("SELECT `visa_num`, `password`, `name`, `bill` FROM `customer`");
    int line=0; // to get current row in database
    protected int visa_num,bill;
     String name;
     //use this variable to save customer data in it instead of get data each time from database failure may be occurred
    public Bank() throws SQLException {
    }

    public void connect()
    {
        {
            try {

                connect = DriverManager.getConnection(
                        "jdbc:mysql://localhost/ATM?serverTimezone=UTC",
                        "Ali",
                        "2030"

                );
                System.out.println("ATM Is Connected !!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean Verification (int visa) throws SQLException {
int f=0;
        while (r.next()) {

            if (visa==r.getInt("visa_num")) {
                f = 1;
                line =r.getRow();
                name=r.getString("name");
                bill=r.getInt("bill");
                visa_num= r.getInt("visa_num");
                break;
            }
            else
               f=0;
        }
    if (f==1) return true;
    else
        return false;
    }
   public boolean isValidPass(int pass) throws SQLException {
    CurrentRow();
if (pass==r.getInt(2))
        return true;
        else
         return false;
   }
   public void ChangName (String name) throws SQLException {
      CurrentRow();
       r.updateString("name",name);
       r.updateRow();
       System.out.println("Changed !");
   }
    public void ChangPass (int pass) throws SQLException {
      CurrentRow();
        if (pass!=0) {
            r.updateInt("password", pass);
            r.updateRow();
            System.out.println("Changed !");
        }
        else System.out.println("Error");
    }
    public void Withdraw (int value) throws SQLException {
       CurrentRow();

            r.updateInt("bill",bill=bill-value);
            r.updateRow();
            System.out.println("Done !\n Your Bill No Is = "+bill);
        }
    public void Deposit (int value) throws SQLException {
       CurrentRow();
            r.updateInt("bill", bill=bill+value);
            r.updateRow();
            // after operation database updated
        System.out.println("Done !\n Your Bill Now Is = "+bill);
        }
        private void CurrentRow() throws SQLException {
            int i=0;
            while (i == line){
                r.next();
                i++;
            }
        }
    }




