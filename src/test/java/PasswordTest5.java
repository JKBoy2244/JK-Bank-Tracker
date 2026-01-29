import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class PasswordTest5 {

  @Test
  void constructor_sets_all_fields_correctly() {

    Password register = new Password("XYZ1245SDER44", 260998, "", "03456434454", "Xytre@hotmail.com","ABCDEFG12345555534WXXXXXXXXXXXXXEEWSDDEWD", "ABC", 0);
    assertEquals("XYZ1245SDER44", register.getUserName());
    assertEquals(260998, register.getAge());
    assertEquals("", register.getGender());
    assertEquals("03456434454", register.getPhoneNumber());
    assertEquals("Xytre@hotmail.com", register.getEmailAddress());
    assertEquals("ABCDEFG12345555534WXXXXXXXXXXXXXEEWSDDEWD", register.getPassword());
    assertEquals("ABC", register.getConfirmPassword());
    assertEquals(0, register.getPassCode());
  }
}
