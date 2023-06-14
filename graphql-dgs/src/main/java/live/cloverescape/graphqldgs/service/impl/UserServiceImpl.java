package live.cloverescape.graphqldgs.service.impl;

import live.cloverescape.graphqldgs.entity.User;
import live.cloverescape.graphqldgs.mapper.UserMapper;
import live.cloverescape.graphqldgs.service.IUserService;
import live.cloverescape.graphqldgs.tool.JpaExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weibb
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;

    private final JpaExecutor jpaExecutor;

    @Override
    public List<User> listUsers() {
        return userMapper.selectList(null);
    }
}
