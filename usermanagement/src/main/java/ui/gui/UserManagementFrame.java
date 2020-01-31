package ui.gui;

import java.awt.*;

import javax.swing.*;

import service.UserService;

public class UserManagementFrame extends JFrame {

  private UserManagementPanel userManagementPanel = new UserManagementPanel();
  private UserService userService = new UserService();


  UserManagementFrame(){
    setVisible(true);
    setSize(new Dimension(1000,800));
    setContentPane(userManagementPanel);
    userManagementPanel.displayUsers(userService.getAllUsers());
    repaint();
  }

}
