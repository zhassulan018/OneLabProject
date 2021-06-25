package kz.one.lab.service;

import kz.one.lab.feign.CatalogFeign;
import kz.one.lab.model.Order;
import kz.one.lab.model.Pizza;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderBasket implements JavaDelegate {
    @Autowired
    CatalogFeign catalogFeign;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Order order = new Order();
        order.setAddressId((long)delegateExecution.getVariable("addressId"));
        order.setAmount((int)delegateExecution.getVariable("orderAmount"));
        order.setUserId((long)delegateExecution.getVariable("userId"));
        order.setPizzaId((long) delegateExecution.getVariable("pizzaId"));
        catalogFeign.saveOrder(order);
        Pizza pizza = catalogFeign.findById((long)delegateExecution.getVariable("pizzaId"));
        pizza.setAvailablePizzaAmount(pizza.getAvailablePizzaAmount() - (int)delegateExecution.getVariable("orderAmount"));
        catalogFeign.updatePizza(pizza);
    }
}
