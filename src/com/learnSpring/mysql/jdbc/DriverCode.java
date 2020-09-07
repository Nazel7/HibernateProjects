package com.learnSpring.mysql.jdbc;

import java.sql.*;

public class DriverCode {
    public static void main(String[] args) throws SQLException {
        String jdbc= "jdbc:mysql://localhost:3306/hb_student_tracker?useSSl=false";
        String user= "hbstudent";
        String passcode= "hbstudent";

        try(Connection connection= DriverManager.getConnection(jdbc, user,passcode);
            Statement statement= connection.createStatement()){
            System.out.println("Connecting to: "+ jdbc);
//            statement.execute("SELECT * FROM hb_student_tracker.student");
//            ResultSet resultSet= statement.getResultSet();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM hb_student_tracker.student");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id") + " "+ resultSet.getString("first_name")+
                        " "+resultSet.getString("last_name"));
            }
            System.out.println("conneted to database");

        }
    }


}
