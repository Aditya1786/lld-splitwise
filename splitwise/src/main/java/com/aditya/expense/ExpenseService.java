package com.aditya.expense;

import com.aditya.balanceSheet.BalanceSheetController;
import com.aditya.split.ExpenseSplit;
import com.aditya.split.Split;
import com.aditya.split.SplitFactory;
import com.aditya.split.SplitType;
import com.aditya.user.User;
import java.util.List;

public class ExpenseService {
  private final BalanceSheetController balanceSheetController;

  public ExpenseService() {
    this.balanceSheetController = new BalanceSheetController();
  }

  public Expense createExpense(
      double amount,
      User paidBy,
      String description,
      SplitType splitType,
      List<Split> splitDetails) {

    ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
    expenseSplit.validateSplit(amount, splitDetails);
    expenseSplit.createSplits(amount, splitDetails);

    balanceSheetController.updateUserExpenseBalanceSheet(paidBy, splitDetails, amount);
    return new Expense(amount, paidBy, description, splitType, splitDetails);
  }
}
