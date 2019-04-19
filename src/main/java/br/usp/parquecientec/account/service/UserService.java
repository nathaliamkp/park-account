package br.usp.parquecientec.account.service;

import br.usp.parquecientec.account.model.User;

import java.util.List;

public interface UserService {

    User update(Integer userCode, User user);

    User save(User user);

    List<User> list();

    User getUser(Integer userCode);

    void delete(Integer userCode);
}
