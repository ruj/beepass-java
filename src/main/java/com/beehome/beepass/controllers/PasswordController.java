package com.beehome.beepass.controllers;

import com.beehome.beepass.dtos.request.PasswordRequestDTO;
import com.beehome.beepass.dtos.response.PasswordResponseDTO;
import com.beehome.beepass.services.PasswordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/generate-password")
    public ResponseEntity<PasswordResponseDTO> generatePassword(@Valid @RequestBody PasswordRequestDTO request) {
        String password = passwordService.generatePassword(
                request.getLength(),
                request.getIncludeUppercase(),
                request.getIncludeLowercase(),
                request.getIncludeNumbers(),
                request.getIncludeSpecialChars()
        );
        return ResponseEntity.ok(new PasswordResponseDTO(password));
    }

}
