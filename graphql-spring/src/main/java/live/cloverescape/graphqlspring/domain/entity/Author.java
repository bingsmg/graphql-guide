package live.cloverescape.graphqlspring.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

/**
 * @author weibb
 */
@Getter
@Setter
@AllArgsConstructor
public class Author {

    private String id;
    private String firstName;
    private String lastName;

    private static List<Author> authors = Arrays.asList(
            new Author("author-1", "Joanne", "Rowling"),
            new Author("author-2", "Herman", "Melville"),
            new Author("author-3", "Anne", "Rice")
    );

    public static Author getById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }
}