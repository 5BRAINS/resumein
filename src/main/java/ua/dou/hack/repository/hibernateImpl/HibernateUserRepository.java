package ua.dou.hack.repository.hibernateImpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ua.dou.hack.domain.User;
import ua.dou.hack.repository.UserRepository;
import ua.dou.hack.repository.common.GenericRepositoryHibernateImpl;

/**
 * mocker on 21.02.15 at 18:05.
 */
@Repository
public class HibernateUserRepository
        extends GenericRepositoryHibernateImpl<User, Integer>
        implements UserRepository {
    public HibernateUserRepository() {
        setType(User.class);
    }

    @Override
    public User find(int userId) {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id", userId));
        return (User) criteria.uniqueResult();
    }

    @Override
    public User findByToken(String accessToken) {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("token", accessToken));
        return (User) criteria.uniqueResult();
    }
}
