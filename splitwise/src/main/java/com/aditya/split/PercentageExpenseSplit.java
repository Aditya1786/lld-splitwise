package com.aditya.split;

import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplit {

  public void validateSplit(double totalAmount, List<Split> splits) {
    double totalPercentage = 0;
    for (Split split : splits) {
      totalPercentage += split.getPercent();
    }
    if (totalPercentage != 100) {
      throw new IllegalArgumentException("Total percentage must be 100");
    }
  }

  public void createSplits(double totalAmount, List<Split> splits) {
    for (Split split : splits) {
      double splitAmount = (split.getPercent() / 100) * totalAmount;
      split.setAmount(splitAmount);
    }
  }
}
