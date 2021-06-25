package kz.lab.one.Catalog.repository;

import kz.lab.one.Catalog.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    Address findByAddressId(Long id);
}
