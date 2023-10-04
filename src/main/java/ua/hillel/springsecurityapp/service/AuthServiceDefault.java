package ua.hillel.springsecurityapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.hillel.springsecurityapp.exception.EntityNotFoundException;
import ua.hillel.springsecurityapp.exception.InconsistencyException;
import ua.hillel.springsecurityapp.model.dto.LoginDTO;
import ua.hillel.springsecurityapp.model.dto.RegisterDTO;
import ua.hillel.springsecurityapp.model.dto.UserDTO;
import ua.hillel.springsecurityapp.model.entity.User;
import ua.hillel.springsecurityapp.model.mapper.UserMapper;
import ua.hillel.springsecurityapp.repo.UserRepo;

@Service
@RequiredArgsConstructor
public class AuthServiceDefault implements AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public void authenticate(LoginDTO loginDTO) throws EntityNotFoundException, InconsistencyException {
        User byUsername = userRepo.findByName(loginDTO.getName());
        if (byUsername == null) {
            throw new EntityNotFoundException("User with username '"
                    + loginDTO.getName() + "' does not exist");
        }
        boolean matches = passwordEncoder.matches(loginDTO.getPassword(), byUsername.getPassword());
        if (!matches) throw new InconsistencyException("Wrong credentials");
    }

    @Override
    public UserDTO register(RegisterDTO registerDTO) throws InconsistencyException {
        User user = userRepo.findByName(registerDTO.getName());

        if (user != null) {
            throw new InconsistencyException(
                    "User with username '" + registerDTO.getName() + "' already exists");
        }

        User registerUser = new User();
        registerUser.setName(registerDTO.getName());
        registerUser.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        User savedUser = userRepo.save(registerUser);
        return userMapper.userToUserDTO(savedUser);
    }
}
