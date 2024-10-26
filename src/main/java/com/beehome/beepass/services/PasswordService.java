package com.beehome.beepass.services;

import com.beehome.beepass.models.Password;
import com.beehome.beepass.repositories.PasswordRepository;
import com.beehome.beepass.utils.CharacterConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepository passwordRepository;

    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialChars) {
        StringBuilder characterPool = new StringBuilder();

        if (includeUppercase) characterPool.append(CharacterConstants.UPPERCASE);
        if (includeLowercase) characterPool.append(CharacterConstants.LOWERCASE);
        if (includeNumbers) characterPool.append(CharacterConstants.NUMBERS);
        if (includeSpecialChars) characterPool.append(CharacterConstants.SPECIAL_CHARS);

        SecureRandom random = new SecureRandom();
        StringBuilder generatedPassword = new StringBuilder();

        for (int index = 0; index < length; index++) {
            generatedPassword.append(characterPool.charAt(random.nextInt(characterPool.length())));
        }

        Password password = new Password();
        password.setPassword(generatedPassword.toString());
        passwordRepository.save(password);

        return password.getPassword();
    }

}
