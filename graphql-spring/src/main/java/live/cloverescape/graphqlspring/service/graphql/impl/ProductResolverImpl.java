package live.cloverescape.graphqlspring.service.graphql.impl;

import live.cloverescape.graphqlspring.domain.entity.Product;
import live.cloverescape.graphqlspring.domain.input.ProductInput;
import live.cloverescape.graphqlspring.service.graphql.IProductResolver;
import org.springframework.stereotype.Component;

/**
 * @author weibb
 */
@Component
public class ProductResolverImpl implements IProductResolver {
    @Override
    public Product createProduct(ProductInput productInput) {
        Product product = new Product();
        product.setName(productInput.getName());
        product.setDescription(productInput.getDescription());
        product.setCost(productInput.getCost());
        product.setTax(productInput.getTax());
        return product;
    }
}
