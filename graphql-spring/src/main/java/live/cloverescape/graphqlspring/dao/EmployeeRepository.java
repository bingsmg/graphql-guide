package live.cloverescape.graphqlspring.dao;

import live.cloverescape.graphqlspring.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author weibb
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

    @Query("select e.id, e.age, e.firstName from Employee e")
    List<Map<String, Object>> findA();
}
