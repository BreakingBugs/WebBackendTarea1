package py.una.pol.web.tarea1.controller;

import py.una.pol.web.tarea1.model.Customer;
import py.una.pol.web.tarea1.model.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by codiumsa on 28/2/16.
 */
public class CustomerController {
    private static CustomerController instance = new CustomerController();
    private Integer sequence = 1;
    private List<Customer> customers = new ArrayList<Customer>();

    private CustomerController() {
        //Mock customer
        Customer c = new Customer();
        c.setName("John Doe");
        c.setAmountToPay(0.0);
        this.addCustomer(c);
    }

    public static CustomerController getInstance() {
        return instance;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer c) {
        c.setId(sequence++);
        this.customers.add(c);
    }

    public Customer getCustomer(Integer id) {
        for(Customer c : customers) {
            if(c.getId() != null && c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public Customer updateCustomer(Integer id, Customer customerWithChanges) {
        for(Customer c : customers) {
            if(c.getId() != null && c.getId().equals(id)) {
                if(customerWithChanges.getName() != null) {
                    c.setName(customerWithChanges.getName());
                }

                return c;
            }
        }
        return null;
    }

    public void removeCustomer(final Integer id) {
        customers.removeIf(new Predicate<Customer>() {
            public boolean test(Customer customer) {
                if(customer.getId() != null && customer.getId().equals(id)) {
                    return true;
                }
                return false;
            }
        });
    }
}