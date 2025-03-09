package com.AddressBook.Address.service;

import com.AddressBook.Address.dto.AddressDTO;
import com.AddressBook.Address.model.Address;
import com.AddressBook.Address.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AddressService {
    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public List<AddressDTO> getAll() {
        log.info("Fetching all addresses from database");
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AddressDTO getById(Long id) {
        log.info("Fetching address from database with ID: {}", id);
        return repository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public AddressDTO save(AddressDTO addressDTO) {
        log.info("Saving address to database: {}", addressDTO);
        Address address = convertToEntity(addressDTO);
        return convertToDTO(repository.save(address));
    }

    public void delete(Long id) {
        log.info("Deleting address from database with ID: {}", id);
        repository.deleteById(id);
    }

    private AddressDTO convertToDTO(Address address) {
        return new AddressDTO(address.getId(), address.getName(), address.getPhone(), address.getEmail(), address.getCity());
    }

    private Address convertToEntity(AddressDTO dto) {
        return new Address(dto.getId(), dto.getName(), dto.getPhone(), dto.getEmail(), dto.getCity());
    }
}
