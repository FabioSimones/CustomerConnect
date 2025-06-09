package dev.fabiosimones.customerconnect.repository;

import dev.fabiosimones.customerconnect.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Page<CustomerEntity> findByCpf(String cpf, PageRequest pageResquest);

    Page<CustomerEntity> findByEmail(String email, PageRequest pageResquest);

    Page<CustomerEntity> findByCpfAndEmail(String cpf, String email, PageRequest pageResquest);

}
