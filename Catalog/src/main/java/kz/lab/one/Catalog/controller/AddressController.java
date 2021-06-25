package kz.lab.one.Catalog.controller;

import kz.lab.one.Catalog.models.Address;
import kz.lab.one.Catalog.models.Pizza;
import kz.lab.one.Catalog.repository.AddressRepository;
import kz.lab.one.Catalog.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(value = "/address/{id}")
    Address getById(@PathVariable Long id){
        Address address = addressRepository.findByAddressId(id);
        return address;
    }

    @PostMapping("/address")
    Address saveAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

}
