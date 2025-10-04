package com.aditya.expense;

import com.aditya.split.Split;
import com.aditya.split.SplitType;
import com.aditya.user.User;
import java.util.List;

public class ExpenseController {
  private final ExpenseService expenseService;

  public ExpenseController() {
    this.expenseService = new ExpenseService();
  }

  public Expense addExpense(
      double amount,
      User paidBy,
      String description,
      SplitType splitType,
      List<Split> splitDetails) {
    return expenseService.createExpense(amount, paidBy, description, splitType, splitDetails);
  }
}
