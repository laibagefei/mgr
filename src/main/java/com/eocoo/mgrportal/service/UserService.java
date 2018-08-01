package com.eocoo.mgrportal.service;

import com.eocoo.mgrportal.domain.User;
import com.eocoo.mgrportal.service.vo.UserVO;
import com.eocoo.mgrportal.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean hasUser(UserVO user) {
        //userRepository.findOne();
        return true;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> op = userRepository.findById(id);
        return op.get();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void modUser(User user) {
        userRepository.save(user);
    }
}
