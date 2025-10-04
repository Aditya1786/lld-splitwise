package com.aditya.balanceSheet;

public class Balance {

  double amountOwed;
  double amountToReceive;

  public Balance() {
    this.amountOwed = 0;
    this.amountToReceive = 0;
  }

  public double getAmountOwed() {
    return amountOwed;
  }

  public double getAmountToReceive() {
    return amountToReceive;
  }

  public void addAmountOwed(double amount) {
    this.amountOwed += amount;
  }

  public void addAmountToReceive(double amount) {
    this.amountToReceive += amount;
  }

  public void setAmountOwed(double amountOwed) {
    this.amountOwed = amountOwed;
  }

  public void setAmountToReceive(double amountToReceive) {
    this.amountToReceive = amountToReceive;
  }
}
