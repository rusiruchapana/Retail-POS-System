package com.rusiruchapana.pos.service.impl;

import com.rusiruchapana.pos.dto.CustomerDTO;
import com.rusiruchapana.pos.dto.request.CustomerUpdateRequest;
import com.rusiruchapana.pos.entity.Customer;
import com.rusiruchapana.pos.repo.CustomerRepo;
import com.rusiruchapana.pos.service.CustomerService;
import javassist.NotFoundException;
import org.hibernate.internal.util.collections.ArrayHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAdress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNicNumber(),
                customerDTO.getContactNumbers(),
                customerDTO.getActiveStatus()
        );
        customerRepo.save(customer);

        return customerDTO;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerUpdateRequest customerUpdateRequest) {

        if (customerRepo.existsById(customerUpdateRequest.getCustomerId())) {
            Customer customer = customerRepo.getById(customerUpdateRequest.getCustomerId());
            customer.setCustomerName(customerUpdateRequest.getCustomerName());
            customer.setCustomerAdress(customerUpdateRequest.getCustomerAdress());
            customer.setCustomerSalary(customer.getCustomerSalary());
            customer.setNicNumber(customerUpdateRequest.getNicNumber());
            customer.setContactNumbers(customerUpdateRequest.getContactNumbers());
            customer.setActiveStatus(customerUpdateRequest.getActiveStatus());

            customerRepo.save(customer);

            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAdress(),
                    customer.getCustomerSalary(),
                    customer.getNicNumber(),
                    customer.getContactNumbers(),
                    customer.getActiveStatus()
            );

            return customerDTO;
        } else {
            return null;
        }


    }

    @Override
    public CustomerDTO getCustomer(Long id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);

        if (customerOptional.isPresent()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customerOptional.get().getCustomerId(),
                    customerOptional.get().getCustomerName(),
                    customerOptional.get().getCustomerAdress(),
                    customerOptional.get().getCustomerSalary(),
                    customerOptional.get().getNicNumber(),
                    customerOptional.get().getContactNumbers(),
                    customerOptional.get().getActiveStatus()
            );
            return customerDTO;
        } else {
            return null;
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        if (!customerList.isEmpty()) {
            for (int i = 0; i < customerList.size(); i++) {
                CustomerDTO customerDTO = new CustomerDTO(
                        customerList.get(i).getCustomerId(),
                        customerList.get(i).getCustomerName(),
                        customerList.get(i).getCustomerAdress(),
                        customerList.get(i).getCustomerSalary(),
                        customerList.get(i).getNicNumber(),
                        customerList.get(i).getContactNumbers(),
                        customerList.get(i).getActiveStatus()
                );
                customerDTOList.add(customerDTO);
            }
            return customerDTOList;
        } else {
            return null;
        }
    }


    @Override
    public Boolean deleteCustomer(Long id) throws NotFoundException {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
            return true;
        }else{
            throw new NotFoundException("Customer Not found in the database in that id.");
        }
    }
}

