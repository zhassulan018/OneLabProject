package kz.lab.one.Catalog.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Pizza {
    @Id
    @GeneratedValue
    private Long pizzaId;
    private String name;
    private Integer availablePizzaAmount;
}
