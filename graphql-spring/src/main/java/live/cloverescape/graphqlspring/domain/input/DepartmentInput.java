package live.cloverescape.graphqlspring.domain.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author weibb
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentInput {
    private String name;
    private Integer organizationId;
}
