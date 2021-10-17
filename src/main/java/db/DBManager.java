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
            PreparedStatement st = conn.prepareStatement("insert into tasks(name, description, status, deadlineDate) value(?,?,?,?)");
            st.setString(1, name);
            st.setString(2, description);
            st.setString(3, "Нет");
            st.setString(4, deadlineDate);
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
                Long id = rs.getLong("id");
                String taskName = rs.getString("name");
                String taskDescription = rs.getString("description");
                String taskStatus = rs.getString("status");
                String taskDeadlineDate = rs.getString("deadlineDate");
                tasks.add(new Task(id, taskName, taskDescription, taskStatus, taskDeadlineDate));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public static Task getTask(Long id) {
        Task task = new Task();
        try{
            PreparedStatement st = conn.prepareStatement("select * from tasks where id = ?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String taskName = rs.getString("name");
                String taskDescription = rs.getString("description");
                String taskStatus = rs.getString("status");
                String taskDeadlineDate = rs.getString("deadLineDate");
                task = new Task(taskName, taskDescription, taskStatus, taskDeadlineDate);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return task;
    }

    public static void updateTask(Long id, String name, String description, String status, String deadlineDate) {
        try{
            PreparedStatement st = conn.prepareStatement("update tasks set name = ?, description = ?, status = ?, deadlineDate = ? where id = ?");
            st.setString(1, name);
            st.setString(2, description);
            st.setString(3, status);
            st.setString(4, deadlineDate);
            st.setLong(5, id);
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Task successfully updated");
    }

    public static void deleteTask(Long id) {
        try{
            PreparedStatement st = conn.prepareStatement("delete from tasks where id = ?");
            st.setLong(1, id);
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
