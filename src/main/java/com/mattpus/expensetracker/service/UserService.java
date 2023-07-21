package com.mattpus.expensetracker.service;

import com.mattpus.expensetracker.model.User;
import com.mattpus.expensetracker.model.UserModel;

public interface UserService {
    User createUser(UserModel user);
}
