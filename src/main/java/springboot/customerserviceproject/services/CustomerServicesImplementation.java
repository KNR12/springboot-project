package springboot.customerserviceproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.customerserviceproject.model.Customer;
import springboot.customerserviceproject.respository.CustomerRespository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServicesImplementation implements CustomerServices {

    @Autowired
    private CustomerRespository customerRespository;

    @Override
    public List<Customer> findAll() {
        return customerRespository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customerResult = customerRespository.findById(id);
        Customer customer;
        if (customerResult.isPresent()) {
            customer = customerResult.get();
        } else {
            throw new RuntimeException("Customer id not find" + id);
        }
        return customer;
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerRespository.findByEmail(email);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRespository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRespository.deleteById(id);


    }
}
