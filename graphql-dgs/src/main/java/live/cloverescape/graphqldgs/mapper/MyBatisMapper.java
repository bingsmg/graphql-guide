package live.cloverescape.graphqldgs.mapper;

import live.cloverescape.graphqldgs.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * mybatis 执行接口，处理各种构建的 sql 查询
 * @author seven
 */
@Mapper
public interface MyBatisMapper {

    @Select("${sql}")
    List<User> executeDynamicSql(@Param("sql") String sql);
}
