
package assignment;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Assignment {

   public static void fetch()
   {
       System.out.println("ID\t Name\t Mobile No  \t Email-ID");
     try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employ","root","");
            Statement st = con.createStatement();
            String sql = "SELECT *from details";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }  
   }
   
   public static void insert()
   {
       Scanner scan = new Scanner(System.in);
       System.out.print("Enter Employee ID : ");
       String id = scan.next();
       System.out.print("Enter Employee Name : ");
       String name = scan.next();
       System.out.print("Enter Employee Mob no : ");
       String mobno = scan.next();
       System.out.print("Enter Employee Email-ID : ");
       String emailid = scan.next();
       
       try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employ","root","");
            Statement st = con.createStatement();
            String sql = "INSERT into details values('"+id+"','"+name+"','"+mobno+"','"+emailid+"')";
            int count = st.executeUpdate(sql);
            System.out.println(count+" Number of rows affected");
            
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
   }
   
   public static void delete()
   {
       Scanner scan = new Scanner(System.in);
       
       System.out.print("Enter Employee Name : ");
       String name = scan.next();
       
       try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employ","root","");
            Statement st = con.createStatement();
            String sql = "DELETE FROM `details` WHERE name='"+name+"'";
            int count = st.executeUpdate(sql);
            System.out.println(count+" rows deleted");
            
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
   }
   
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("What yoy want to do...?");
        System.out.println("1.View Emp Database \n2.Update Emp Database \n3.Delete Row");
        for(;;)
        {
            
        
        System.out.print("Enter your Option : ");
        int n = scan.nextInt();
        if(n != 0)
        {
        
        if(n == 1)
        {
            fetch();
        }
        else if(n == 2)
        {
            insert();
        }
        else if(n == 3)
        {
            delete();
        }
        else
        {
            System.out.println("Enter correct input.....!");
        }
        }
        
        else
        {
                break;
        }
        
        }
        
        
        
        
    }
    
}
