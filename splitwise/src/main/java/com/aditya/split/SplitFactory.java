package com.aditya.split;

public class SplitFactory {
  public static ExpenseSplit getSplitObject(SplitType splitType) {
    switch (splitType) {
      case Equal -> {
        return new EqualExpenseSplit();
      }
      case Percentage -> {
        return new PercentageExpenseSplit();
      }
      case Unequal -> {
        return new UnequalExpenseSplit();
      }
      default -> {
        throw new IllegalArgumentException("Invalid Split Type");
      }
    }
  }
}
