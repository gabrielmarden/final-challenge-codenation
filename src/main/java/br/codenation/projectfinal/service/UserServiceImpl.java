package br.codenation.projectfinal.service;

import br.codenation.projectfinal.error.ResourceNotFound;
import br.codenation.projectfinal.model.User;
import br.codenation.projectfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        User u = userRepository.save(user);
        u.setCreatedAt(Calendar.getInstance().getTime());

        return u;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
