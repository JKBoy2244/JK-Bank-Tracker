import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class PasswordTest2 {

  @Test
  void constructor_sets_all_fields_correctly() {

    Password register = new Password("", 26, "", "", "","", "", 0);
    assertEquals("", register.getUserName());
    assertEquals(26, register.getAge());
    assertEquals("", register.getGender());
    assertEquals("", register.getPhoneNumber());
    assertEquals("", register.getEmailAddress());
    assertEquals("", register.getPassword());
    assertEquals("", register.getConfirmPassword());
    assertEquals(888888888, register.getPassCode());
  }
}
