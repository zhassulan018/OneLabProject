package kz.one.lab.service;

import kz.one.lab.feign.CatalogFeign;
import kz.one.lab.model.User;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUser implements JavaDelegate {

    @Autowired
    CatalogFeign catalogFeign;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        User user = new User();
        user.setEmail((String)delegateExecution.getVariable("Email"));
        user.setName((String)delegateExecution.getVariable("Name"));
        user.setAge(Integer.parseInt((String)delegateExecution.getVariable("Age")));
        System.out.println(user.getEmail() +" "+user.getAge() +" " +user.getName());
        catalogFeign.newUser(user);
    }
}
