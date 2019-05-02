package br.usp.parquecientec.account.service;

import br.usp.parquecientec.account.model.User;
import br.usp.parquecientec.account.repository.UserRepository;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User update(Integer userCode, User user) {
        Optional<User> userOptional = userRepository.findById(userCode);
        if (userOptional.isPresent()) {
            user.setCode(userCode);
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> list() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUser(Integer userCode) {
        Optional<User> userOptional = userRepository.findById(userCode);
        return userOptional.orElse(null);

    }

    @Override
    public User delete(Integer userCode) {
        Optional<User> userOptional = userRepository.findById(userCode);
        if (userOptional.isPresent()) {
            User deleteUser = userOptional.get();
            userRepository.delete(deleteUser);
            return deleteUser;
        } else {
            return null;
        }

    }
}
