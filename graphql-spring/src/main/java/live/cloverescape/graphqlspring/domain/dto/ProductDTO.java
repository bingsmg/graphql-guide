package live.cloverescape.graphqlspring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author weibb
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

        private String id;

        @Length(min = 2, max = 5, message = "名称过长")
        private String name;

        @NotNull
        private String description;

        @Min(value = 1, message = "cost太低")
        private Double cost;
        private Double tax;
        LocalDate launchDate;

    //    public String getName(DataFetchingEnvironment environment) {
    //        Object name1 = environment.getArgument("name");
    //        return name;
    //    }
}
