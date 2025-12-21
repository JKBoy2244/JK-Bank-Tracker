import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;


abstract class RegisterAccount implements RegisterInterface {

  private static final int maxAttempts = 3;

  private String username;
  private int age;
  private String gender;
  private String phoneNumber;
  private String emailAddress;

  public RegisterAccount(String username, int age, String gender, String phoneNumber, String emailAddress) {
    this.username = username;
    this.age = age;
    this.gender = gender;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  public String getUserName() {
    return username;
  }

  public int getAge() {
    return age;
  }

  public String getGender() {
    return gender;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  private static void RemainingAttempts(int attempts, int maxAttempts) {
    System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");
  }

  private LinkedHashSet<String> usernames = new LinkedHashSet<String>();
  private ArrayList<Integer> ages = new ArrayList<Integer>();
  private ArrayList<String> genders = new ArrayList<String>();
  private LinkedHashSet<String> phoneNumbers = new LinkedHashSet<String>();
  private LinkedHashSet<String> emailAddresses = new LinkedHashSet<String>();

  public void username() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    String username = "";

    while (attempts < maxAttempts) {

      System.out.println("Please enter your username which can't be empty and is between 10 and 20 characters long: ");
      username = sc.nextLine();
      attempts++;

      if (username == null || username.trim().isEmpty() || (username.length() < 10 || username.length() > 20)) {
        if (attempts == maxAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }

        RemainingAttempts(attempts, maxAttempts);
        System.out.println("Sorry, either, your username is empty or is out of character length!");
        continue;
      }

      if (usernames.contains(username)) {
        if (attempts == maxAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }

        RemainingAttempts(attempts, maxAttempts);
        System.out.println("Sorry, that username is already used!");
        continue;
      }

      this.username = username;
      break;

    }
  }

  public void age() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    String ageStr = "";

    while (attempts < maxAttempts) {

      try {

        System.out.println("Enter your age which can't be empty (You need to be at least 16 to create an account here: ");
        ageStr = sc.nextLine();
        attempts++;

        if (ageStr == null || ageStr.trim().isEmpty()) {
          if (attempts == maxAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }
        RemainingAttempts(attempts, maxAttempts);
        System.out.println("Sorry, your age is empty!");
        continue;
        }
        age = Integer.parseInt(ageStr);

        if (age < 16 || age > 100) {
          if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          RemainingAttempts(attempts, maxAttempts);
          System.out.println("Sorry, your age is out of range!");
          continue;
        }

      } catch (NumberFormatException e) {

        if (attempts == maxAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }

           RemainingAttempts(attempts, maxAttempts);    
           System.out.println("Your age is an invalid input!");
           continue;
        }

       this.age = Integer.parseInt(ageStr);
       break;
    }
  }

  public void gender() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    String gender = "";

    while (attempts < maxAttempts) {

      System.out.println("Please state your gender: Male, Female, or Rather not say!");
      gender = sc.nextLine();
      attempts++;

      if (gender == null || gender.trim().isEmpty() || (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && !gender.equalsIgnoreCase("Rather not say"))) {
        if (attempts == maxAttempts) {
           System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
           return;
         }

         RemainingAttempts(attempts, maxAttempts);
         System.out.println("Sorry, your gender is invalid input!");
         continue;
      }

      this.gender = gender;
      break;
    } 
  }

  public void phoneNumber() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    String input = "";

    while (attempts < maxAttempts) {

        System.out.println("Please enter your phone number starting with 07 and is 11 digits long exactly which can't be empty: ");
        input = sc.nextLine();
        attempts++;

        if (input == null || input.trim().isEmpty()) {
          if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("Sorry, your phone number is empty!");
          RemainingAttempts(attempts, maxAttempts);
          continue;
          }

        if (input.length() != 11 || !input.startsWith("07")) {
          if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("Sorry, your phone number is invalid format!");
          RemainingAttempts(attempts, maxAttempts);
          continue;
        }

        if (!input.matches("\\d+")) {
          if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("Sorry, no numbers present!");
          RemainingAttempts(attempts, maxAttempts);
          continue;    
        }

        if (phoneNumbers.contains(input)) {
          if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("Sorry, that phone number is already taken!");
          RemainingAttempts(attempts, maxAttempts);
          continue;
        }

        this.phoneNumber = input;
        break;
    }
  }

   public void emailAddress() {

     Scanner sc = new Scanner(System.in);
     int attempts = 0;
     String emailAddress = "";

     while (attempts < maxAttempts) {

       System.out.println("Please enter your email address which can't be empty and correct structure!");
       emailAddress = sc.nextLine();
       attempts++;

       if (emailAddress == null || emailAddress.trim().isEmpty()) {
         if (attempts == maxAttempts) {
           System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
           return;
         }
         RemainingAttempts(attempts, maxAttempts);
         System.out.println("Sorry, your email address is empty!");
         continue;
      }

       if (!emailAddress.endsWith("@gmail.com") && !emailAddress.endsWith("@yahoo.com") && !emailAddress.endsWith("@hotmail.com") && !emailAddress.endsWith("@icloud.com")) {
         if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          RemainingAttempts(attempts, maxAttempts);
          System.out.println("Sorry, your email address is an invalid format!");
          continue;
       }

       if (emailAddresses.contains(emailAddress)) {
         if (attempts == maxAttempts) {
           System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
           return;
         }
         RemainingAttempts(attempts, maxAttempts);
         System.out.println("Sorry, the email address is already used. Everyone should have one unique email address!");
         continue;
       }

       this.emailAddress = emailAddress;
       break;
   }
  }

  public void addRegister(String userName, int age, String gender, String phoneNumber, String emailAddress) {

    usernames.add(username);
    ages.add(age);
    genders.add(gender);
    phoneNumbers.add(phoneNumber);
    emailAddresses.add(emailAddress);

  }

  public void confirm() {
    System.out.println("User Information so far!");
    System.out.println("----------------");
    System.out.println("Username: " + username);
    System.out.println("Age: " + age);
    System.out.println("Gender: " + gender);
    System.out.println("Phone Number: " + phoneNumber);
    System.out.println("Email Address: " + emailAddress);
    System.out.println("----------------");
  }

  abstract public void password();
  abstract public void confirmPassword();
  abstract public void passCode();

}
