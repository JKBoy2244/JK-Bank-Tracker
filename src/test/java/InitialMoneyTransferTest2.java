import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class InitialMoneyTransferTest2 {

   @Test
   void constructor_sets_all_fields_correctly() {

    InitialMoneyTransfer money = new InitialMoneyTransfer(0.00);
    assertEquals(0.00, getMoney());
  }
}
