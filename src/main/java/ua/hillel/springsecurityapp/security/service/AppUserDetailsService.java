package ua.hillel.springsecurityapp.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.hillel.springsecurityapp.model.entity.User;
import ua.hillel.springsecurityapp.repo.UserRepo;
import ua.hillel.springsecurityapp.security.auth.AppUserDetails;

@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByName(username);
        return new AppUserDetails(user);
    }
}
