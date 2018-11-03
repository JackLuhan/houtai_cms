package com.ypxx.manage.manage.news.service.impl;

import com.ypxx.manage.manage.news.entity.EnterpriseEntity;
import com.ypxx.manage.manage.news.repository.IEnterpriseRepository;
import com.ypxx.manage.manage.news.service.IEnterpriseService;
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
 * Created by xuwei on 2018/10/5.
 */
@Service
@Transactional
public class EnterpriseServiceImpl implements IEnterpriseService {

    private final IEnterpriseRepository enterpriseRepository;

    @Autowired
    public EnterpriseServiceImpl(IEnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    //新闻资讯列表
    @Override
    public Page<EnterpriseEntity> page(Integer pageNum, Integer pageSize, Date start, Date end, String title, Long userId) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<EnterpriseEntity> specification = (Specification<EnterpriseEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (userId != null) {
                predicates.add(criteriaBuilder.equal(root.get("createId"), userId));
            }
            if (title != null && !"".equals(title)) {
                predicates.add(criteriaBuilder.like(root.get("title"), "%" + title + "%"));
            }
            if (start != null && end != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createTime"), start));
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime"), end));
            }
            predicates.add(criteriaBuilder.equal(root.get("picturenewstag"), "0"));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return enterpriseRepository.findAll(specification, pageable);
    }


    @Override
    public Page<EnterpriseEntity> page(Integer pageNum, Integer pageSize, Date start, Date end, String title, Long userId, String picturenewstag) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<EnterpriseEntity> specification = (Specification<EnterpriseEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (picturenewstag != null) {
                predicates.add(criteriaBuilder.equal(root.get("picturenewstag"), picturenewstag));
            }
            if (userId != null) {
                predicates.add(criteriaBuilder.equal(root.get("createId"), userId));
            }
            if (title != null && !"".equals(title)) {
                predicates.add(criteriaBuilder.like(root.get("title"), "%" + title + "%"));
            }
            if (start != null && end != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createTime"), start));
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime"), end));
            }
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return enterpriseRepository.findAll(specification, pageable);
    }

    @Override
    public EnterpriseEntity delete(Long id) {
        if (null == id) return null;
        EnterpriseEntity type = enterpriseRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setDel(1);
        return enterpriseRepository.save(type);
    }

    @Override
    public EnterpriseEntity add(EnterpriseEntity enterprise) {
        return enterpriseRepository.save(enterprise);
    }


    @Override
    public EnterpriseEntity findById(Long id) {
        if (null == id) return null;
        Specification<EnterpriseEntity> specification = (Specification<EnterpriseEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("id"), id));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Optional<EnterpriseEntity> type = enterpriseRepository.findOne(specification);
        return type.orElse(null);
    }

    @Override
    public EnterpriseEntity edit(EnterpriseEntity enterprise) {
        if (enterprise.getId() == null) return null;
        EnterpriseEntity entity = enterpriseRepository.getOne(enterprise.getId());
        entity.setTitle(enterprise.getTitle());
        entity.setContent(enterprise.getContent());
        if (!"".equals(enterprise.getPicture())) entity.setPicture(enterprise.getPicture());
        if (enterprise.getType() != null && !enterprise.getType().trim().equals("")) {
            entity.setType(enterprise.getType());
        }
        if (enterprise.getPicturenewslocation() != null && !enterprise.getPicturenewslocation().trim().equals("")) {
            entity.setPicturenewslocation(enterprise.getPicturenewslocation());
        }
        if (enterprise.getIndextype() != null && !enterprise.getIndextype().trim().equals("")) {
            entity.setIndextype(enterprise.getIndextype());
        }

        return enterpriseRepository.save(entity);
    }


    @Override
    public EnterpriseEntity findByStates() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Specification<EnterpriseEntity> specification = (Specification<EnterpriseEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("states"), 1));
            predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            predicates.add(criteriaBuilder.equal(root.get("picturenewstag"), "0"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        List<EnterpriseEntity> entities = enterpriseRepository.findAll(specification, sort);
        if (entities.isEmpty()) {
            Specification<EnterpriseEntity> specification1 = (Specification<EnterpriseEntity>) (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("states"), 0));
                predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
                predicates.add(criteriaBuilder.equal(root.get("del"), 0));
                predicates.add(criteriaBuilder.equal(root.get("picturenewstag"), "0"));

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
            List<EnterpriseEntity> entities1 = enterpriseRepository.findAll(specification1, sort);
            return entities1.get(0);
        }
        return entities.get(0);
    }

    @Override
    public EnterpriseEntity findByStates(String type) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Specification<EnterpriseEntity> specification = (Specification<EnterpriseEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.equal(root.get("type"), type));
            predicates.add(criteriaBuilder.equal(root.get("states"), 1));
            predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            predicates.add(criteriaBuilder.equal(root.get("picturenewstag"), "0"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        List<EnterpriseEntity> entities = enterpriseRepository.findAll(specification, sort);
        if (entities.isEmpty()) {
            Specification<EnterpriseEntity> specification1 = (Specification<EnterpriseEntity>) (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();

                predicates.add(criteriaBuilder.equal(root.get("type"), type));
                predicates.add(criteriaBuilder.equal(root.get("states"), 0));
                predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
                predicates.add(criteriaBuilder.equal(root.get("del"), 0));
                predicates.add(criteriaBuilder.equal(root.get("picturenewstag"), "0"));

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
            List<EnterpriseEntity> entities1 = enterpriseRepository.findAll(specification1, sort);
            if (entities1 != null && entities1.size() != 0) {
                return entities1.get(0);
            } else {
                return null;
            }
        }
        if (entities != null && entities.size() != 0) {
            return entities.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<EnterpriseEntity> listByThree() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(0, 3, sort);
        Specification<EnterpriseEntity> specification = (Specification<EnterpriseEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("states"), 0));
            predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            predicates.add(criteriaBuilder.equal(root.get("picturenewstag"), "0"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Page<EnterpriseEntity> page = enterpriseRepository.findAll(specification, pageable);
        if (page == null) return null;
        return page.getContent();
    }

    @Override
    public List<EnterpriseEntity> listByThree(String type) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(0, 3, sort);
        Specification<EnterpriseEntity> specification = (Specification<EnterpriseEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.equal(root.get("type"), type));
            predicates.add(criteriaBuilder.equal(root.get("states"), 0));
            predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            predicates.add(criteriaBuilder.equal(root.get("picturenewstag"), "0"));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Page<EnterpriseEntity> page = enterpriseRepository.findAll(specification, pageable);
        if (page == null) return null;
        return page.getContent();
    }

    @Override
    public List<EnterpriseEntity> indexListByFour(String indextype) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(0, 4, sort);
        Specification<EnterpriseEntity> specification = (Specification<EnterpriseEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.equal(root.get("indextype"), indextype));
            predicates.add(criteriaBuilder.equal(root.get("states"), 0));
            predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Page<EnterpriseEntity> page = enterpriseRepository.findAll(specification, pageable);
        if (page == null) return null;
        return page.getContent();
    }

    @Override
    public Page<EnterpriseEntity> getPicture(String type, String place) {

        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(1 - 1, 10, sort);
        Specification<EnterpriseEntity> specification = (Specification<EnterpriseEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("picturenewstag"), "1"));
            predicates.add(criteriaBuilder.equal(root.get("type"), type));
            predicates.add(criteriaBuilder.equal(root.get("picturenewslocation"), place));

            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return enterpriseRepository.findAll(specification, pageable);

    }

    @Override
    public EnterpriseEntity updateShow(Long id, Integer show) {
        if (null == show || null == id) return null;
        EnterpriseEntity type = enterpriseRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setIsShow(show);
        return enterpriseRepository.save(type);
    }

    @Override
    public EnterpriseEntity updateStates(Long id, Integer states) {
        if (null == id || null == states) return null;
        EnterpriseEntity type = enterpriseRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setStates(states);
        return enterpriseRepository.save(type);
    }
}
