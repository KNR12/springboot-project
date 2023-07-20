package springboot.customerserviceproject.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.customerserviceproject.model.Customer;

import java.util.Optional;
@Repository
public interface CustomerRespository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByEmail(String email);
}
