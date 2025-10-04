package com.aditya.group;

import com.aditya.expense.Expense;
import com.aditya.expense.ExpenseController;
import com.aditya.user.User;
import java.util.List;

public class Group {
  private final String groupId;
  private final String groupName;
  private final List<User> members;
  private final List<Expense> expenseList;
  private final ExpenseController expenseController;

  public Group(String groupName) {
    this.groupId = "group_" + (int) (Math.random() * 10000);
    this.groupName = groupName;
    this.members = new java.util.ArrayList<>();
    this.expenseList = new java.util.ArrayList<>();
    this.expenseController = new ExpenseController();
  }

  public String getGroupId() {
    return groupId;
  }

  public String getGroupName() {
    return groupName;
  }

  public List<User> getMembers() {
    return members;
  }

  public List<Expense> getExpenseList() {
    return expenseList;
  }

  public ExpenseController getExpenseController() {
    return expenseController;
  }
}
