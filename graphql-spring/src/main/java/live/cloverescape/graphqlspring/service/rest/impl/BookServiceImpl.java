package live.cloverescape.graphqlspring.service.rest.impl;

import live.cloverescape.graphqlspring.domain.entity.Book;
import live.cloverescape.graphqlspring.service.rest.IBookService;
import org.springframework.stereotype.Service;

/**
 * @author weibb
 */
@Service
public class BookServiceImpl implements IBookService {
    @Override
    public Book getOne(String id) {
        if (id.startsWith("id")) {
            throw new IllegalStateException("无效状态");
        }
        return Book.getById(id);
    }
}
