package kz.lab.one.Catalog.repository;

import kz.lab.one.Catalog.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Long> {
    Pizza findByName(String name);
    Pizza findByPizzaId(Long id);
}
