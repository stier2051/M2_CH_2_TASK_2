package db;

import model.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    public static Connection conn;

    public static void connectToDb() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_manager?useUnicode=true&serverTimezone=UTC", "root", "");
            System.out.println("CONNECTED SUCCESSFULLY");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addNewTask(String name, String description, String deadlineDate) {
        try{
            PreparedStatement st = conn.prepareStatement("insert into tasks(name, description, deadlineDate) value(?,?,?)");
            st.setString(1, name);
            st.setString(2, description);
            st.setString(3, deadlineDate);
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Task successfully added");
    }

    public static ArrayList<Task> getAllTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try{
            PreparedStatement st = conn.prepareStatement("select * from tasks");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String taskName = rs.getString("name");
                String taskDescription = rs.getString("description");
                String taskDeadlineDate = rs.getString("deadlineDate");
                tasks.add(new Task(taskName, taskDescription, taskDeadlineDate));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }
}
