package live.cloverescape.graphqldgs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author weibb
 */
@SpringBootApplication
@MapperScan("live.cloverescape.graphqldgs.mapper")
public class GraphqlDgsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraphqlDgsApplication.class, args);
    }
}
