package com.aditya.expense;

import com.aditya.split.Split;
import com.aditya.split.SplitType;
import com.aditya.user.User;
import java.util.ArrayList;
import java.util.List;

public class Expense {
  private final String expenseId;
  private final String description;
  private final double amount;
  private final User paidBy;
  private final SplitType splitType;
  private final List<Split> splitDetails = new ArrayList<>();

  public Expense(
      double amount,
      User paidBy,
      String description,
      SplitType splitType,
      List<Split> splitDetails) {
    this.expenseId = "expense_" + (int) (Math.random() * 10000);
    this.amount = amount;
    this.description = description;
    this.splitType = splitType;
    this.paidBy = paidBy;
    this.splitDetails.addAll(splitDetails);
  }

  public String getExpenseId() {
    return expenseId;
  }

  public String getDescription() {
    return description;
  }

  public double getAmount() {
    return amount;
  }

  public User getPaidBy() {
    return paidBy;
  }

  public SplitType getSplitType() {
    return splitType;
  }

  public List<Split> getSplitDetails() {
    return splitDetails;
  }
}
