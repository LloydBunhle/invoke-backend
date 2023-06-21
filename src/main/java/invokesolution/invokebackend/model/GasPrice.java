package invokesolution.invokebackend.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table( name = "products")
public class GasPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String  price;
}
