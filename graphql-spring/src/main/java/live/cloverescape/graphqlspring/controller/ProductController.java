package live.cloverescape.graphqlspring.controller;


import live.cloverescape.graphqlspring.domain.dto.ProductDTO;
import live.cloverescape.graphqlspring.domain.entity.Product;
import live.cloverescape.graphqlspring.domain.input.ProductInput;
import live.cloverescape.graphqlspring.service.graphql.IProductResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * @author weibb
 */
@RequiredArgsConstructor
@Controller
public class ProductController {

    public final IProductResolver productResolver;

    @QueryMapping("products")
    public List<ProductDTO> listProduct() {
        return Collections.emptyList();
    }

    @MutationMapping("createProduct")
    public Product createProduct(@Valid @Argument ProductInput productInput) {
        return productResolver.createProduct(productInput);
    }
}
