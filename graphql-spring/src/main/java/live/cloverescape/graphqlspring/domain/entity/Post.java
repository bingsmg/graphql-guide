package live.cloverescape.graphqlspring.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author weibb
 */
@Getter
@Setter
public class Post {
    private String id;
    private String title;
    private String category;
    private String authorId;
}
