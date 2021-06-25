package kz.one.lab.feign;

import kz.one.lab.model.Address;
import kz.one.lab.model.Order;
import kz.one.lab.model.Pizza;
import kz.one.lab.model.User;
import kz.one.lab.service.CheckPizza;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "CATALOG-CLIENT-SERVICE")
public interface CatalogFeign {
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> findAll();

    @GetMapping(value = "/user/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
    User findByEmail( @PathVariable("email") String email);

    @PostMapping(value ="/users",produces = MediaType.APPLICATION_JSON_VALUE)
    User newUser(User user);

    @GetMapping(value = "/pizzas/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    Pizza findByName(@PathVariable("name") String name);

    @GetMapping(value = "/pizza/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Pizza findById(@PathVariable("id") Long id);

    @PostMapping(value = "/pizza",produces = MediaType.APPLICATION_JSON_VALUE)
    Pizza updatePizza(Pizza pizza);

    @GetMapping(value = "/address/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Address findByAddressId(@PathVariable("id") Long id);

    @PostMapping(value = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
    Address saveAddress(Address address);

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Order> findAllOrders();

    @GetMapping(value = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Order> findAllOrdersById(@PathVariable("id") Long id);

    @PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    Order saveOrder(Order order);
}
