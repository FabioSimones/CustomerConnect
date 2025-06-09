package dev.fabiosimones.customerconnect.service;

import dev.fabiosimones.customerconnect.controller.dto.CreateCustomerDTO;
import dev.fabiosimones.customerconnect.entity.CustomerEntity;
import dev.fabiosimones.customerconnect.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity createCustomer(CreateCustomerDTO dto) {
        var entity = new CustomerEntity();
        entity.setFullName(dto.fullName());
        entity.setCpf(dto.cpf());
        entity.setEmail(dto.email());
        entity.setPhoneNumber(dto.phoneNumber());

        return customerRepository.save(entity);
    }
}
