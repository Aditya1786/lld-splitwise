package com.aditya.balanceSheet;

import com.aditya.group.Group;
import com.aditya.split.Split;
import com.aditya.user.User;
import java.util.List;

public class BalanceSheetController {

  public void updateUserExpenseBalanceSheet(
      User expensePaidBy, List<Split> splitDetails, double totExpenseAmount) {
    UserExpenseBalanceSheet paidByUserExpenseBalanceSheet =
        expensePaidBy.getUserExpenseBalanceSheet();
    paidByUserExpenseBalanceSheet.addPayment(totExpenseAmount);
    for (Split split : splitDetails) {
      User oweFromUser = split.getUser();
      double oweAmount = split.getAmount();
      UserExpenseBalanceSheet oweFromUserExpenseBalanceSheet =
          oweFromUser.getUserExpenseBalanceSheet();

      // self expense
      if (expensePaidBy.getUserId().equals(oweFromUser.getUserId())) {
        paidByUserExpenseBalanceSheet.addExpense(oweAmount);
      } else {
        paidByUserExpenseBalanceSheet.addToReceive(oweAmount);
        Balance userOweBalance;

        // paid by user balance sheet update
        if (paidByUserExpenseBalanceSheet
            .getUserBalanceMap()
            .containsKey(oweFromUser.getUserId())) {
          userOweBalance =
              paidByUserExpenseBalanceSheet.getUserBalanceMap().get(oweFromUser.getUserId());
        } else {
          userOweBalance = new Balance();
          paidByUserExpenseBalanceSheet
              .getUserBalanceMap()
              .put(oweFromUser.getUserId(), userOweBalance);
        }

        userOweBalance.addAmountToReceive(oweAmount);

        // owe user balance sheet update
        oweFromUserExpenseBalanceSheet.addOwed(oweAmount);
        oweFromUserExpenseBalanceSheet.addExpense(oweAmount);

        Balance userPaidBalance;
        if (oweFromUserExpenseBalanceSheet
            .getUserBalanceMap()
            .containsKey(expensePaidBy.getUserId())) {
          userPaidBalance =
              oweFromUserExpenseBalanceSheet.getUserBalanceMap().get(expensePaidBy.getUserId());
        } else {
          userPaidBalance = new Balance();
          oweFromUserExpenseBalanceSheet
              .getUserBalanceMap()
              .put(expensePaidBy.getUserId(), userPaidBalance);
        }

        userPaidBalance.addAmountOwed(oweAmount);
      }
    }
  }

  public void showBalanceSheetOfUser(User user) {
    UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet();
    System.out.println("Balance Sheet for User: " + user.getName());
    System.out.println("Total Expense: " + userExpenseBalanceSheet.getTotalExpense());
    System.out.println("Total Payment: " + userExpenseBalanceSheet.getTotalPayment());
    System.out.println("Total Owed: " + userExpenseBalanceSheet.getTotalOwed());
    System.out.println("Total To Receive: " + userExpenseBalanceSheet.getTotalToReceive());
    System.out.println("Detailed Balances:");
    for (String otherUserId : userExpenseBalanceSheet.getUserBalanceMap().keySet()) {
      Balance balance = userExpenseBalanceSheet.getUserBalanceMap().get(otherUserId);
      System.out.println(
          "User ID: "
              + otherUserId
              + ", Amount Owed: "
              + balance.getAmountOwed()
              + ", Amount To Receive: "
              + balance.getAmountToReceive());
    }
  }

  public void showGroupBalanceSheet(Group group) {
    System.out.println("Balance Sheet for Group: " + group.getGroupName());
    for (User member : group.getMembers()) {
      showBalanceSheetOfUser(member);
      System.out.println("-----");
    }
  }
}
