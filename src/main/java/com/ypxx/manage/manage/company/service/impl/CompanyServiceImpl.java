package com.ypxx.manage.manage.company.service.impl;

import com.ypxx.manage.manage.company.dao.ICompanyRepository;
import com.ypxx.manage.manage.company.entity.Company;
import com.ypxx.manage.manage.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: 后羿
 * Date: 2018/10/10
 * Time: 13:40
 * To change this template use File | Settings | File Templates.
 * Description: CompanyServiceImpl
 */
@Transactional
@Service
public class CompanyServiceImpl implements CompanyService {

   /* @Resource
    private ICompanyRepository iCompanyRepository;

    @Override
    public List<Company> getCompanyList() {
        return iCompanyRepository.findAll();
    }

    *//*@Override
    public Company findCompanyById(long id) {
        return iCompanyRepository.findById(id);
    }*//*

    @Override
    public void save(Company company) {
        iCompanyRepository.save(company);
    }

    @Override
    public void edit(Company company) {
        iCompanyRepository.save(company);
    }

    @Override
    public void delete(long id) {
        iCompanyRepository.deleteById(id);
    }*/

    private final ICompanyRepository iCompanyRepository;

    @Autowired
    public CompanyServiceImpl(ICompanyRepository iCompanyRepository) {
        this.iCompanyRepository = iCompanyRepository;
    }

    @Override
    public Page<Company> page(Integer pageNum, Integer pageSize, Date start, Date end, String companyTitle, Long userId) {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<Company> specification = (Specification<Company>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (userId != null) {
                predicates.add(criteriaBuilder.equal(root.get("createId"), userId));
            }
            if (companyTitle != null && !"".equals(companyTitle)) {
                predicates.add(criteriaBuilder.like(root.get("companyTitle"), "%" + companyTitle + "%"));
            }
            if (start != null && end != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createTime"), start));
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime"), end));
            }
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return iCompanyRepository.findAll(specification, pageable);
    }

    @Override
    public Company delete(Long id) {
        if (null == id) return null;
        Company type = iCompanyRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setDel(1);
        return iCompanyRepository.save(type);
    }

    @Override
    public Company add(Company company) {
        return iCompanyRepository.save(company);
    }

    @Override
    public Company findById(Long id) {
        if (null == id) return null;
        Specification<Company> specification = (Specification<Company>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("id"), id));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Optional<Company> type = iCompanyRepository.findOne(specification);
        return type.orElse(null);
    }

    @Override
    public Company edit(Company enterprise) {
        if (enterprise.getId() == null) return null;
        Company entity = iCompanyRepository.getOne(enterprise.getId());
        entity.setCompanyTitle(enterprise.getCompanyTitle());
        entity.setCompanyDescription(enterprise.getCompanyDescription());
        if (!"".equals(enterprise.getCompanyPicture())){
            entity.setCompanyPicture(enterprise.getCompanyPicture());
        }
        return iCompanyRepository.save(entity);
    }


    @Override
    public Company findByStates() {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Specification<Company> specification = (Specification<Company>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("states"), 1));
            predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        List<Company> entities = iCompanyRepository.findAll(specification, sort);
        if (entities.isEmpty()) {
            Specification<Company> specification1 = (Specification<Company>) (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("states"), 0));
                predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
                predicates.add(criteriaBuilder.equal(root.get("del"), 0));
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
            List<Company> entities1 = iCompanyRepository.findAll(specification1, sort);
            return entities1.get(0);
        };
        return entities.get(0);
    }

    @Override
    public List<Company> listByThree() {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Pageable pageable = PageRequest.of(0, 100, sort);
        Specification<Company> specification = (Specification<Company>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("states"), 0));
            predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Page<Company> page = iCompanyRepository.findAll(specification, pageable);
        if (page == null) return null;
        return page.getContent();
    }

    @Override
    public Company updateShow(Long id,Integer show) {
        if (null == show || null == id) return null;
        Company type = iCompanyRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setIsShow(show);
        return iCompanyRepository.save(type);
    }

    @Override
    public Company updateStates(Long id, Integer states) {
        if (null == id || null == states) return null;
        Company type = iCompanyRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setStates(states);
        return iCompanyRepository.save(type);
    }
}
