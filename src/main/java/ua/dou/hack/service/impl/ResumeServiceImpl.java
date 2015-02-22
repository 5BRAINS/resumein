package ua.dou.hack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dou.hack.domain.Resume;
import ua.dou.hack.repository.ResumeRepository;
import ua.dou.hack.repository.common.Operations;
import ua.dou.hack.service.ResumeService;
import ua.dou.hack.service.common.AbstractService;

/**
 * mocker on 22.02.15 at 2:23.
 */
@Service
@Transactional
public class ResumeServiceImpl
        extends AbstractService<Resume, Integer>
        implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    protected Operations<Resume, Integer> getRepository() {
        return resumeRepository;
    }
}
