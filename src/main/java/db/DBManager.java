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

    public static void addNewTask(Task task) {
        try{
            PreparedStatement st = conn.prepareStatement("insert into tasks values (null, ?, ?, ?, ?)");
            st.setString(1, task.getName());
            st.setString(2, task.getDescription());
            st.setString(3, task.getStatus());
            st.setString(4, task.getDeadlineDate());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Task> getAllTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try{
            PreparedStatement st = conn.prepareStatement("select * from tasks order by id desc");
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
                task = new Task(id, taskName, taskDescription, taskStatus, taskDeadlineDate);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return task;
    }

    public static void updateTask(Task task) {
        try{
            PreparedStatement st = conn.prepareStatement("update tasks set name = ?, description = ?, status = ?, deadlineDate = ? where id = ?");
            st.setString(1, task.getName());
            st.setString(2, task.getDescription());
            st.setString(3, task.getStatus());
            st.setString(4, task.getDeadlineDate());
            st.setLong(5, task.getId());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
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
