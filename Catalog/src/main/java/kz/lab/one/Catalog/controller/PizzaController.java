package kz.lab.one.Catalog.controller;

import kz.lab.one.Catalog.models.Pizza;
import kz.lab.one.Catalog.models.User;
import kz.lab.one.Catalog.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PizzaController {

    @Autowired
    PizzaRepository pizzaRepository;

    @RequestMapping(value = "/pizzas/{name}")
    Pizza getByName(@PathVariable String name){
        Pizza pizza = pizzaRepository.findByName(name);
        return pizza;
    }

    @RequestMapping(value = "/pizza/{id}")
    Pizza getById(@PathVariable Long id){
        Pizza pizza = pizzaRepository.findByPizzaId(id);
        return pizza;
    }

    @PostMapping("/pizza")
    Pizza updatePizza(@RequestBody Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

}
