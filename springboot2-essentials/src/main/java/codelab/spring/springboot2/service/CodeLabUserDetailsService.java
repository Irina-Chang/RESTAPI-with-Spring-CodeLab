package codelab.spring.springboot2.service;

import codelab.spring.springboot2.repository.CodeLabUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CodeLabUserDetailsService implements UserDetailsService {
    private final CodeLabUserRepository codeLabUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return Optional.ofNullable(codeLabUserRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("CodeLab User not found"));
    }
}
