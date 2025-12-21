class InitialMoneyTransfer {

  private double money = 1000.00;

  public InitialMoneyTransfer(double money) {
    this.money = money;
  }

  public double getMoney() {
    return money;
  } 

  private ArrayList<Double> moneyAccount = new ArrayList<Double>();

  public void addMoney(double money) {
    moneyAccount.add(money);
  }

  public void moneyMessage(RegisterAccount register) {

    System.out.println("Congratulations " + register.getUserName() + "! You have successfully created your JK Bank Tracker Account where you can buy or save money whereever you want.");
    System.out.println("Currently, as you created your account, you have a starting amount of £" + money + " in your account!");
    System.out.println("Thank you so much for choosing us and we wish you a very good day!");
  }
}
