package ua.hillel.springsecurityapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.hillel.springsecurityapp.exception.EntityNotFoundException;
import ua.hillel.springsecurityapp.exception.InconsistencyException;
import ua.hillel.springsecurityapp.model.dto.LoginDTO;
import ua.hillel.springsecurityapp.service.AuthService;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final AuthService authService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) throws EntityNotFoundException, InconsistencyException {
        authService.authenticate(loginDTO);
        return ResponseEntity.ok("User " + loginDTO.getName() + " successfully logged in!");
    }
}
