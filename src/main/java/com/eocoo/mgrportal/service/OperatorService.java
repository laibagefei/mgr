package com.eocoo.mgrportal.service;

import com.eocoo.mgrportal.domain.OperatorRepository;
import com.eocoo.mgrportal.service.vo.OperatorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    public boolean hasUser(OperatorVO op) {
        //operatorRepository.findOne();
        return true;
    }
}
