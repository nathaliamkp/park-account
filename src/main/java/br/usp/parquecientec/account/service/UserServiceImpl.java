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
            User savedUser = userOptional.get();
            savedUser.setFirstName(user.getFirstName());
            userRepository.save(savedUser);
            return savedUser;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public User getUser(Integer userCode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Integer userCode) {
        throw new UnsupportedOperationException();
    }
}
