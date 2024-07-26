package com.rusiruchapana.pos.service.impl;

import com.rusiruchapana.pos.dto.CustomerDTO;
import com.rusiruchapana.pos.entity.Customer;
import com.rusiruchapana.pos.repo.CustomerRepo;
import com.rusiruchapana.pos.service.CustomerService;
import com.rusiruchapana.pos.util.CustomerMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerMapper customerMapper;

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
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) throws NotFoundException {


            Optional<Customer> customer = customerRepo.findById(customerDTO.getCustomerId());
            Customer customer1 = customer.get();
            if (customer.isPresent()) {
                customer1.setCustomerName(customerDTO.getCustomerName());
                customer1.setCustomerAdress(customerDTO.getCustomerAdress());
                customer1.setCustomerSalary(customerDTO.getCustomerSalary());
                customer1.setNicNumber(customerDTO.getNicNumber());
                customer1.setContactNumbers(customerDTO.getContactNumbers());
                customer1.setActiveStatus(customerDTO.getActiveStatus());

                customerRepo.save(customer1);

                return customerMapper.entity_to_dto(customer1);
            }
            else {
                throw new NotFoundException("There are not customers for that customer id.");
            }
    }





    @Override
    public CustomerDTO getCustomer(Long id) throws NotFoundException {
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
            throw new NotFoundException("No suitable customer in the database for this id.");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws NotFoundException {
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
            throw new NotFoundException("There are no customers in the database.");
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


    @Override
    public List<CustomerDTO> find_by_names(String name) throws NotFoundException {

        List<Customer> customerList = customerRepo.findAllByCustomerName(name);
        if(customerList.size()>0){
            List<CustomerDTO> customerDTOList = customerMapper.entity_to_dto(customerList);
            return customerDTOList;
        }else{
            throw new NotFoundException("There is not name matching for the database.");
        }


    }

    @Override
    public List<CustomerDTO> getActiveCustomers() throws NotFoundException {
        List<Customer> customerList = customerRepo.findAllByActiveStatus(true);
        if(!customerList.isEmpty()){
            List<CustomerDTO> customerDTOList = customerMapper.entity_to_dto(customerList);
            return customerDTOList;
        }else{
            throw new NotFoundException("There are no suitable customers in the database.");
        }


    }
}

