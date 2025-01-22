package com.ADJT.fase1.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.ADJT.fase1.demo.entity.model.User;
import com.ADJT.fase1.demo.exception.CJNotFoundException;
import com.ADJT.fase1.demo.repository.UserRepository;
import com.ADJT.fase1.demo.util.CustomCodeException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements com.ADJT.fase1.demo.service.UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User getByName(String name) {
        Assert.notNull(name, "name cannot be null");
        return userRepository.findByName(name).orElseThrow(
                () -> new CJNotFoundException(CustomCodeException.CODE_400, "user not found with name "+name));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        Assert.notNull(user, "user cannot be null");
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(User user, Long id) {

        Assert.notNull(id, "id cannot be null");
        Assert.notNull(user, "user cannot be null");

        User userDb = userRepository.findById(id)
                .orElseThrow(() -> new CJNotFoundException(CustomCodeException.CODE_400, "user not found"));

        userDb.setUsername(user.getUsername());
        userDb.setName(user.getName());
        userDb.setLastname(user.getLastname());
        userDb.setPassword(user.getPassword());
        userDb.setEmail(user.getEmail());
        userDb.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(userDb);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Assert.notNull(id, "id cannot be null");
        User userDb = userRepository.findById(id)
                .orElseThrow(() -> new CJNotFoundException(CustomCodeException.CODE_400, "user not found"));
        userRepository.delete(userDb);
    }

    public Boolean validateLogin(String login, String password) {
        User user = userRepository.findByUsername(login);
        return user != null && user.getPassword().equals(password);
    }

}