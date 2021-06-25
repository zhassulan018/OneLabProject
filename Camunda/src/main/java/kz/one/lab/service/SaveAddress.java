package kz.one.lab.service;

import kz.one.lab.feign.CatalogFeign;
import kz.one.lab.model.Address;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveAddress implements JavaDelegate {

    @Autowired
    CatalogFeign catalogFeign;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String city = (String) delegateExecution.getVariable("City");
        String street = (String) delegateExecution.getVariable("Street");
        String home = (String) delegateExecution.getVariable("HomeNum");

        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setHomeNum(home);
        Address newAddress = catalogFeign.saveAddress(address);

        delegateExecution.setVariable("addressId",newAddress.getAddressId());
    }
}
