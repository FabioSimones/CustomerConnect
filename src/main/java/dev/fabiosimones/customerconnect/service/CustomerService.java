package dev.fabiosimones.customerconnect.service;

import dev.fabiosimones.customerconnect.controller.dto.CreateCustomerDTO;
import dev.fabiosimones.customerconnect.controller.dto.UpdateCustomerDTO;
import dev.fabiosimones.customerconnect.entity.CustomerEntity;
import dev.fabiosimones.customerconnect.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.swing.text.html.Option;
import java.util.Optional;

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

    public Page<CustomerEntity> findAll(Integer page, Integer pageSize, String orderBy,
                                        String cpf, String email) {

        var pageResquest = getPageRequest(page, pageSize, orderBy);
        return findWithFilter(cpf, email, pageResquest);
    }

    private Page<CustomerEntity> findWithFilter(String cpf, String email, PageRequest pageResquest) {
        if(StringUtils.hasText(cpf) && StringUtils.hasText(email)){
            return customerRepository.findByCpfAndEmail(cpf, email, pageResquest);
        }
        if(StringUtils.hasText(cpf)){
            return customerRepository.findByCpf(cpf, pageResquest);
        }
        if(StringUtils.hasText(email)){
            return customerRepository.findByEmail(email, pageResquest);
        }

        return customerRepository.findAll(pageResquest);
    }

    private PageRequest getPageRequest(Integer page, Integer pageSize, String orderBy) {
        var direction = Sort.Direction.DESC;
        if(orderBy.equalsIgnoreCase("asc")){
            direction = Sort.Direction.ASC;
        }
        return PageRequest.of(page, pageSize, direction, "createdAt");
    }

    public Optional<CustomerEntity> findById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public Optional<CustomerEntity> updateById(Long customerId, UpdateCustomerDTO dto) {
        var customer = customerRepository.findById(customerId);

        if (customer.isPresent()){
            updateFields(dto, customer);

            customerRepository.save(customer.get());
        }

        return customer;
    }

    private static void updateFields(UpdateCustomerDTO dto, Optional<CustomerEntity> customer) {
        if(StringUtils.hasText(dto.fullName())){
            customer.get().setFullName(dto.fullName());
        }

        if(StringUtils.hasText(dto.email())){
            customer.get().setEmail(dto.email());
        }

        if(StringUtils.hasText(dto.phoneNumber())){
            customer.get().setPhoneNumber(dto.phoneNumber());
        }
    }
}
