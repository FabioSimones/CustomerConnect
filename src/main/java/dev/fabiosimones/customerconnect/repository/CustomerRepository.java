package dev.fabiosimones.customerconnect.repository;

import dev.fabiosimones.customerconnect.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
