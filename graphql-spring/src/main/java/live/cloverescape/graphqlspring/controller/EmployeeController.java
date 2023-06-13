package live.cloverescape.graphqlspring.controller;


import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import graphql.schema.SelectedField;
import live.cloverescape.graphqlspring.dao.DepartmentRepository;
import live.cloverescape.graphqlspring.dao.EmployeeRepository;
import live.cloverescape.graphqlspring.dao.OrganizationRepository;
import live.cloverescape.graphqlspring.domain.entity.Department;
import live.cloverescape.graphqlspring.domain.entity.Employee;
import live.cloverescape.graphqlspring.domain.entity.Organization;
import live.cloverescape.graphqlspring.domain.input.EmployeeInput;
import live.cloverescape.graphqlspring.filter.EmployeeFilter;
import live.cloverescape.graphqlspring.filter.FilterField;
import live.cloverescape.graphqlspring.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author weibb
 */
@RequiredArgsConstructor
@Controller
public class EmployeeController {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final OrganizationRepository organizationRepository;

    private final EmployeeMapper employeeMapper;

    @QueryMapping
    public Iterable<Employee> employees() {
        return employeeRepository.findAll();
    }

    @QueryMapping
    public Employee employee(@Argument Integer id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @MutationMapping
    public Employee newEmployee(@Argument EmployeeInput employee) {
        Department department = departmentRepository
                .findById(employee.getDepartmentId()).get();
        Organization organization = organizationRepository
                .findById(employee.getOrganizationId()).get();
        return employeeRepository.save(new Employee(null, employee.getFirstName(), employee.getLastName(),
                employee.getPosition(), employee.getAge(), employee.getSalary(),
                department, organization));
    }

    @QueryMapping
    public Iterable<Employee> employeesWithFilter(@Argument EmployeeFilter filter) {
        Specification<Employee> spec = null;
        if (filter.getSalary() != null) {
            spec = bySalary(filter.getSalary());
        }
        if (filter.getAge() != null) {
            spec = (spec == null ? byAge(filter.getAge()) : spec.and(byAge(filter.getAge())));
        }
        if (filter.getPosition() != null) {
            spec = (spec == null ? byPosition(filter.getPosition()) :
                    spec.and(byPosition(filter.getPosition())));
        }
        if (spec != null) {
            return employeeRepository.findAll(spec);
        } else {
            return employeeRepository.findAll();
        }
    }

    @QueryMapping
    public List<Map<String, Object>> employeePart(DataFetchingEnvironment env) {
        DataFetchingFieldSelectionSet selectionSet = env.getSelectionSet();
        List<SelectedField> fields = selectionSet.getFields();
        for (SelectedField field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getAlias());
            System.out.println(field.getObjectTypes());
        }
        return employeeMapper.findE();
    }

    private Specification<Employee> bySalary(FilterField filterField) {
        return (root, query, builder) -> filterField
                .generateCriteria(builder, root.get("salary"));
    }

    private Specification<Employee> byAge(FilterField filterField) {
        return (root, query, builder) -> filterField
                .generateCriteria(builder, root.get("age"));
    }

    private Specification<Employee> byPosition(FilterField filterField) {
        return (root, query, builder) -> filterField
                .generateCriteria(builder, root.get("position"));
    }
}
