package lk.ijse.todo.model;

import lk.ijse.todo.db.DBConnection;
import lk.ijse.todo.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {


    public static boolean saveUser(UserDTO userDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO user VALUES (?,?,?)");
        statement.setObject(1, userDTO.getEmail());
        statement.setObject(2, userDTO.getName());
        statement.setObject(3, userDTO.getPassword());

        int i = statement.executeUpdate();
        return 0 < i;

    }

    public static String getEmail(String email) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT email FROM user WHERE email=?");
        statement.setObject(1, email);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }

    public static boolean isExistUser(String userName, String pw) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT password ,name ,email FROM user WHERE name=? AND password=?");
        statement.setObject(1, userName);
        statement.setObject(2, pw);
        ResultSet resultSet = statement.executeQuery();
        String dbUserName = null;
        String dbPassword = null;
        if (resultSet.next()) {
            dbPassword = resultSet.getString(1);
            dbUserName = resultSet.getString(2);
            DBConnection.email = resultSet.getString(3);
        }
        return userName.equals(dbUserName) && pw.equals(dbPassword);
    }
}
