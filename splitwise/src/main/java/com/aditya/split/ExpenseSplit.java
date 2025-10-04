package com.aditya.split;

import java.util.List;

public interface ExpenseSplit {

  void validateSplit(double totalAmount, List<Split> splits);

  void createSplits(double totalAmount, List<Split> splits);
}
