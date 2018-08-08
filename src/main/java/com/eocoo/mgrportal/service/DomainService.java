package com.eocoo.mgrportal.service;

import com.eocoo.mgrportal.domain.Domain;
import com.eocoo.mgrportal.domain.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomainService {

    @Autowired
    private DomainRepository domainRepository;

    public List<Domain> findAll() {
        return domainRepository.findAll();
    }

    public Domain findById(Long id) {
        Optional<Domain> op = domainRepository.findById(id);
        return op.get();
    }

    public void addDomain(Domain article) {
        domainRepository.save(article);
    }

    public void deleteDomain(Long id) {
        domainRepository.deleteById(id);
    }

    public void modDomain(Domain article) {
        domainRepository.save(article);
    }
}
