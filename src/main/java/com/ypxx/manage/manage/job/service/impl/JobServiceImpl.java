package com.ypxx.manage.manage.job.service.impl;

import com.ypxx.manage.manage.job.dao.IJobRepository;
import com.ypxx.manage.manage.job.entity.Job;
import com.ypxx.manage.manage.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: 后羿
 * Date: 2018/10/10
 * Time: 13:40
 * To change this template use File | Settings | File Templates.
 * Description: JobServiceImpl
 */
@Transactional
@Service
public class JobServiceImpl implements JobService {
    

    private final IJobRepository iJobRepository;

    @Autowired
    public JobServiceImpl(IJobRepository iJobRepository) {
        this.iJobRepository = iJobRepository;
    }

    @Override
    public Page<Job> page(Integer pageNum, Integer pageSize, Date start, Date end, String jobName, Long userId) {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<Job> specification = (Specification<Job>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (userId != null) {
                predicates.add(criteriaBuilder.equal(root.get("createId"), userId));
            }
            if (jobName != null && !"".equals(jobName)) {
                predicates.add(criteriaBuilder.like(root.get("jobName"), "%" + jobName + "%"));
            }
            if (start != null && end != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createTime"), start));
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime"), end));
            }
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return iJobRepository.findAll(specification, pageable);
    }

    @Override
    public Job delete(Long id) {
        if (null == id) return null;
        Job type = iJobRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setDel(1);
        return iJobRepository.save(type);
    }

    @Override
    public Job add(Job job) {
        return iJobRepository.save(job);
    }

    @Override
    public Job findById(Long id) {
        if (null == id) return null;
        Specification<Job> specification = (Specification<Job>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("id"), id));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Optional<Job> type = iJobRepository.findOne(specification);
        return type.orElse(null);
    }

    @Override
    public Job edit(Job enterprise) {
        if (enterprise.getId() == null) return null;
        Job entity = iJobRepository.getOne(enterprise.getId());
        entity.setJobName(enterprise.getJobName());
        entity.setJobDictate(enterprise.getJobDictate());
        entity.setJobDept(enterprise.getJobDept());
        entity.setJobLocation(enterprise.getJobLocation());
        entity.setJobYear(enterprise.getJobYear());
        entity.setJobEduction(enterprise.getJobEduction());
        entity.setJobNum(enterprise.getJobNum());
        return iJobRepository.save(entity);
    }


    @Override
    public Job findByStates() {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Specification<Job> specification = (Specification<Job>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("states"), 1));
            predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        List<Job> entities = iJobRepository.findAll(specification, sort);
        if (entities.isEmpty()) {
            Specification<Job> specification1 = (Specification<Job>) (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("states"), 0));
                predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
                predicates.add(criteriaBuilder.equal(root.get("del"), 0));
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
            List<Job> entities1 = iJobRepository.findAll(specification1, sort);
            return entities1.get(0);
        };
        return entities.get(0);
    }

    @Override
    public List<Job> listByThree() {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Pageable pageable = PageRequest.of(0, 100, sort);
        Specification<Job> specification = (Specification<Job>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("states"), 0));
            predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Page<Job> page = iJobRepository.findAll(specification, pageable);
        if (page == null) return null;
        return page.getContent();
    }

    @Override
    public Job updateShow(Long id, Integer show) {
        if (null == show || null == id) return null;
        Job type = iJobRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setIsShow(show);
        return iJobRepository.save(type);
    }

    @Override
    public Job updateStates(Long id, Integer states) {
        if (null == id || null == states) return null;
        Job type = iJobRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setStates(states);
        return iJobRepository.save(type);
    }
}
