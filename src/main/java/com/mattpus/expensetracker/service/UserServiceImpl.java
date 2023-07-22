package com.mattpus.expensetracker.service;

import com.mattpus.expensetracker.exceptions.ItemAlreadyExistsException;
import com.mattpus.expensetracker.exceptions.ResourceNotFoundException;
import com.mattpus.expensetracker.model.User;
import com.mattpus.expensetracker.model.UserModel;
import com.mattpus.expensetracker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl  implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder bcryptEncoder;

    @Override
    public User createUser(UserModel user) {
        if (userRepository.existsByEmail((user.getEmail()))) {
            throw new ItemAlreadyExistsException("User is already registered with email: " + user.getEmail());
        }
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    @Override
    public User read() {
        Long userId = getLoggedInUser().getId();
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for the id: " + userId));
    }

    @Override
    public User update(UserModel user) {
        User existingUser = read();
        existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
        existingUser.setEmail(user.getEmail() != null? user.getEmail() : existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null ? bcryptEncoder.encode(user.getPassword()) : existingUser.getPassword());
        existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
        return userRepository.save(existingUser);
    }

    @Override
    public void delete() {
        User existsingUser = read();
        userRepository.delete(existsingUser);
    }

    @Override
    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found for the email: " + email));
    }
}
