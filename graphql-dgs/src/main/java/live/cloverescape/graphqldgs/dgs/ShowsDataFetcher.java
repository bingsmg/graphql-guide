package live.cloverescape.graphqldgs.dgs;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import graphql.GraphQLContext;
import graphql.execution.ExecutionStepInfo;
import graphql.schema.DataFetchingFieldSelectionSet;
import live.cloverescape.graphqldgs.entity.Show;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author seven
 */
@DgsComponent
public class ShowsDataFetcher {
    private final List<Show> shows = List.of(
            new Show("Stranger Things", 2016),
            new Show("Ozark", 2017),
            new Show("The Crown", 2016),
            new Show("Dead to Me", 2019),
            new Show("Orange is the New Black", 2013)
    );

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter, DgsDataFetchingEnvironment env) {
        DataFetchingFieldSelectionSet selectionSet = env.getSelectionSet();
        selectionSet.getFields().forEach(
                selectedField -> {
                    System.out.println(selectedField.getObjectTypes());
                    System.out.println(selectedField.getName());
                });
        GraphQLContext graphQlContext = env.getGraphQlContext();
        Object source = env.getSource();
        Object root = env.getRoot();
        Map<String, Object> arguments = env.getArguments();
        ExecutionStepInfo executionStepInfo = env.getExecutionStepInfo();

        if (titleFilter == null) {
            return shows;
        }

        return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }
}

