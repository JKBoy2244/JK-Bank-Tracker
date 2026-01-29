import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class PasswordTest2 {

  public static void main(String[] args) {

    Password register = new Password("", 26, "", "", "","", "", 0);
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
