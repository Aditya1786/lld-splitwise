package com.aditya.group;

import com.aditya.expense.ExpenseController;
import com.aditya.split.Split;
import com.aditya.split.SplitType;
import com.aditya.user.User;
import java.util.ArrayList;
import java.util.List;

public class GroupController {
  List<Group> groupList;

  public GroupController() {
    this.groupList = new ArrayList<>();
  }

  public Group createAndAddGroup(String groupName) {
    Group group = new Group(groupName);
    groupList.add(group);
    return group;
  }

  public void addMemberToGroup(String groupId, User user) {
    Group group = getGroup(groupId);
    if (group != null) {
      group.getMembers().add(user);
    } else {
      throw new IllegalArgumentException("Group not found");
    }
  }

  void addGroup(Group group) {
    groupList.add(group);
  }

  public Group getGroup(String groupId) {
    for (Group group : groupList) {
      if (group.getGroupId().equals(groupId)) {
        return group;
      }
    }
    return null;
  }

  public List<Group> getAllGroups() {
    return groupList;
  }

  public void createGroupExpense(
      String groupId,
      User paidBy,
      double amount,
      String description,
      SplitType splitType,
      List<Split> splitDetails) {
    Group group = getGroup(groupId);
    if (group != null) {
      ExpenseController expenseController = group.getExpenseController();
      expenseController.addExpense(amount, paidBy, description, splitType, splitDetails);
    }
  }
}
