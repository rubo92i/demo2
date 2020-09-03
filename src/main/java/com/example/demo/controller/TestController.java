package com.example.demo.controller;

import com.example.demo.config.SecurityContextProvider;
import com.example.demo.model.Bank;
import com.example.demo.model.Branch;
import com.example.demo.model.User;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private static UserRepository userRepository;


    @Autowired
    private SecurityContextProvider securityContextProvider;

    @Autowired
    private BankRepository bankRepository;

    @GetMapping
    public ResponseEntity test(OAuth2Authentication oAuth2Authentication4) {
        User user = securityContextProvider.getByAuthentication(oAuth2Authentication4);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/t2")
    public ResponseEntity test2(OAuth2Authentication oAuth2Authentication4) {
        return ResponseEntity.ok(oAuth2Authentication4);
    }


    @GetMapping("/save-bank")
    public ResponseEntity test() {
        Bank bank = new Bank();
        bank.setName("Evoca");

        Branch branch = new Branch();
        branch.setAddress("Tumanyan");

        Branch branch1 = new Branch();
        branch1.setAddress("Nalbandyan");
        List<Branch> branchList = new ArrayList<>();
        branchList.add(branch);
        branchList.add(branch1);

        bank.setBranches(branchList);

        bankRepository.save(bank);
        return ResponseEntity.ok(bank);
    }
}
