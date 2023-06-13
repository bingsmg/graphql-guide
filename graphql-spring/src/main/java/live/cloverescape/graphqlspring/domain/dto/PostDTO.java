package live.cloverescape.graphqlspring.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author weibb
 */
@Getter
@Setter
public class PostDTO {
    private String id;
    private String title;
    private String category;
    private String authorId;
}
