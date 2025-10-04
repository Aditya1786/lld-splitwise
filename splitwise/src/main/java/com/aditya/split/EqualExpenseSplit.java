package com.aditya.split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {

  @Override
  public void validateSplit(double totalAmount, java.util.List<Split> splits) {
    double splitAmount = totalAmount / splits.size();
    for (Split split : splits) {
      if (split.getAmount() != splitAmount) {
        throw new IllegalArgumentException("Invalid Split Amount for Equal Expense Split");
      }
    }
  }

  @Override
  public void createSplits(double totalAmount, List<Split> splits) {
    double splitAmount = totalAmount / splits.size();
    for (Split split : splits) {
      split.setAmount(splitAmount);
    }
  }
}
