import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class PasswordTest4 {

  @Test
  void constructor_sets_all_fields_correctly( {

    Password register = new Password("XYZ", 34444444, "boy", "0345643445455545435334345353353w", "Xytre@.com","ABCDE", "ABCDEFG1234666666", 888888888);
    assertEquals("XYZ", register.getUserName());
    assertEquals(34444444, register.getAge());
    assertEquals("boy", register.getGender());
    assertEquals("0345643445455545435334345353353w", register.getPhoneNumber());
    assertEquals("Xytre@.com", register.getEmailAddress());
    assertEquals("ABCDE", register.getPassword());
    assertEquals("ABCDEFG1234666666", register.getConfirmPassword());
    assertEquals(888888888, register.getPassCode());
  }
}
