package live.cloverescape.graphqldgs.dataloader;

import com.netflix.graphql.dgs.DgsDataLoader;
import live.cloverescape.graphqldgs.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.MappedBatchLoader;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletionStage;

/**
 * 解决 N+1 问题的 dataloader
 * @author weibb
 */
@Slf4j
@DgsDataLoader(name = "users")
public class UserDataLoader implements MappedBatchLoader<Integer, List<User>> {

    @Override
    public CompletionStage<Map<Integer, List<User>>> load(Set<Integer> keys) {
        return null;
    }
}
