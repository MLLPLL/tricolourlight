package com.myself.server.service;

import com.myself.server.entity.Account;

/**
 * Created by Alex.Chen on 2016/12/8.
 */
public interface AccountService {
    Account login(String username,String password);
    void saveAccount(Account account);
    boolean validateToken(String token);
}
