package com.AddressBook.Address.controller;

import com.AddressBook.Address.dto.AddressDTO;
import com.AddressBook.Address.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAll() {
        log.info("Fetching all addresses");
        List<AddressDTO> addresses = service.getAll();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getById(@PathVariable Long id) {
        log.info("Fetching address with ID: {}", id);
        AddressDTO address = service.getById(id);
        return address != null ? ResponseEntity.ok(address) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AddressDTO> add(@RequestBody AddressDTO addressDTO) {
        log.info("Adding new address: {}", addressDTO);
        return ResponseEntity.ok(service.save(addressDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        log.info("Updating address with ID: {}", id);
        addressDTO.setId(id);
        return ResponseEntity.ok(service.save(addressDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Deleting address with ID: {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
