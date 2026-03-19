package ap1.andre.hermoza.Repository;

import ap1.andre.hermoza.Model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface productRepository extends ReactiveMongoRepository<Product, String> {
}
