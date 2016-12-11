package com.myself.server.repository;

import com.myself.server.entity.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Alex.Chen on 2016/12/8.
 */
public interface AccountDao extends CrudRepository<Account, String> {
    Account findByUserName(String userName);
    Account findByToken(String token);
}
