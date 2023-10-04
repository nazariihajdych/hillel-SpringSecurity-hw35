package ua.hillel.springsecurityapp.service;

import ua.hillel.springsecurityapp.exception.EntityNotFoundException;
import ua.hillel.springsecurityapp.exception.InconsistencyException;
import ua.hillel.springsecurityapp.model.dto.LoginDTO;
import ua.hillel.springsecurityapp.model.dto.RegisterDTO;
import ua.hillel.springsecurityapp.model.dto.UserDTO;

public interface AuthService {
    void authenticate(LoginDTO loginDTO) throws EntityNotFoundException, InconsistencyException;
    UserDTO register(RegisterDTO registerDTO) throws InconsistencyException;
}
