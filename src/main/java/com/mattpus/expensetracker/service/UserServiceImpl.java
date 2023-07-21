package com.mattpus.expensetracker.service;

import com.mattpus.expensetracker.model.User;
import com.mattpus.expensetracker.model.UserModel;
import com.mattpus.expensetracker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl  implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(UserModel user) {
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        return userRepository.save(newUser);
    }
}
