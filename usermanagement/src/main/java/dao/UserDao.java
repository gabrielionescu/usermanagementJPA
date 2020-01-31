package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.UserModel;

public class UserDao {

  private String url = "jdbc:mysql://localhost:3308/usermanagement";
  private String user = "gabrielionescu";
  private String pass = "lordofloto13!";


  public List<UserModel> getAllUsers() {
    List<UserModel> userModels = new ArrayList<>();
    try {
      //Obiectul de conexiune
      Connection connection = DriverManager.getConnection(url, user, pass);
      //Obiectul de intructiuni.
      Statement statement = connection.createStatement();
      //crearea query-ului
      String query = "Select * from user";
      //Executa instructiunea si  intoarce-mi rezultatele.
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        int userId = resultSet.getInt("id");
        String name = resultSet.getString("nume");
        UserModel userModel = new UserModel();
        userModel.setId(userId);
        userModel.setName(name);
        userModels.add(userModel);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return userModels;
  }

  public void addUser(String name) {
    try {
      //Obiectul de conexiune
      Connection connection = DriverManager.getConnection(url, user, pass);
      //Obiectul de intructiuni.
      Statement statement = connection.createStatement();
      //crearea query-ului
      String query = "INSERT user(nume) VALUES"
                     + "('" + name +"')";

      int ret = statement.executeUpdate(query);
      System.out.println("Insert return: " + (ret == 1 ? "OK" : "ERROR"));

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Optional<UserModel> getUserById(int id) {
    try {
      //Obiectul de conexiune
      Connection connection = DriverManager.getConnection(url, user, pass);
      //Obiectul de intructiuni.
      Statement statement = connection.createStatement();
      //crearea query-ului
      String query = "Select * from user WHERE user.id=" + id;
      //Executa instructiunea si  intoarce-mi rezultatele.
      ResultSet resultSet = statement.executeQuery(query);
      if (resultSet.next()) {
        int userId = resultSet.getInt("id");
        String name = resultSet.getString("nume");
        UserModel userModel = new UserModel();
        userModel.setId(userId);
        userModel.setName(name);
        return Optional.of(userModel);

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return Optional.empty();
  }
}
