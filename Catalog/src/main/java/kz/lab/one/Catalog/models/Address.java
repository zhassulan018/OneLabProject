package kz.lab.one.Catalog.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long addressId;
    private String city;
    private String street;
    private String homeNum;
}
