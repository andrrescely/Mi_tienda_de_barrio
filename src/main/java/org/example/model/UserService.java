package org.example.model;

import model.User;

public interface UserService {
    User create(User user);
    User read(Long userId);
    User update(Long userId, User updatedUser);
    void delete(Long userId);
}
