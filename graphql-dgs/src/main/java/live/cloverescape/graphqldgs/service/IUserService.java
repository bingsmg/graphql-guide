package live.cloverescape.graphqldgs.service;

import live.cloverescape.graphqldgs.entity.User;

import java.util.List;

/**
 * @author weibb
 */
public interface IUserService {

    List<User> listUsers();
}
