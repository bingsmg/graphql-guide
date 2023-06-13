package live.cloverescape.graphqlspring.mapper;

import live.cloverescape.graphqlspring.domain.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * @author seven
 */
@Mapper
public interface EmployeeMapper {

    @Select("select e.id id, e.age age, e.first_name firstName from Employee e")
    List<Map<String, Object>> findE();

}
