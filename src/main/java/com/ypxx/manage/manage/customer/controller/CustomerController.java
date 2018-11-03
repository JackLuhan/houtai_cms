package com.ypxx.manage.manage.customer.controller;

import com.ypxx.manage.manage.customer.dao.ICustomerRepository;
import com.ypxx.manage.manage.customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created with IntelliJ IDEA.
 * User: 后羿
 * Date: 2018/10/12
 * Time: 11:30
 * To change this template use File | Settings | File Templates.
 * Description: CustomerController
 */
@Controller
public class CustomerController {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Customer customer) {

        Customer newCustomer = new Customer();

        newCustomer.setCustomerName(customer.getCustomerName());
        newCustomer.setCustomerWechat(customer.getCustomerWechat());
        newCustomer.setCustomerPhone(customer.getCustomerPhone());
        newCustomer.setCustomerMail(customer.getCustomerMail());
        newCustomer.setCustomerMessage(customer.getCustomerMessage());
        iCustomerRepository.save(customer);

        return "portal/contactUs";

    }


}
