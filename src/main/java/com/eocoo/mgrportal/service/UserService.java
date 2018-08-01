package com.eocoo.mgrportal.service;

import com.eocoo.mgrportal.service.vo.UserVO;
import com.eocoo.mgrportal.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean hasUser(UserVO user) {
        //userRepository.findOne();
        return true;
    }
}
