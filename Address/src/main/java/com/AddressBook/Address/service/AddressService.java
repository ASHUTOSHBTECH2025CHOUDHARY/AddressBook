package com.AddressBook.Address.service;

import com.AddressBook.Address.dto.AddressDTO;
import com.AddressBook.Address.model.Address;
import com.AddressBook.Address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public List<AddressDTO> getAll() {  return repository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList()); }

    public AddressDTO getById(Long id) { return repository.findById(id).map(this::convertToDTO).orElse(null); }

}
