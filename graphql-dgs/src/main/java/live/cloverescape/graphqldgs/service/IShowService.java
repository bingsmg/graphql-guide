package live.cloverescape.graphqldgs.service;

import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import live.cloverescape.graphqldgs.entity.Show;

import java.util.List;

/**
 * @author weibb
 */
public interface IShowService {

    List<Show> listShows(String titleFilter, DgsDataFetchingEnvironment env);
}
