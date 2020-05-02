package br.codenation.projectfinal.service;

import br.codenation.projectfinal.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findById(Long id);

    List<User> findAll();

    Optional<User> findByEmail(String email);

    User save(User user);

    void delete(Long id);
}
