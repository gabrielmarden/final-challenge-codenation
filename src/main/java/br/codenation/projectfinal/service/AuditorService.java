package br.codenation.projectfinal.service;

import br.codenation.projectfinal.dto.UserDTO;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorService implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String username = ((UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return Optional.of(username);
    }
}
