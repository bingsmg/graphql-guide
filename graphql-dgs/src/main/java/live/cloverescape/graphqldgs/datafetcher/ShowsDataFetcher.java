package live.cloverescape.graphqldgs.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import live.cloverescape.graphqldgs.entity.Show;
import live.cloverescape.graphqldgs.service.IShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author weibb
 */
@Slf4j
@DgsComponent
@RequiredArgsConstructor
public class ShowsDataFetcher {

    private final IShowService showService;

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter, DgsDataFetchingEnvironment env) {
        return showService.listShows(titleFilter, env);
    }
}

