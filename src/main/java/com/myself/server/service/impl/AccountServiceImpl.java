package com.myself.server.service.impl;

import com.myself.server.entity.Account;
import com.myself.server.repository.AccountDao;
import com.myself.server.service.AccountService;
import com.myself.server.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * Created by Alex.Chen on 2016/12/8.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account login(String username,String password) {
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return null;
        }
        Account account = accountDao.findByUserName(username);
        if(account != null && MD5Util.MD5(password).equals(account.getPassword())){
            String token = UUID.randomUUID().toString().replace("-","");
            account.setToken(token);
        }else{
            return null;
        }
        return account;
    }

    @Override
    public void saveAccount(Account account) {
        account.setPassword(MD5Util.MD5(account.getPassword()));
        accountDao.save(account);
    }

    @Override
    public boolean validateToken(String token) {
        if(StringUtils.isEmpty(token)){
            return false;
        }
        Account account = accountDao.findByToken(token);
        if(account != null){
            return true;
        }
        return false;
    }
}
