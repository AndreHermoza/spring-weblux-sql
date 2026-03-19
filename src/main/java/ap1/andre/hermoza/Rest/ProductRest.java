package ap1.andre.hermoza.Rest;

import ap1.andre.hermoza.Model.Product;
import ap1.andre.hermoza.Service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/product")
public class ProductRest {

    private final ProductService PService;

    public ProductRest(ProductService pService) {
        PService = pService;
    }

    @GetMapping
    public Flux<Product> findAll() {
        return PService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> findByID(@PathVariable String id){
        return PService.findByID(id);
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody Product product) {
        return PService.newProduct(product);
    }

    @PutMapping
    public Mono<Product> updateProduct(@RequestBody Product product) {
        return PService.updateProduct(product);
    }

    @PatchMapping("/deactivate/{id}")
    public Mono<Product> deactivateProduct(@PathVariable String id) {
        return PService.findByID(id)
                .flatMap(product -> {
                    product.set_active(false);
                    return PService.setProductStatus(false, id);
                });

    }

    @PatchMapping("/activate/{id}")
    public Mono<Product> activateProduct(@PathVariable String id) {
        return PService.findByID(id)
                .flatMap(product -> {
                    product.set_active(true);
                    return PService.setProductStatus(true, id);
                });

    }

}
