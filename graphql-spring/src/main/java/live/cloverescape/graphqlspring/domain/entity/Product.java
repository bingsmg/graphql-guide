package live.cloverescape.graphqlspring.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author weibb
 */
@Getter
@Setter
public class Product {
    private String id;
    private String name;
    private String description;
    private Double cost;
    private Double tax;
    LocalDate launchDate;
}
