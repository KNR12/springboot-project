package springboot.customerserviceproject.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.customerserviceproject.model.Customer;
import springboot.customerserviceproject.services.CustomerServices;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/CustomerApi")
public class CustomerRestController {

    @Autowired
    private CustomerServices customerServices;

    //allcustomer return all customer
    @GetMapping("/allcustomers")
    public List<Customer> findAll(){
        return customerServices.findAll();
    }
    //
    @GetMapping("/customer")
    public Customer getCustomer(@RequestParam Long id){
        Customer customer=customerServices.findById(id);
        return customer;
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> create(@Valid @RequestBody Customer customer){
        Optional<Customer> customerEmail=customerServices.findByEmail(customer.getEmail());
        if(customerEmail.isPresent()){
            throw new RuntimeException("email already existed");
        }
        Customer save=customerServices.save(customer);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Customer>update(@RequestBody Customer customer){
        Customer customerResult=customerServices.findById(customer.getId());
        Customer save=customerServices.save(customer);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id){
        Customer customer=customerServices.findById(id);
        customerServices.deleteById(id);
        return "Delete customer id - "+id;
    }
}
