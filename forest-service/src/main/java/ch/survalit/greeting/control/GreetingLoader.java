package ch.survalit.greeting.control;

import ch.survalit.greeting.entity.Address;
import ch.survalit.greeting.entity.Greeting;
import ch.survalit.greeting.entity.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@ApplicationScoped
public class GreetingLoader {

    /**
     * Json P (json processing)
     */
    public JsonObject getGreeting() {
        return Json.createObjectBuilder()
                .add("name", "peter")
                .add("age", 18)
                .add("isHappy", true)
                .add("address", Json.createObjectBuilder()
                        .add("street", "some street")
                        .add("house", 15)
                        .add("zip", 5405)
                        .build())
                .build();
    }

    /**
     * Json Binding
     */
    public Greeting getGreetingWithName() {
        return new Greeting("Joe",
                18,
                true,
                new Address("sandystreet", 40));
    }

    public String returnUser() {
        Connection conDB = null;
        int id = 0;
        String fname = null;
        String mname = null;
        String lname = null;
        int age = 0;
        String bday = null;
        String inserted_date = null;
        int student_no = 0;

        try {
            conDB = DriverManager.getConnection("jdbc:mariadb://localhost:3306/student_db", "root", "");

            String sql = "SELECT * FROM student_info WHERE id = 1;";
            Statement statement = conDB.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                id = result.getInt("id");
                fname = result.getString("fname");
                mname = result.getString("mname");
                lname = result.getString("lname");
                age = result.getInt("age");
                bday = result.getString("birthday");
                inserted_date = result.getString("inserted_date");
                student_no = result.getInt("student_no");
            }

            if (conDB != null) {
                //System.out.println("Connected Successfully");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conDB.close();
            } catch (Exception e) {
                //do nothing
            }
        }
        String studentResult =
                "id: " + id + " ,fname: " + fname + " ,mname: " + mname + " ,lname: " + lname + " ,age: " + age + " ,birthday: " + bday +
                        " ,inserted_date: " + inserted_date + " ,student no: " + student_no;
        return studentResult;

    }

    public Student returnUserTemplate(int userID) {
        Connection conDB = null;
        int id = 0;
        String fname = null;
        String mname = null;
        String lname = null;
        int age = 0;
        String bday = null;
        String inserted_date = null;
        int student_no = 0;

        try {
            conDB = DriverManager.getConnection("jdbc:mariadb://localhost:3306/student_db", "root", "");

            String sql = "SELECT * FROM student_info WHERE id = " + userID + ";";
            Statement statement = conDB.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                id = result.getInt("id");
                fname = result.getString("fname");
                mname = result.getString("mname");
                lname = result.getString("lname");
                age = result.getInt("age");
                bday = result.getString("birthday");
                inserted_date = result.getString("inserted_date");
                student_no = result.getInt("student_no");
            }

            if (conDB != null) {
                //System.out.println("Connected Successfully");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conDB.close();
            } catch (Exception e) {
                //do nothing
            }
        }
        return new Student(id, fname, mname, lname, age, bday, inserted_date, student_no);
    }
}
