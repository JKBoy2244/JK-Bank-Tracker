import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class PasswordTest5 {

  public static void main(String[] args) {

    Password register = new Password("XYZ1245SDER44", 260998, "", "03456434454", "Xytre@hotmail.com","ABCDEFG12345555534WXXXXXXXXXXXXXEEWSDDEWD", "ABC", 0);
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
