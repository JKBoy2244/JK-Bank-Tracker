import javax.swing.JOptionPane;


interface UserInterface {
  public void firstName();
  public void lastName();
  public void emailAddress();
  public void phoneNumber();
}

interface ConfirmInterface {
  public void confirm(UserDetails User);
}

abstract class UserDetails implements UserInterface {

  protected String firstName;
  protected String lastName;
  protected String emailAddress;
  protected String phoneNumber;

  public UserDetails(String firstName, String lastName, String emailAddress, String phoneNumber) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
    this.phoneNumber = phoneNumber;

  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setFirstName(String firstName) {

    if (firstName == null || firstName.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "First name cannot be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    if (firstName.length() < 3 || firstName.length() > 13) {
      JOptionPane.showMessageDialog(null, "First name isn't 3 to 13 characters long!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
    this.firstName = firstName.trim();
  }

  public void setLastName(String lastName) {

    if (lastName == null || lastName.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Last name cannot be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    if (lastName.length() < 3 || lastName.length() > 13) {
      JOptionPane.showMessageDialog(null, "Last name isn't 3 to 13 characters long!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
    this.lastName = lastName.trim();
  }

  public void setEmailAddress(String emailAddress) {

     if (emailAddress == null || emailAddress.trim().isEmpty()) {
       JOptionPane.showMessageDialog(null, "Email address cannot be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
     }

     if (!emailAddress.endsWith("@yahoo.com") && !emailAddress.endsWith("@gmail.com") && !emailAddress.endsWith("@hotmail.com")) {
       JOptionPane.showMessageDialog(null, "Email address doesn't end with @yahoo.com, @gmail.com, or @hotmail.com!", "Input Error", JOptionPane.ERROR_MESSAGE);
     }

    if (emailAddress.length() < 17 || emailAddress.length() > 25) {
      JOptionPane.showMessageDialog(null, "Email address isn't 17 to 25 characters long!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    int Position = emailAddress.indexOf('@');

     if (Position <= 0) {
        JOptionPane.showMessageDialog(null, "Email address must contain a username before the @ symbol!", "Input Error", JOptionPane.ERROR_MESSAGE);
      }

       String localPart = emailAddress.substring(0, Position);

       for (int i = 0; i < localPart.length(); i++) {
         char c = localPart.charAt(i);
         if (!Character.isLetterOrDigit(c) && c != '.' && c != '_' && c != '-') {
           JOptionPane.showMessageDialog(null, "Email address is in the incorrect format unfortunately!", "Input Error", JOptionPane.ERROR_MESSAGE);
         }
       }

    this.emailAddress = emailAddress.trim();
  }

  public void setPhoneNumber(String phoneNumber) {

    if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
       JOptionPane.showMessageDialog(null, "Phone number cannot be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
     }

    if (phoneNumber.length() != 11) {
      JOptionPane.showMessageDialog(null, "Phone number isn't 11 digits long!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    for (int i = 0; i < phoneNumber.length(); i++) {
      if (!Character.isDigit(phoneNumber.charAt(i)) || phoneNumber.charAt(0) != '0') {
        JOptionPane.showMessageDialog(null, "Phone number isn't in valid format!", "Input Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    this.phoneNumber = phoneNumber.trim();
  }

  public void firstName() {

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

     try {

      JOptionPane.showMessageDialog(null, "Enter your first name between 3 and 13 characters: ");
      firstName = JOptionPane.showInputDialog(null, "Enter your first name between 3 and 13 characters: ");
      attempts++;

      if (firstName == null || firstName.trim().isEmpty()) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid first name. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
        continue;

      }

      if (firstName.length() < 3 || firstName.length() > 13) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid first name. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "Sorry, your first name's length isn't between 3 and 13 characters. Please try again: ");
        continue;
      }

      setFirstName(firstName);
      break;
     } catch (Exception e) {
       if (attempts == maxAttempts) {
         JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid first name. Try again later: ");
         return;
       }
       JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
       attempts++;
     }
    }
  } 

  public void lastName() {

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

      try {

      JOptionPane.showMessageDialog(null, "Enter your last name between 3 and 13 characters: ");
      lastName = JOptionPane.showInputDialog(null, "Enter your last name between 3 and 13 characters: ");
      attempts++;

      if (lastName == null || lastName.trim().isEmpty()) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid last name. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
        continue;

      }

      if (lastName.length() < 3 || lastName.length() > 13) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid last name. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "Sorry, your last name's length isn't between 3 and 13 characters. Please try again: ");
        continue;
      }

      setLastName(lastName);
      break;
    } catch (Exception e) {
         if (attempts == maxAttempts) {
           JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid last name. Try again later: ");
           return;
         }
         JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
         attempts++;
       }
     }
  }

  public void emailAddress() {

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

     try {
       
      JOptionPane.showMessageDialog(null, "Enter your email address in either @yahoo.com, @gmail.com or @hotmail.com. We don't accept any other forms of email address: ");
      emailAddress = JOptionPane.showInputDialog(null, "Enter your email address in either @yahoo.com, @gmail.com or @hotmail.com. We don't accept any other forms of email address: ");
      attempts++;

      if (emailAddress == null || emailAddress.trim().isEmpty()) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid email address. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
        continue;
      }

      if (!emailAddress.endsWith("@yahoo.com") && !emailAddress.endsWith("@gmail.com") && !emailAddress.endsWith("@hotmail.com")) {
        if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid email address. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "Sorry, that's the wrong format. Please try again: ");
          continue;
        }

     if (emailAddress.length() < 17 || emailAddress.length() > 25) {
       if (attempts == maxAttempts) {
           JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid email address between 17 and 25 characters long. Try again later: ");
           return;
         }
         JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
         JOptionPane.showMessageDialog(null, "Sorry, that's the wrong format. Please try again: ");
         continue;
       }

      int Position = emailAddress.indexOf('@');
       if (Position > 0) {
           String localPart = emailAddress.substring(0, Position);
           boolean containsInvalidChar = false;

           for (int i = 0; i < localPart.length(); i++) {
               char c = localPart.charAt(i);
               if (!Character.isLetterOrDigit(c) && c != '.' && c != '_' && c != '-') {
                   containsInvalidChar = true;
                   break;
               }
           }

           if (containsInvalidChar) {
               if (attempts == maxAttempts) {
                 JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid email address between 17 and 25 characters long. Try again later: ");
                   return;
               }
               JOptionPane.showMessageDialog(null, "You have " + attempts + " chances left to enter a valid email address!");
               JOptionPane.showMessageDialog(null, "Sorry, email address can only contain letters, numbers, dots, underscores, or hyphens before the @ symbol. Please enter a valid email address:");
               emailAddress = JOptionPane.showInputDialog(null, "Enter your email address: ");
               continue;
           }
       }

      setEmailAddress(emailAddress);
      break;
     } catch (Exception e) {
         if (attempts == maxAttempts) {
           JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid email address. Try again later: ");
           return;
         }
         JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
         attempts++;
       }
     }
  }

  public void phoneNumber() {

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

     try {
       
      JOptionPane.showMessageDialog(null, "Enter your phone number (11 digits long starting with 0): ");
      phoneNumber = JOptionPane.showInputDialog(null, "Enter your phone number (11 digits long starting with 0): ");
      attempts++;

      if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid phone number. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
        continue;
      }

      if (phoneNumber.length() != 11) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid phone number. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "Sorry, this phone number is not 11 digits long. Please try again: ");
        continue;
      }

      for (int i = 0; i < phoneNumber.length(); i++) {
        if (!Character.isDigit(phoneNumber.charAt(i)) || phoneNumber.charAt(0) != '0') {
          if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid phone number. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "Sorry, this phone number either doesn't start with 0 or has strings inside it which isnt valid. Please try again: ");
          continue;
        }
      }

       setPhoneNumber(phoneNumber);
       break;
      } catch (Exception e) {
         if (attempts == maxAttempts) {
           JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid phone number. Try again later: ");
           return;
         }
         JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
         attempts++;
       }
     } 
    }

  abstract public void Food();
  abstract public void Drink();
  abstract public void Dessert();
  abstract public void Cost(double foodCost, double drinkCost, double dessertCost);

}

class OrderMeal extends UserDetails implements UserInterface {

  private String food;
  private String drink;
  private String dessert;
  private double cost;

  public OrderMeal(String firstName, String lastName, String emailAddress, String phoneNumber, String food, String drink, String dessert, double cost) {

    super(firstName, lastName, emailAddress, phoneNumber);
    this.food = food;
    this.drink = drink;
    this.dessert = dessert;
    this.cost = cost;

  }

  public String getFood() {
    return food;
  }

  public String getDrink() {
    return drink;
  }

  public String getDessert() {
    return dessert;
  }

  public double getCost() {
    return cost;
  }

  public void setFood(String food) {

    if (food == null || food.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Food can't be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    String[] foodOptions = {"4 PC. Wings and Chips", "3 PC. Wings and Chips", "2 PC. Wings and Chips", "Cheese Burger and Chips","Beef Burger and Chips", "4 Nuggets and Chips", "6 Nuggets and Chips", "4 Nuggets and cheese burger", "4 Nuggets and beef burger", "1 PC. Chicken and Chips", "foodVoid"};
    boolean validFoodOption = false;
    for (int i = 0; i < foodOptions.length; i++) {
      if (food.equalsIgnoreCase(foodOptions[i])) {
        validFoodOption = true;
        break;
      }
    }

    if (!validFoodOption) {
      JOptionPane.showMessageDialog(null, "Invalid food option selected!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    this.food = food.trim();
  }

  public void setDrink(String drink) {

    if (drink == null || drink.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Drink can't be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    String[] drinkOptions = {"Water", "Coke", "Sprites", "Fanta", "Lemonade", "Orange Juice", "drinkVoid"};

    boolean validDrinkOption = false;
    for (int i = 0; i < drinkOptions.length; i++) {
      if (drink.equalsIgnoreCase(drinkOptions[i])) {
        validDrinkOption = true;
        break;
      }
    }

    if (!validDrinkOption) {
      JOptionPane.showMessageDialog(null, "Invalid drink option selected!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    this.drink = drink.trim();
  }

  public void setDessert(String dessert) {

    if (dessert == null || dessert.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Dessert can't be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    String[] dessertOptions = {"Vanilla Ice Cream", "Chocolate Ice Cream", "Strawberry Ice Cream", "Chocolate Cake", "Vanilla Cake", "dessertVoid"};

    boolean validDessertOption = false;
    for (int i = 0; i < dessertOptions.length; i++) {
      if (dessert.equalsIgnoreCase(dessertOptions[i])) {
        validDessertOption = true;
        break;
      }
    }

    if (!validDessertOption) {
      JOptionPane.showMessageDialog(null, "Invalid drink option selected!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    this.dessert = dessert.trim();
  }

  public void setCost(double cost) {

    if (cost < 0) {
      JOptionPane.showMessageDialog(null, "Cost can't be negative!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    this.cost = cost;
  }

  @Override
  public void Food() {

    String[] foodOptions = {"4 PC. Wings and Chips", "3 PC. Wings and Chips", "2 PC. Wings and Chips", "Cheese Burger and Chips","Beef Burger and Chips", "4 Nuggets and Chips", "6 Nuggets and Chips", "4 Nuggets and cheese burger", "4 Nuggets and beef burger", "1 PC. Chicken and Chips", "foodVoid"};
  double[] foodPrices = {6.10, 5.20, 4.30, 4.50, 4.10, 5.30, 6.70, 4.80, 5.10, 5.60, 0.00};

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

      try {

      JOptionPane.showMessageDialog(null, "Enter the food you want to order from the above array list or foodVoid if you don't want to order food: ");
      food = JOptionPane.showInputDialog(null, "Enter the food you want to order from the above array list or foodVoid if you don't want to order food: ");
      attempts++;

      if (food == null || food.trim().isEmpty()) {
        if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid food option. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
          continue;
        }

        boolean foodValid = false;
        for (int i = 0; i < foodOptions.length; i++) {
          if (food.equalsIgnoreCase(foodOptions[i])) {
            foodValid = true;
            break;
          }
        }

        if (!foodValid) {
          if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid food option. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
          continue;
        }

      double foodCost = 0.00;
      for (int i = 0; i < foodOptions.length; i++) {
         if (food.equalsIgnoreCase(foodOptions[i])) {
           foodCost = foodPrices[i];
           setFood(food);
           break;
         }
       }

         this.cost += foodCost;
         break;
        } catch (Exception e) {
           if (attempts == maxAttempts) {
             JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid food option. Try again later: ");
             return;
           }
           JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
           attempts++;
         }
       }
      }

  @Override
  public void Drink() {

    String[] drinkOptions = {"Water", "Coke", "Sprites", "Fanta", "Lemonade", "Orange Juice", "drinkVoid"};
    double[] drinkPrices = {1.10, 0.90, 0.85, 0.95, 1.25, 1.00, 0.00};

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

     try {

      JOptionPane.showMessageDialog(null, "Enter the drink you want to order from the above array list or drinkVoid if you don't want to order drink: ");
      drink = JOptionPane.showInputDialog(null, "Enter the drink you want to order from the above array list or drinkVoid if you don't want to order drink: ");
      attempts++;

      if (drink == null || drink.trim().isEmpty()) {
        if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid drink option. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
          continue;
        }

        boolean drinkValid = false;
        for (int i = 0; i < drinkOptions.length; i++) {
          if (drink.equalsIgnoreCase(drinkOptions[i])) {
            drinkValid = true;
            break;
          }
        }

        if (!drinkValid) {
          if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid drink option. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
          continue;
        }

        double drinkCost = 0.00;
        for (int i = 0; i < drinkOptions.length; i++) {
           if (drink.equalsIgnoreCase(drinkOptions[i])) {
             drinkCost = drinkPrices[i];
             setDrink(drink);
             break;
           }
         }

         this.cost += drinkCost;
         break;
        } catch (Exception e) {
         if (attempts == maxAttempts) {
           JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid drink option. Try again later: ");
           return;
         }
         JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
         attempts++;
       }
     }
   }


  @Override
  public void Dessert() {

    String[] dessertOptions = {"Vanilla Ice Cream", "Chocolate Ice Cream", "Strawberry Ice Cream", "Chocolate Cake", "Vanilla Cake", "dessertVoid"};
    double[] dessertPrices = {0.45, 0.55, 0.50, 0.80, 0.75, 0.00};

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

     try {
       
      JOptionPane.showMessageDialog(null, "Enter the dessert you want to order from the above array list or dessertVoid if you don't want to order food: ");
      dessert = JOptionPane.showInputDialog(null, "Enter the dessert you want to order from the above array list or dessertVoid if you don't want to order food: ");
      attempts++;

      if (dessert == null || dessert.trim().isEmpty()) {
        if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid dessert option. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
          continue;
        }

        boolean dessertValid = false;
        for (int i = 0; i < dessertOptions.length; i++) {
          if (dessert.equalsIgnoreCase(dessertOptions[i])) {
            dessertValid = true;
            break;
          }
        }

        if (!dessertValid) {
          if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid dessert option. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
          continue;
        }

         double dessertCost = 0.00;
         for (int i = 0; i < dessertOptions.length; i++) {
           if (dessert.equalsIgnoreCase(dessertOptions[i])) {
             dessertCost = dessertPrices[i];
             setDessert(dessert);
             break;
           }
         }

         this.cost += dessertCost;
         break;
        } catch (Exception e) {
         if (attempts == maxAttempts) {
           JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid dessert option. Try again later: ");
           return;
         }
         JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
         attempts++;
       }
     }
   }

 @Override
  public void Cost(double foodCost, double drinkCost, double dessertCost) {

    double cost = foodCost + drinkCost + dessertCost;
    setCost(cost);
    JOptionPane.showMessageDialog(null, "The total cost of your order is: £ " + this.cost);

  }
}

class Confirmation implements ConfirmInterface {
    @Override
    public void confirm(UserDetails User) {
        JOptionPane.showMessageDialog(null, "Thank you for ordering from our restaurant, " + User.getFirstName() + " " + User.getLastName() + ". Your order has been confirmed and it will be delivered to you shortly. Have a great day!");
    }
}

class Main {

  public static void main(String[] args) {

    OrderMeal order = new OrderMeal("", "", "", "", "", "", "", 0.0);
    order.firstName();
    order.lastName();
    order.emailAddress();
    order.phoneNumber();
    JOptionPane.showMessageDialog(null, "Wait for 3 seconds! ");

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      JOptionPane.showMessageDialog(null, "Thread sleep was interrupted: " + e.getMessage());
    } 

    order.Food();
    order.Drink();
    order.Dessert();
    order.Cost(0.0, 0.0, 0.0);
    JOptionPane.showMessageDialog(null, "Wait for 3 seconds! ");

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      JOptionPane.showMessageDialog(null, "Thread sleep was interrupted: " + e.getMessage());
    } 

    Confirmation confirm = new Confirmation();
    confirm.confirm(order);

  }
}