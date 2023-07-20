package springboot.customerserviceproject.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.customerserviceproject.model.Products;

public interface ProductsRespository extends JpaRepository<Products,Long> {


}
