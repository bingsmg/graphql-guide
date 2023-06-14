package live.cloverescape.graphqldgs.entity;

import lombok.Data;

/**
 * @author weibb
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
