package live.cloverescape.graphqldgs.tool;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Jpa 执行器，执行动态拼接 sql
 * @author weibb
 */
@Component
public class JpaExecutor {

    private final EntityManager entityManager;

    public JpaExecutor(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Object executeDynamicSql(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        // 根据需要选择 getResultList() 或者 getSingleResult()
        return query.getResultList();
    }
}
