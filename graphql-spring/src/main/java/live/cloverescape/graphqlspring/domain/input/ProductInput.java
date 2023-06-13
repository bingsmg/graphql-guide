package live.cloverescape.graphqlspring.domain.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author weibb
 */
@Getter
@Setter
@NoArgsConstructor
public class ProductInput {

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
