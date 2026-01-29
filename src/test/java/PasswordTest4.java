import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class PasswordTest4 {

  public static void main(String[] args) {

    Password register = new Password("XYZ", 34444444, "boy", "0345643445455545435334345353353w", "Xytre@.com","ABCDE", "ABCDEFG1234666666", 888888888);
    System.out.println(register.getUserName());
    System.out.println(register.getAge());
    System.out.println(register.getGender());
    System.out.println(register.getPhoneNumber());
    System.out.println(register.getEmailAddress());
    System.out.println(register.getPassword());
    System.out.println(register.getConfirmPassword());
    System.out.println(register.getPassCode());
  }
}
