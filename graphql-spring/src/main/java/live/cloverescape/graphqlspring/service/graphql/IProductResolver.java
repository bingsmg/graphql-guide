package live.cloverescape.graphqlspring.service.graphql;


import live.cloverescape.graphqlspring.domain.entity.Product;
import live.cloverescape.graphqlspring.domain.input.ProductInput;

/**
 * @author weibb
 */

public interface IProductResolver {
    Product createProduct(ProductInput productInput);
}
