package com.aditya;

import com.aditya.balanceSheet.BalanceSheetController;
import com.aditya.group.Group;
import com.aditya.group.GroupController;
import com.aditya.split.Split;
import com.aditya.split.SplitType;
import com.aditya.user.User;
import com.aditya.user.UserController;
import java.util.ArrayList;
import java.util.List;

public class Splitwise {
  UserController userController;
  GroupController groupController;

  BalanceSheetController balanceSheetController;

  public Splitwise() {
    this.userController = new UserController();
    this.groupController = new GroupController();
    this.balanceSheetController = new BalanceSheetController();
  }

  public void demo() {
    setupDemoUsersAndGroups();

    // Add members to group
    Group group = groupController.getAllGroups().get(0);
    groupController.addMemberToGroup(group.getGroupId(), userController.getAllUsers().get(1));
    groupController.addMemberToGroup(group.getGroupId(), userController.getAllUsers().get(2));

    // Create expenses inside group
    List<Split> splitDetails = new ArrayList<>();
    Split split1 = new Split(userController.getAllUsers().get(0), 3000);
    Split split2 = new Split(userController.getAllUsers().get(1), 1500);
    Split split3 = new Split(userController.getAllUsers().get(2), 1500);
    splitDetails.add(split1);
    splitDetails.add(split2);
    splitDetails.add(split3);
    groupController.createGroupExpense(
        group.getGroupId(),
        split1.getUser(),
        6000,
        "Hotel Booking",
        SplitType.Unequal,
        splitDetails);

    for (User user : userController.getAllUsers()) {
      balanceSheetController.showBalanceSheetOfUser(user);
    }

    // Group 2 expense
    Group group2 = groupController.getAllGroups().get(1);
    groupController.addMemberToGroup(group2.getGroupId(), userController.getAllUsers().get(0));
    groupController.addMemberToGroup(group2.getGroupId(), userController.getAllUsers().get(2));
    groupController.addMemberToGroup(group2.getGroupId(), userController.getAllUsers().get(1));

    List<Split> splitDetails2 = new ArrayList<>();
    Split split4 = new Split(userController.getAllUsers().get(3), "20%");
    Split split5 = new Split(userController.getAllUsers().get(0), "30%");
    Split split6 = new Split(userController.getAllUsers().get(1), "25%");
    Split split7 = new Split(userController.getAllUsers().get(2), "25%");
    splitDetails2.add(split4);
    splitDetails2.add(split5);
    splitDetails2.add(split6);
    splitDetails2.add(split7);
    groupController.createGroupExpense(
        group2.getGroupId(),
        split4.getUser(),
        8000,
        "Ski Equipment",
        SplitType.Percentage,
        splitDetails2);

    balanceSheetController.showGroupBalanceSheet(group2);
  }

  public void setupDemoUsersAndGroups() {

    // Adding Users
    addUsersToSplitwiseApp();

    // Adding Groups and adding users to groups
    User user1 = userController.getAllUsers().get(0);
    Group group = groupController.createAndAddGroup("Trip to Goa");
    groupController.addMemberToGroup(group.getGroupId(), user1);

    // Group 2
    User user2 = userController.getAllUsers().get(3);
    Group group2 = groupController.createAndAddGroup("Trip to Manali");
    groupController.addMemberToGroup(group2.getGroupId(), user2);
  }

  public void addUsersToSplitwiseApp() {
    User user1 = new User("Aditya");
    User user2 = new User("Rohan");
    User user3 = new User("Sakshi");
    User user4 = new User("Ankita");

    userController.addUser(user1);
    userController.addUser(user2);
    userController.addUser(user3);
    userController.addUser(user4);
  }
}
