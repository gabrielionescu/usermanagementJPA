package ui.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import model.UserModel;
import service.UserService;

public class UserManagementPanel extends JPanel {

  private JButton addUser = new JButton("Add users");
  private JPanel northPanel = new JPanel();
  private JPanel centralPanel = new JPanel();
  private JPanel usersPanel = new JPanel();
  private UserService userService = new UserService();

  UserManagementPanel() {
    setLayout(new BorderLayout());
    AddUserListener addUserListener = new AddUserListener();
    addUser.addActionListener(addUserListener);
    northPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    northPanel.add(addUser);
    centralPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    usersPanel.setLayout(new GridLayout(0, 1));
    centralPanel.add(usersPanel);
    add(northPanel, BorderLayout.NORTH);
    add(centralPanel, BorderLayout.CENTER);
  }


  public void displayUsers(List<UserModel> users) {
    usersPanel.removeAll();
    for (UserModel user : users) {
      JPanel userPanel = new JPanel();
      userPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      userPanel.add(new JLabel(user.getId() + ". " + user.getName()));
      usersPanel.add(userPanel);
    }
    revalidate();
    repaint();

  }

  class AddUserListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      String result = JOptionPane.showInputDialog(UserManagementPanel.this, "Enter user name:");
      userService.addNewUser(result);
      displayUsers(userService.getAllUsers());
    }
  }
}
