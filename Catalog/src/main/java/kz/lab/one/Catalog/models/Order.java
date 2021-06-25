package kz.lab.one.Catalog.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long orderId;
    private Long pizzaId;
    private Long userId;
    private Long addressId;
    private Integer amount;
}
