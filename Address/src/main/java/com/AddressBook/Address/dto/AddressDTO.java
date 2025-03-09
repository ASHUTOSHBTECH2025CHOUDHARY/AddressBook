package com.AddressBook.Address.dto;



import lombok.*;
//Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String city;
}