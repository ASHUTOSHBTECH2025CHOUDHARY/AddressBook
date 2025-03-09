package com.AddressBook.Address.dto;

import lombok.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name must contain only letters and spaces")
    private String name;

    private String phone;
    private String email;
    private String city;
}
