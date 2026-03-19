package ap1.andre.hermoza.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private String category;
    private String brand;
    private double price;
    private Integer stock;
    private boolean is_active = true;
    private LocalDateTime created_at = LocalDateTime.now();
    private Integer warranty_months;

}
