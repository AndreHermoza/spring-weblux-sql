package ap1.andre.hermoza.Service;

import ap1.andre.hermoza.Model.Product;
import ap1.andre.hermoza.Repository.productRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ProductService {

    private final productRepository Prepo;


    public ProductService(productRepository repo) {
        Prepo = repo;
    }

    public Flux<Product> findAll() {
        log.info("Listando todos los datos");
       return Prepo.findAll();
    }

    public Mono<Product> findByID(Integer id) {
        log.info("Buscando por ID");
        return Prepo.findById(id);
    }

    public Mono<Product> newProduct(Product product) {
        log.info("Creando nuevo producto" + product.toString());
        return Prepo.save(product);
    }

    public Mono<Product> updateProduct(Product product) {
        log.info("Producto actualizado" + product.toString());
        return Prepo.save(product);
    }

    public Mono<Product> setProductStatus(boolean is_active, Integer id) {
        log.info("Estado cambiado a: " + is_active);
        return Prepo.findById(id)
                .flatMap(product -> {
                    product.set_active(is_active);
                    return Prepo.save(product);

                });
    }

}
