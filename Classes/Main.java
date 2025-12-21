import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;


class Main {

  private static ArrayList<String> usernames = new ArrayList<String>();  
  private static ArrayList<Integer> ages = new ArrayList<Integer>();
  private static ArrayList<String> genders = new ArrayList<String>();
  private static ArrayList<String> phonenumbers = new ArrayList<String>();
  private static ArrayList<String> emailaddresses = new ArrayList<String>();
  private static ArrayList<String> passwords = new ArrayList<String>();  
  private static ArrayList<Integer> passcodes = new ArrayList<Integer>();
  private static ArrayList<Double> cashAmount = new ArrayList<Double>();

 public static void main(String[] args) {


  Scanner sc = new Scanner(System.in);
  String optionStr = "";
  int option = 0;

  while (true) {

    try {
      System.out.println("1). Log in, 2). Register, 3). Exit , so choose option 1 or 3:");
      optionStr = sc.nextLine();
      if (optionStr == null || optionStr.trim().isEmpty()) {
        System.out.println("Option can't be empty!");
        continue;
      }

      option = Integer.parseInt(optionStr);
      if (option < 1 || option > 3) {
        System.out.println("Sorry, option out of range!");
        continue;
      }

      switch (option) {

        case 1: 

          System.out.println("Log in!");
          login();
          break;

        case 2:
          Introduction intro = new Introduction();
          intro.messageDisplay();

          Password register = new Password("",0,"","","","","", 0);
          register.username();
          register.age();
          register.gender();
          register.phoneNumber();
          register.emailAddress();

          String username = register.getUserName();
          int age = register.getAge();
          String gender = register.getGender();
          String phoneNumber = register.getPhoneNumber();
          String emailAddress = register.getEmailAddress();

          register.addRegister(username, age, gender, phoneNumber, emailAddress);
          
          register.password();
          if (register.getPassword() != null && !register.getPassword().isEmpty()) {
            register.confirmPassword();
            if (register.getConfirmPassword() != null && !register.getConfirmPassword().isEmpty()) {
              register.passCode();
              register.addRegister(register.getPassword(), register.getConfirmPassword(), register.getPassCode());
              register.confirm();
            }
          }


          InitialMoneyTransfer money = new InitialMoneyTransfer(1000.00);
          money.addMoney(money.getMoney());
          money.moneyMessage(register);

          usernames.add(username);
          ages.add(age);
          genders.add(gender);
          phonenumbers.add(phoneNumber);
          emailaddresses.add(emailAddress);
          passwords.add(register.getPassword());
          passcodes.add(register.getPassCode());
          cashAmount.add(money.getMoney());  

          break;

        case 3:
          System.out.println("Exit!");
          System.exit(0);
      }

    } catch (NumberFormatException e) {
      System.out.println("Sorry, invalid option!");
      continue;
    }
   }
  }

  public static void login() {

    Scanner sc = new Scanner(System.in);
    String userName = "";
    String passWord = "";
    String passCodeStr = "";
    int passCode = 0;
    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

      try {
        System.out.println("Please enter your username: ");
        userName = sc.nextLine();
        System.out.println("Please enter your password: ");
        passWord = sc.nextLine();
        System.out.println("Please enter your allocated passcode: ");
        passCodeStr = sc.nextLine();
        attempts++;

       if ((userName == null || userName.trim().isEmpty()) || (passWord == null || passWord.trim().isEmpty()) || (passCodeStr == null || passCodeStr.trim().isEmpty())) {
         if (attempts == maxAttempts) {
           System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
           return;
         }
          System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");
          System.out.println("Sorry, one of your inputs is empty which shouldn't be allowed!");
          continue;
       }

       passCode = Integer.parseInt(passCodeStr);

       int userIndex = usernames.indexOf(userName);     

      if (userIndex == -1 || !passwords.get(userIndex).equals(passWord) || !passcodes.get(userIndex).equals(passCode)){
            if (attempts == maxAttempts) {
                System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
                return;
            }
            System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");
            System.out.println("Sorry, one of your information is incorrect!");
            continue;
    } 
      } catch (NumberFormatException e) {
        if (attempts == maxAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }
        System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");
        System.out.println("Sorry, one of your information is incorrect!");
        continue;

    }
  }

  optionsMenu(userName, passWord, passCode);

 }

  public static void optionsMenu(String userName, String passWord, int passCode) {

    Scanner sc = new Scanner(System.in);
    String optionStrr = "";
    int optionn = 0;
    final int maxOptionAttempts = 3;
    int optionAttempts = 0;

    while (optionAttempts < maxOptionAttempts) {

      try {

        System.out.println("1). Withdraw cash, 2). Deposit cash, 3). Transfer cash, 4). Check balance");
        System.out.println("Please choose options 1-4: ");
        optionStrr = sc.nextLine();
        optionAttempts++;

        if ((optionStrr == null || optionStrr.trim().isEmpty())) {
           if (optionAttempts == maxOptionAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
            System.out.println("You have " + (maxOptionAttempts - optionAttempts) + " attempts left!");
            System.out.println("Sorry, one of your inputs is empty which shouldn't be allowed!");
            continue;
         }

        optionn = Integer.parseInt(optionStrr);

        if (optionn < 1 || optionn > 4) {
          if (optionAttempts == maxOptionAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
          System.out.println("Sorry, option out of range!");
          continue;
        }

        switch (optionn) {

          case 1:
            withDraw(userName, cashAmount);
            break;

          case 2:
            deposit(userName, cashAmount);
            break;

          case 3:
            transfer(userName, usernames, cashAmount);
            break;

          case 4:
            balanceCheck(userName, cashAmount);
            break;
        }

      } catch (NumberFormatException e) {
        if (optionAttempts == maxOptionAttempts) {
           System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
           return;
         }
        System.out.println("You have " + (maxOptionAttempts - optionAttempts) + " attempts left!");
        System.out.println("Sorry, that's an invalid input!");
        continue;
      }
    }
  }

  public static void withDraw(String userName, ArrayList<Double> cashAmount) {

    Scanner sc = new Scanner(System.in);
    String withdrawStr = "";
    double withdraw = 0.00;
    final int maxWithdrawAttempts = 3;
    int withdrawAttempts = 0;

    while (withdrawAttempts < maxWithdrawAttempts) {

      try {

        System.out.println("Enter the cash amount you can withdraw. Maximum you can withdraw is £80.00: ");
        withdrawStr = sc.nextLine();
        withdrawAttempts++;

        if ((withdrawStr == null || withdrawStr.trim().isEmpty())) {
          if (withdrawAttempts == maxWithdrawAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("You have " + (maxWithdrawAttempts - withdrawAttempts) + " attempts left!");
          System.out.println("Sorry, your input is empty which isn't allowed!");
          continue;
        }

        withdraw = Double.parseDouble(withdrawStr);
        withdraw = Double.parseDouble(String.format("%.2f", withdraw));

        if (withdraw < 0.00 || withdraw > 80.00) {
          if (withdrawAttempts == maxWithdrawAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("You have " + (maxWithdrawAttempts - withdrawAttempts) + " attempts left!");
          System.out.println("Sorry, your withdraw input is either negative or higher than 80.00!");
          continue;
        }

        int userWithdrawIndex = usernames.indexOf(userName);
        if (cashAmount.get(userWithdrawIndex) < withdraw) {
          if (withdrawAttempts == maxWithdrawAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("You have " + (maxWithdrawAttempts - withdrawAttempts) + " attempts left!");
          System.out.println("Sorry, you don't have enough money to withdraw that amount!");
          continue;
        }

        cashAmount.set(userWithdrawIndex, cashAmount.get(userWithdrawIndex) - withdraw);
        System.out.println("£ " + withdraw + " has successfully been withdrawn from your account!");
        System.out.println("Current balance: " + cashAmount.get(userWithdrawIndex));

      } catch (NumberFormatException e) {
        if (withdrawAttempts == maxWithdrawAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }
        System.out.println("You have " + (maxWithdrawAttempts - withdrawAttempts) + " attempts left!");
        System.out.println("Sorry, invalid input!");
        continue;

      }
    }  
  }

  public static void deposit(String userName, ArrayList<Double> cashAmount) {

    Scanner sc = new Scanner(System.in);
    String depositStr = "";
    double deposit = 0;
    final int maxDepositAttempts = 3;
    int depositAttempts = 0;

    while (depositAttempts < maxDepositAttempts) {

      try {

        System.out.println("Enter the cash amount you want to deposit. Maximum cash you can deposit is £150.00: ");
        depositStr = sc.nextLine();
        depositAttempts++;

        if (depositStr == null || depositStr.trim().isEmpty()) {
          if (depositAttempts == maxDepositAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("You have " + (maxDepositAttempts - depositAttempts) + " attempts left!");
          System.out.println("Sorry, invalid input!");
          continue;
          }

        deposit = Double.parseDouble(depositStr);
        deposit = Double.parseDouble(String.format("%.2f", deposit));

        if (deposit < 0.00 || deposit > 150.00) {
          if (depositAttempts == maxDepositAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("You have " + (maxDepositAttempts - depositAttempts) + " attempts left!");
          System.out.println("Sorry, your input is out of range!");
          continue;
        }

        int userDepositIndex = usernames.indexOf(userName);
        cashAmount.set(userDepositIndex, cashAmount.get(userDepositIndex) + deposit);
        System.out.println("£ " + deposit + " has successfully been deposited to your account!");
        System.out.println("Current balance: " + cashAmount.get(userDepositIndex));


      } catch (NumberFormatException e) {
         if (depositAttempts == maxDepositAttempts) {
           System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
           return;
         }
         System.out.println("You have " + (maxDepositAttempts - depositAttempts) + " attempts left!");
         System.out.println("Sorry, invalid input!");
         continue;
      }
    }
   }

  public static void transfer(String userName, ArrayList<String> usernames, ArrayList<Double> cashAmount) {

    Scanner sc = new Scanner(System.in);
    final int maxTransferAttempts = 3;
    int transferAttempts = 0;
    String transferUser = "";
    String transferStr = "";
    double transfer = 0.00;

    while (transferAttempts < maxTransferAttempts) {

      try {

        System.out.println("Enter the username you want to transfer cash too: ");
        transferUser = sc.nextLine();
        transferAttempts++;

        if (transferUser == null || transferUser.trim().isEmpty()) {
          if (transferAttempts == maxTransferAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
           System.out.println("You have " + (maxTransferAttempts - transferAttempts) + " attempts left!");
           System.out.println("Sorry, empty input isn't allowed!");
           continue;
        }

        if (!usernames.contains(transferUser)) {
          if (transferAttempts == maxTransferAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
           System.out.println("You have " + (maxTransferAttempts - transferAttempts) + " attempts left!");
           System.out.println("Sorry, that username isn't available!");
           continue;
        }

        System.out.println("Enter the cash amount you want to transfer. Maximum cash you can transfer is £150.00: ");
        transferStr = sc.nextLine();

        if (transferStr == null || transferStr.trim().isEmpty()) {
          if (transferAttempts == maxTransferAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
           System.out.println("You have " + (maxTransferAttempts - transferAttempts) + " attempts left!");
           System.out.println("Sorry, empty input is not allowed!");
           continue;
        }

        transfer = Double.parseDouble(transferStr);
        transfer = Double.parseDouble(String.format("%.2f", transfer));

        if (transfer < 0.00 || transfer > 150.00) {
          if (transferAttempts == maxTransferAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
           System.out.println("You have " + (maxTransferAttempts - transferAttempts) + " attempts left!");
           System.out.println("Sorry, that input is out of range!");
           continue;
        }

        int giveUserIndex = usernames.indexOf(userName);

        if (cashAmount.get(giveUserIndex) < transfer) {
          if (transferAttempts == maxTransferAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
           System.out.println("You have " + (maxTransferAttempts - transferAttempts) + " attempts left!");
           System.out.println("Sorry, you don't have enough money to transfer that amount!");
           continue;
        }

        int takeUserIndex = usernames.indexOf(transferUser);
        cashAmount.set(giveUserIndex, cashAmount.get(giveUserIndex) - transfer);
        cashAmount.set(takeUserIndex, cashAmount.get(takeUserIndex) + transfer);

        System.out.println("£ " + transfer + "has successfully been transferred from " + userName + "'s account to " + transferUser + " 's account");
        System.out.println("Current balance: £ " + cashAmount.get(giveUserIndex));
        System.out.println("Current balance: £ " + cashAmount.get(takeUserIndex));


      } catch (NumberFormatException e) {
        if (transferAttempts == maxTransferAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
           System.out.println("You have " + (maxTransferAttempts - transferAttempts) + " attempts left!");
           System.out.println("Sorry, invalid input!");
           continue;
        }
      }
    }

  public static void balanceCheck(String userName, ArrayList<Double> cashAmount) {

    int userNameIndex = usernames.indexOf(userName);
    System.out.println("Current balance: £ " + cashAmount.get(userNameIndex));
  }
 }
