package kz.one.lab.service;

import kz.one.lab.feign.CatalogFeign;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckPizza implements JavaDelegate {
    @Autowired
    CatalogFeign catalogFeign;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        boolean pizzaAvailable = false;
        String pizzaName = (String) delegateExecution.getVariable("Pizza_Name");
        int amount = Integer.parseInt((String) delegateExecution.getVariable("Amount"));
        if(catalogFeign.findByName(pizzaName) != null && catalogFeign.findByName(pizzaName).getAvailablePizzaAmount() >= amount){
            pizzaAvailable = true;
            delegateExecution.setVariable("pizzaId", catalogFeign.findByName(pizzaName).getPizzaId());
        }
        delegateExecution.setVariable("orderAmount", amount);
        delegateExecution.setVariable("pizzaAvailable",pizzaAvailable);

    }
}
