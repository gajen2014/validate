package com.javeatechie.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor

public class UserRequest{

        @NonNull
        private String name;
        @Email(message = "Invalid email Address")
        private String email;
        @Pattern(regexp = "^\\d{10}$",message = "Invalid mobile Number entered")
        private String mobile;

        private String gender;
        @Max(60)
        @Min(18)
        private int age;
        @NotBlank
        private String nationality;
}
