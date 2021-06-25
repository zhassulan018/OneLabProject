package kz.one.lab.service;

import kz.one.lab.feign.CatalogFeign;
import kz.one.lab.model.User;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchUser implements JavaDelegate {

    @Autowired
    CatalogFeign catalogFeign;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        boolean registered = false;
        User user = null;
        if(catalogFeign.findByEmail((String) delegateExecution.getVariable("Login")) != null) {
            registered = true;
            user = catalogFeign.findByEmail((String) delegateExecution.getVariable("Login"));
            delegateExecution.setVariable("userId",user.getId());
        }
        delegateExecution.setVariable("registered",registered);
    }
}
