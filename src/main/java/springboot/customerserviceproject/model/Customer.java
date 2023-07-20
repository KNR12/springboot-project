package springboot.customerserviceproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="customerName", length=32, nullable=false)
    private String customerName;
    @Column(name="phoneNo", length=32, nullable = false)
    private String phoneNo;
    @Column(name="email", length=32, nullable=false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Products> productList;


    public Customer(Object s, String konda, String s1, String s2) {
    }
}
