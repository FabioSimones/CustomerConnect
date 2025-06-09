package dev.fabiosimones.customerconnect.controller;

import dev.fabiosimones.customerconnect.controller.dto.ApiResponse;
import dev.fabiosimones.customerconnect.controller.dto.CreateCustomerDTO;
import dev.fabiosimones.customerconnect.controller.dto.PaginationResponse;
import dev.fabiosimones.customerconnect.controller.dto.UpdateCustomerDTO;
import dev.fabiosimones.customerconnect.entity.CustomerEntity;
import dev.fabiosimones.customerconnect.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CreateCustomerDTO dto){
        var customer = customerService.createCustomer(dto);

        return ResponseEntity.created(URI.create(("/customers/" + customer.getCustomerId())))
                .build();
    }

    @GetMapping
    public ResponseEntity<ApiResponse<CustomerEntity>> findAll(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                               @RequestParam(name = "orderBy", defaultValue = "desc") String orderBy,
                                                               @RequestParam(name = "cpf", required = false) String cpf,
                                                               @RequestParam(name = "email", required = false) String email){

        var pageResp = customerService.findAll(page, pageSize, orderBy, cpf, email);

        return ResponseEntity.ok(new ApiResponse<>(
                pageResp.getContent(),
                new PaginationResponse(pageResp.getNumber(), pageResp.getSize(), pageResp.getTotalElements(), pageResp.getTotalPages())
        ));
    }

    @GetMapping(path = "/{customerId}")
    public ResponseEntity<CustomerEntity> findById(@PathVariable("customerId") Long customerId){
        var customer = customerService.findById(customerId);

        return customer.isPresent() ?
                ResponseEntity.ok(customer.get()) :
                ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{customerId}")
    public ResponseEntity<CustomerEntity> updateById(@PathVariable("customerId") Long customerId,
                                                     @RequestBody UpdateCustomerDTO dto){
        var customer = customerService.updateById(customerId, dto);

        return customer.isPresent() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
