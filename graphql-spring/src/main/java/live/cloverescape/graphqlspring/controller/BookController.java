package live.cloverescape.graphqlspring.controller;

import live.cloverescape.graphqlspring.domain.dto.PostDTO;
import live.cloverescape.graphqlspring.domain.entity.Author;
import live.cloverescape.graphqlspring.domain.entity.Book;
import live.cloverescape.graphqlspring.domain.entity.Post;
import live.cloverescape.graphqlspring.service.rest.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

/**
 * @author weibb
 */
@RequiredArgsConstructor
@Controller
public class BookController {

    private final IBookService bookService;

    @QueryMapping("bookById")
    public Book bookById(@Argument("id") String id) {
        return bookService.getOne(id);
    }

    @SchemaMapping(typeName = "Book", field = "author")
    public Author author(Book book) {
        // @ SchemaMapping 注释将处理程序方法映射到 GraphQL 模式中的字段，并声明它是该字段的 DataFetcher。
        // 字段名默认为方法名，类型名默认为注入到方法中的源/父对象的简单类名。在本例中，字段默认为 author，类型默认为 Book
        return Author.getById(book.getAuthorId());
    }

    @MutationMapping("createPost")
    public Post createPost(@Argument PostDTO postDTO) {
        Post post = new Post();
        post.setId(UUID.randomUUID().toString());
        post.setTitle(postDTO.getTitle());
        post.setCategory(postDTO.getCategory());
        post.setAuthorId(postDTO.getAuthorId());
        return post;
    }
}