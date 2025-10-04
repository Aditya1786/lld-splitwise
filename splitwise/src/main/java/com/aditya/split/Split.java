package com.aditya.split;

import com.aditya.user.User;

public class Split {

  private final User user;
  private double amount;
  private double percent;

  public Split(User user, double amount) {
    this.user = user;
    this.amount = amount;
  }

  public Split(User user, String percent) {
    this.user = user;
    this.percent =
        Double.parseDouble(
            percent.substring(0, percent.length() - 1)); // Remove the '%' sign and parse
  }

  public User getUser() {
    return user;
  }

  public double getAmount() {
    return amount;
  }

  public double getPercent() {
    return percent;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}
