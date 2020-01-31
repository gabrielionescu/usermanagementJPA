package service;

import java.util.List;

import dao.UserDao;
import model.UserModel;

public class UserService {

  private UserDao userDao = new UserDao();

  public void addNewUser(String userName) {
    userDao.addUser(userName);
  }

  public List<UserModel> getAllUsers() {
    List<UserModel> allUsers = userDao.getAllUsers();
    return allUsers;
  }

}
