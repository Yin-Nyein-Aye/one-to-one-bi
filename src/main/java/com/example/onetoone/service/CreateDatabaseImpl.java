package com.example.onetoone.service;

import com.example.onetoone.domain.Address;
import com.example.onetoone.domain.Customer;
import com.example.onetoone.repository.AddressRepository;
import com.example.onetoone.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateDatabaseImpl implements ICreateDatabase {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Override
    @Transactional
    public void createDatabase(){

        Customer c1 = new Customer("Yin Nyein",24);
        Customer c2 = new Customer("Yee Mon",23);

        Address address1 = new Address("Kyun Chan 1 Street","12345");
        Address address2 = new Address("Kyun Chan 2 Street","45678");

        c1.setAddress(address2);
        address2.setCustomer(c1);
        c2.setAddress(address1);
        address1.setCustomer(c2);

        addressRepository.save(address1);
        addressRepository.save(address2);
        customerRepository.save(c1);
        customerRepository.save(c2);


    }


}
