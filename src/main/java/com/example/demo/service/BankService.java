package com.example.demo.service;

import com.example.demo.model.Bank;
import com.example.demo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private EntityManager entityManager;


    @Transactional
    public void update(int bankId){
        Bank bank = bankRepository.getOne(bankId);
        entityManager.detach(bank);
        bank.setName("new name");
        bank.getBranches().get(0).setAddress("new Address");
    }
}
