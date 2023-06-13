package live.cloverescape.graphqlspring.domain.entity;

import live.cloverescape.graphqlspring.constant.BookTypeEnum;
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
public class Book {

    private String id;
    private String name;
    private int pageCount;
    private String authorId;
    private BookTypeEnum bookType;

    private static List<Book> books = Arrays.asList(
            new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1", BookTypeEnum.ANIMAL),
            new Book("book-2", "Moby Dick", 635, "author-2", BookTypeEnum.PLANT),
            new Book("book-3", "Interview with the vampire", 371, "author-3", BookTypeEnum.NATURE)
    );

    public static Book getById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }
}