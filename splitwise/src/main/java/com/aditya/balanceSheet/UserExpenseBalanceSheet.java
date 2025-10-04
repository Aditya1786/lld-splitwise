package com.aditya.balanceSheet;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
  private final Map<String, Balance> userBalanceMap;
  private double totalExpense;
  private double totalPayment;
  private double totalOwed;
  private double totalToReceive;

  public UserExpenseBalanceSheet() {
    userBalanceMap = new HashMap<>();
    totalExpense = 0;
    totalOwed = 0;
    totalToReceive = 0;
  }

  public Map<String, Balance> getUserBalanceMap() {
    return userBalanceMap;
  }

  public double getTotalExpense() {
    return totalExpense;
  }

  public double getTotalPayment() {
    return totalPayment;
  }

  public double getTotalOwed() {
    return totalOwed;
  }

  public double getTotalToReceive() {
    return totalToReceive;
  }

  public void addExpense(double amount) {
    totalExpense += amount;
  }

  public void addPayment(double amount) {
    totalPayment += amount;
  }

  public void addOwed(double amount) {
    totalOwed += amount;
  }

  public void addToReceive(double amount) {
    totalToReceive += amount;
  }

  public void setUserBalanceMap(Map<String, Balance> userBalanceMap) {
    this.userBalanceMap.clear();
    this.userBalanceMap.putAll(userBalanceMap);
  }

  public void setTotalExpense(double totalExpense) {
    this.totalExpense = totalExpense;
  }

  public void setTotalPayment(double totalPayment) {
    this.totalPayment = totalPayment;
  }

  public void setTotalOwed(double totalOwed) {
    this.totalOwed = totalOwed;
  }

  public void setTotalToReceive(double totalToReceive) {
    this.totalToReceive = totalToReceive;
  }
}
