package ap1.andre.hermoza.Repository;

import ap1.andre.hermoza.Model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface productRepository extends ReactiveCrudRepository<Product, Integer> {
}
