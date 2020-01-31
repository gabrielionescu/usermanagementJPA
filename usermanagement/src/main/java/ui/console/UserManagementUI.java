package ui.console;

import java.util.List;
import java.util.Scanner;

import model.UserModel;
import service.UserService;

public class UserManagementUI {

  private Scanner scanner = new Scanner(System.in);
  private UserService userService = new UserService();

  public void startUserManagement() {
    System.out.println(" Bine ati venit la user management");
    int optiune = -1;
    while (optiune != 0) {
      System.out.println("Alegeti o optiune:");
      System.out.println("1. Adaugarea unui nou utilizator");
      System.out.println("2. Afisarea utilizatorilor");
      optiune = scanner.nextInt();
      scanner.nextLine();
      if (optiune == 1) {
        System.out.println("Intrduceti numele noului utilizator");
        String nume = scanner.nextLine();
        userService.addNewUser(nume);
      } else if (optiune == 2) {
        List<UserModel> users = userService.getAllUsers();
        users.forEach(user -> System.out.println(user.getId() + "." + user.getName()));

      } else {
        System.out.println("Obtiune invalida");
      }
    }


  }


}
