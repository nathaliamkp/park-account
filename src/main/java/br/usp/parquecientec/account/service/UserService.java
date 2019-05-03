package br.usp.parquecientec.account.service;

import br.usp.parquecientec.account.model.User;

import java.util.List;

public interface UserService {

    User update(Integer userCode, User user) throws Exception;

    User save(User user) throws Exception;

    List<User> list();

    User getUser(Integer userCode);

    User delete(Integer userCode);
}
