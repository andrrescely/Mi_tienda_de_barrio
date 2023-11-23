package org.example.model;

import model.User;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private Map<Long, User> userMap = new HashMap<>();
    private Long userIdCounter = 1L;

    @Override
    public User create(User user) {
        user.setId(generateUserId());
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User read(Long userId) {
        return userMap.get(userId);
    }

    @Override
    public User update(Long userId, User updatedUser) {
        if (userMap.containsKey(userId)) {
            updatedUser.setId(userId);
            userMap.put(userId, updatedUser);
            return updatedUser;
        }
        return null;
    }

    @Override
    public void delete(Long userId) {
        userMap.remove(userId);
    }

    private Long generateUserId() {
        return userIdCounter++;
    }
}



