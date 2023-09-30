import java.util.ArrayList;
public class BankUserInterface {

    public static void main(String[] args) {

      ArrayList<User> users = new ArrayList<User>();
      users.add(new User("Gavin", "Gray"));
      AccountsGUI screen2 = new AccountsGUI(users);
      LoginGUI screen1 = new LoginGUI(users, screen2);
      
    }
}
