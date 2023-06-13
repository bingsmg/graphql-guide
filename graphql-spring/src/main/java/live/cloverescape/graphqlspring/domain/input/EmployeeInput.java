package live.cloverescape.graphqlspring.domain.input;

import lombok.Data;

/**
 * @author weibb
 */
@Data
public class EmployeeInput {

    private String firstName;
    private String lastName;
    private String position;
    private Integer salary;
    private Integer age;
    private Integer organizationId;
    private Integer departmentId;
}
