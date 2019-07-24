package techcourse.myblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techcourse.myblog.domain.User;
import techcourse.myblog.persistence.UserRepository;

import java.util.List;

@Service
public class UserService {
    private static final int USER_NOT_EXIST = 0;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isDuplicatedEmail(String email) {
        // existByEmail
        userRepository.existsByEmail(email);
        return userRepository.findUsersByEmail(email).size() != USER_NOT_EXIST;
    }

    // Service가 transaction을 관리하는 게
    public User updateName(long id, String name) {
        User user = userRepository.findUserById(id);
        user.setName(name);
        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    public User findUserById(long id) {
        return userRepository.findUserById(id);
    }

}
