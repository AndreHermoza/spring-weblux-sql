package ap1.andre.hermoza.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Data
@Table(name = "products")
public class Product {

    @Id
    private Integer product_id;
    private String name;
    private String category;
    private String brand;
    private double price;
    private Integer stock;
    private boolean is_active = true;
    private LocalDateTime created_at = LocalDateTime.now();
    private Integer warranty_months;

}
