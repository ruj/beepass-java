package com.beehome.beepass.dtos.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PasswordRequestDTO {

    @NotNull(message = "Length is required")
    @Min(value = 1, message = "Length must be at least 1")
    @Max(value = 32, message = "Length must be at most 32")
    private Integer length;

    private Boolean includeUppercase;
    private Boolean includeLowercase;
    private Boolean includeNumbers;
    private Boolean includeSpecialChars;

}
