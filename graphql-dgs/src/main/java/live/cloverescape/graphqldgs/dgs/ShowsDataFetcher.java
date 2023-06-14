package live.cloverescape.graphqldgs.dgs;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import graphql.GraphQLContext;
import graphql.execution.ExecutionStepInfo;
import graphql.schema.DataFetchingFieldSelectionSet;
import live.cloverescape.graphqldgs.entity.Show;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author seven
 */
@Slf4j
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
                    log.info(selectedField.getObjectTypes().toString());
                    log.info(selectedField.getName());
                });
        log.info(env.getGraphQlContext().toString());
        log.info(env.getArguments().toString());
        log.info(env.getRoot());
        log.info(env.getSource());
        log.info("\n" + env.getExecutionStepInfo());

        if (titleFilter == null) {
            return shows;
        }

        return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }
}

