import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class InitialMoneyTransferTest2 {

  public static void main(String[] args) {

    InitialMoneyTransfer money = new InitialMoneyTransfer(0.00);
    assertEquals(0.00, getMoney());
  }
}
