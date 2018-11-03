package com.ypxx.manage.manage.customer.service.impl;

import com.ypxx.manage.manage.customer.dao.ICustomerRepository;
import com.ypxx.manage.manage.customer.dao.ICustomerRepository;
import com.ypxx.manage.manage.customer.entity.Customer;
import com.ypxx.manage.manage.customer.service.CustomerInfoService;
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
 * Description: CustomerServiceImpl
 */
@Transactional
@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {


    private final ICustomerRepository iCustomerRepository;

    @Autowired
    public CustomerInfoServiceImpl(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public Page<Customer> page(Integer pageNum, Integer pageSize, Date start, Date end, String customerName, Long userId) {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<Customer> specification = (Specification<Customer>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (userId != null) {
                predicates.add(criteriaBuilder.equal(root.get("createId"), userId));
            }
            if (customerName != null && !"".equals(customerName)) {
                predicates.add(criteriaBuilder.like(root.get("customerName"), "%" + customerName + "%"));
            }
            if (start != null && end != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createTime"), start));
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime"), end));
            }
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return iCustomerRepository.findAll(specification, pageable);
    }

    @Override
    public Customer delete(Long id) {
        if (null == id) return null;
        Customer type = iCustomerRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setDel(1);
        return iCustomerRepository.save(type);
    }

    @Override
    public Customer add(Customer job) {
        return iCustomerRepository.save(job);
    }

    @Override
    public Customer findById(Long id) {
        if (null == id) return null;
        Specification<Customer> specification = (Specification<Customer>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("id"), id));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Optional<Customer> type = iCustomerRepository.findOne(specification);
        return type.orElse(null);
    }

    @Override
    public Customer edit(Customer enterprise) {
        if (enterprise.getId() == null) return null;
        Customer entity = iCustomerRepository.getOne(enterprise.getId());
        /*entity.setCustomerName(enterprise.getCustomerName());
        entity.setCustomerDictate(enterprise.getCustomerDictate());
        entity.setCustomerDept(enterprise.getCustomerDept());
        entity.setCustomerLocation(enterprise.getCustomerLocation());
        entity.setCustomerYear(enterprise.getCustomerYear());*/
        return iCustomerRepository.save(entity);
    }


    @Override
    public Customer findByStates() {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Specification<Customer> specification = (Specification<Customer>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("states"), 1));
            predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        List<Customer> entities = iCustomerRepository.findAll(specification, sort);
        if (entities.isEmpty()) {
            Specification<Customer> specification1 = (Specification<Customer>) (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("states"), 0));
                predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
                predicates.add(criteriaBuilder.equal(root.get("del"), 0));
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
            List<Customer> entities1 = iCustomerRepository.findAll(specification1, sort);
            return entities1.get(0);
        };
        return entities.get(0);
    }

    @Override
    public List<Customer> listByThree() {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Pageable pageable = PageRequest.of(0, 100, sort);
        Specification<Customer> specification = (Specification<Customer>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("states"), 0));
            predicates.add(criteriaBuilder.equal(root.get("isShow"), 1));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Page<Customer> page = iCustomerRepository.findAll(specification, pageable);
        if (page == null) return null;
        return page.getContent();
    }

    @Override
    public Customer updateShow(Long id, Integer show) {
        if (null == show || null == id) return null;
        Customer type = iCustomerRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setIsShow(show);
        return iCustomerRepository.save(type);
    }

    @Override
    public Customer updateStates(Long id, Integer states) {
        if (null == id || null == states) return null;
        Customer type = iCustomerRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setStates(states);
        return iCustomerRepository.save(type);
    }
}
