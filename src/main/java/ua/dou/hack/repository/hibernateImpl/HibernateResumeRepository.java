package ua.dou.hack.repository.hibernateImpl;

import org.springframework.stereotype.Repository;
import ua.dou.hack.domain.Resume;
import ua.dou.hack.repository.ResumeRepository;
import ua.dou.hack.repository.common.GenericRepositoryHibernateImpl;

/**
 * mocker on 22.02.15 at 2:17.
 */
@Repository
public class HibernateResumeRepository
        extends GenericRepositoryHibernateImpl<Resume, Integer>
        implements ResumeRepository {
    public HibernateResumeRepository() {
        setType(Resume.class);
    }
}
