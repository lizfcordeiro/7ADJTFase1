package com.ADJT.fase1.demo.service;

import java.util.List;

import com.ADJT.fase1.demo.entity.model.User;

public interface UserService {
    User getByName(final String name);
    List<User> getAll();
    User save(final User user);
    User update(final User user, final Long id);
    void deleteById(final Long id);
    Boolean validateLogin(final String login, final String password);
}

