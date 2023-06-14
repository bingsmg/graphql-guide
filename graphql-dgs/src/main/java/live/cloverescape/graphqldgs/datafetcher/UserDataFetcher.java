package live.cloverescape.graphqldgs.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import live.cloverescape.graphqldgs.entity.User;
import live.cloverescape.graphqldgs.mapper.MyBatisMapper;
import live.cloverescape.graphqldgs.service.IUserService;
import live.cloverescape.graphqldgs.tool.SQLQueryBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author weibb
 */
@Slf4j
@DgsComponent
@RequiredArgsConstructor
public class UserDataFetcher {

    private final IUserService userService;
    private final MyBatisMapper mapper;

    @DgsQuery
    public List<User> users(DgsDataFetchingEnvironment env) {
        return userService.listUsers();
    }

    @DgsQuery
    public List<User> userPartInfo(DgsDataFetchingEnvironment env) {
        String userQuerySql = SQLQueryBuilder.buildSqlFromSelectionSet(SQLQueryBuilder.SELECT, "user", env.getSelectionSet());
        return mapper.executeDynamicSql(userQuerySql);
    }
}
