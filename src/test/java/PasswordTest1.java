import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class PasswordTest1 {

  @Test
  void constructor_sets_all_fields_correctly() {

    Password register = new Password("XYZ1245SD", 26, "Female", "03456434454", "Xytre@hotmail.com","ABCDEFG1234", "ABCDEFG1234", 888888888);
    assertEquals("XYZ1245SD", register.getUserName());
    assertEquals(26, register.getAge());
    assertEquals("Female", register.getGender());
    assertEquals("03456434454", register.getPhoneNumber());
    assertEquals("Xytre@hotmail.com", register.getEmailAddress());
    assertEquals("ABCDEFG1234", register.getPassword());
    assertEquals("ABCDEFG1234", register.getConfirmPassword());
    assertEquals(888888888, register.getPassCode());
  }
}
