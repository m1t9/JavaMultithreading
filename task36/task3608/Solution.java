package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.FakeModel;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
//        Model model = new FakeModel();
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);

        usersView.fireEventShowAllUsers();

        EditUserView editUserView = new EditUserView();
        controller.setEditUserView(editUserView);
        editUserView.setController(controller);
        usersView.fireEventOpenUserEditForm(126L);

        editUserView.fireEventUserDeleted(124L);

        editUserView.fireEventUserChanged("Sidorov", 126, 8);

        usersView.fireEventShowDeletedUsers();
    }
}