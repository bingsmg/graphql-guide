package live.cloverescape.graphqldgs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import live.cloverescape.graphqldgs.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author weibb
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}