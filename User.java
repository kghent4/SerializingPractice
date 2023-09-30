public class User{

  private String username;
  private String password;
  private double checkingBalance;
  private double savingsBalance;
  
  public User(String u, String p){
    username = u;
    password = p;
    checkingBalance = 0.0;
    savingsBalance = 0.0;
  }

  public String getUsername(){
    return username;
  }

  public String getPassword(){
    return password;
  }

  public double getCheckingBalance(){
    return checkingBalance;
  }

  public double getSavingsBalance(){
    return savingsBalance;
  }

  public String setCheckingBalance(double amount){
    checkingBalance += amount;    
    if (amount < 0){
        return ("Withdrawal successful.");
      }
    else{
        return ("Deposit successful.");
      }
    }

    public String setSavingsBalance(double amount){
    savingsBalance += amount;    
    if (amount < 0){
        return ("Withdrawal successful.");
      }
    else{
        return ("Deposit successful.");
      }
    }
}