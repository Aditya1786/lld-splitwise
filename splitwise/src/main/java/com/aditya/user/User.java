package com.aditya.user;

import com.aditya.balanceSheet.UserExpenseBalanceSheet;

public class User {
  private final String userId;
  private final String name;
  private final UserExpenseBalanceSheet userExpenseBalanceSheet;

  public User(String name) {
    this.userId = "user_" + (int) (Math.random() * 10000);
    this.name = name;
    this.userExpenseBalanceSheet = new UserExpenseBalanceSheet();
  }

  public String getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
    return userExpenseBalanceSheet;
  }
}
