package dlte.proj1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.jdbc.driver.OracleDriver;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudConnect{
       Scanner sc=new Scanner(System.in);
       Connection connection;
        public void connect() throws SQLException {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","250601");
            PreparedStatement preparedStatement=connection.prepareStatement("alter session set current_schema=system");
            ResultSet resultSet=preparedStatement.executeQuery();
//            while (resultSet.next()){
//                Stud studs=new Stud();
//                studs.setReg_no(resultSet.getInt("stud_id"));
//                studs.setName(resultSet.getString("name"));
//                studs.setAge(resultSet.getInt("age"));
//                studs.setEmail(resultSet.getString("email"));
//                information.add(studs);
//
//                System.out.println(resultSet.getInt("stud_id"));
//            }
    }

    public void insertData() throws SQLException{
            Scanner sc=new Scanner(System.in);
            Stud stud=new Stud();
            System.out.println("Enter the reg no");
            stud.setReg_no(sc.nextInt());
            System.out.println("Enter the name");
            stud.setName(sc.next());
            System.out.println("Enter the age");
            stud.setAge(sc.nextInt());
            System.out.println("Enter the email");
            stud.setEmail(sc.next());
            System.out.println("Enter the door number");
            stud.setDoor_no(sc.nextInt());
            System.out.println("Enter the street");
            stud.setStreet(sc.next());
            System.out.println("Enter the city");
            stud.setCity(sc.next());
            System.out.println("Enter the pincode");
            stud.setPincode(sc.nextInt());

        connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","250601");
        String query="insert into student_details values(?,?,?,?) ";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,stud.getReg_no());
        preparedStatement.setString(2,stud.getName());
        preparedStatement.setInt(3,stud.getAge());
        preparedStatement.setString(4,stud.getEmail());

        int x=preparedStatement.executeUpdate();

//        String query2="insert into address_details values()"
        connection.close();
        preparedStatement.close();
        if(x==1){
            System.out.println("Insertion completed");
        }



    }

    public void displayData(){
            try{
                PreparedStatement preparedStatement=connection.prepareStatement("Select * from student_details");
                ResultSet resultSet=preparedStatement.executeQuery();
                while(resultSet.next())
                {
                    System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3)+" "+resultSet.getString(4));
                }
            }catch (Exception e){
                System.out.println("Cannot be shown.");
            }

    }
}

