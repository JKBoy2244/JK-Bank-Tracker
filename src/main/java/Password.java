import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;


class Password extends RegisterAccount implements Register {

  private static final int maxAttempts = 3;
  private static final String regex = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*";
  private static final int minimum = 15;
  private static final int maximum = 25;

  private String password;
  private String confirmPassword;
  private int passCode;

  public Password(String username, int age, String gender, String phoneNumber, String emailAddress, String password, String confirmPassword, int passCode) {

    super(username, age, gender, phoneNumber, emailAddress);
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.passCode = passCode;

  }

  public String getPassword() {
    return password;
  }

  public String getConfirmPassword() {
     return confirmPassword;
  }

  public int getPassCode() {
     return passCode;
  }

  private static void RemainingAttempts(int attempts, int maxAttempts) {
    System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");
  }

  private LinkedHashSet<String> passwords = new LinkedHashSet<String>();
  private LinkedHashSet<String> confirmedPasswords = new LinkedHashSet<String>();
  private ArrayList<Integer> passCodes = new ArrayList<Integer>();

  @Override
  public void password() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    String password = "";

    while (attempts < maxAttempts) {

      System.out.println("Please enter your password attaining all of the requirements: non-empty, between 15 to 25 characters long, and at least 1 special character: ");
      password = sc.nextLine();
      attempts++;

      if (password == null || password.trim().isEmpty() || (password.length() < minimum || password.length() > maximum)) {
        if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
         }
           RemainingAttempts(attempts, maxAttempts);
           System.out.println("Sorry, your password is empty!");
           continue;
        }

        if (!password.matches(regex)){
          if (attempts == maxAttempts) {
              System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
              return;
            }
             RemainingAttempts(attempts, maxAttempts);
             System.out.println("Sorry, your password doesn't have a special character!");
             continue;
          }

        if (passwords.contains(password)) {
          if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
           RemainingAttempts(attempts, maxAttempts);
           System.out.println("Sorry, that password is already taken and every username should have one unique password!");
           continue;
        }

        this.password = password;
        break;   
      }
    } 

  @Override
  public void confirmPassword() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    String confirmPassword = "";

    while (attempts < maxAttempts) {
      System.out.println("Please confirm your password: ");
      confirmPassword = sc.nextLine();
      attempts++;

      if (confirmPassword == null || confirmPassword.trim().isEmpty()) {
        if (attempts == maxAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }
         RemainingAttempts(attempts, maxAttempts);
         System.out.println("Sorry, your confirm password shouldn't be empty!");
         continue;
      }

      if (!confirmPassword.equals(password)) {
        if (attempts == maxAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }
         RemainingAttempts(attempts, maxAttempts);
         System.out.println("Sorry, your confirm password doesn't match your password!");
         continue;
      }

      this.confirmPassword = confirmPassword;
      break;
    }
  }

  @Override
  public void passCode() {
    System.out.println("You will be given a 9 digit passcode randomly generated for you to be able to use your account!");
    Random random = new Random();
    this.passCode = random.nextInt(100000000, 1000000000);
    System.out.println("Your passcode is: " + this.passCode);
  }

  public void addRegister(String password, String confirmPassword, int passCode) {

    passwords.add(password);
    confirmedPasswords.add(confirmPassword);
    passCodes.add(passCode);

  }

  @Override
  public void confirm() {

    super.confirm();
    System.out.println("Password: " + password);
    System.out.println("Confirm Password: " + confirmPassword);
    System.out.println("Passcode: " + passCode);

  }
}
