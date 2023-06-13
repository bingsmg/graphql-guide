package live.cloverescape.graphqlspring.service.rest;

import live.cloverescape.graphqlspring.domain.entity.Book;
import org.springframework.graphql.data.method.annotation.Argument;

/**
 * @author weibb
 */
public interface IBookService {

    Book getOne(@Argument("id") String id);
}
