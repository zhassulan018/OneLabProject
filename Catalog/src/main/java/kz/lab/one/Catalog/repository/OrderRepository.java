package kz.lab.one.Catalog.repository;

import kz.lab.one.Catalog.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAll();
    List<Order> findAllByUserId(Long userId);
}
