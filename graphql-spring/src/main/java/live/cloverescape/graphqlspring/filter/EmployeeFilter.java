package live.cloverescape.graphqlspring.filter;

import lombok.Data;

/**
 * @author weibb
 */
@Data
public class EmployeeFilter {

    private FilterField salary;
    private FilterField age;
    private FilterField position;
}
