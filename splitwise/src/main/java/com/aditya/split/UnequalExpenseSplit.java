package com.aditya.split;

import java.util.List;

public class UnequalExpenseSplit implements ExpenseSplit {

    @Override
    public void validateSplit(double totalAmount, List<Split> splits) {
        double totalSplitAmount = 0;
        for (Split split : splits) {
            totalSplitAmount += split.getAmount();
        }
        if (totalSplitAmount != totalAmount) {
            throw new IllegalArgumentException("Total split amount must equal total expense amount");
        }
    }

    @Override
    public void createSplits(double totalAmount, List<Split> splits) {
        // No additional processing needed for unequal splits
    }
}
