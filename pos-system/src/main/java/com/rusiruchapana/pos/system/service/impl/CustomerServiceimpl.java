package com.rusiruchapana.pos.system.service.impl;

import com.rusiruchapana.pos.system.dto.request.CustomerNameRequestByQueryDTO;
import com.rusiruchapana.pos.system.dto.request.CustomerRequestDTO;
import com.rusiruchapana.pos.system.dto.request.CustomerSpecificDetailsRequestDTO;
import com.rusiruchapana.pos.system.dto.response.CustomerNameResponseDTO;
import com.rusiruchapana.pos.system.dto.response.CustomerResponseDTO;
import com.rusiruchapana.pos.system.dto.response.CustomerSpecificDetailsResponseDTO;
import com.rusiruchapana.pos.system.entity.Customer;
import com.rusiruchapana.pos.system.exception.NotFoundException;
import com.rusiruchapana.pos.system.repository.CustomerRepo;
import com.rusiruchapana.pos.system.service.CustomerService;
import com.rusiruchapana.pos.system.util.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceimpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer();
        customer.setName(customerRequestDTO.getName());
        customer.setAdress(customerRequestDTO.getAdress());
        customer.setSalary(customerRequestDTO.getSalary());
        customer.setContactNumbers(customerRequestDTO.getContactNumbers());
        customer.setNic(customerRequestDTO.getNic());
        customer.setActiveStatus(customerRequestDTO.getActiveStatus());

        customerRepo.save(customer);

        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setId(customer.getId());
        customerResponseDTO.setName(customer.getName());
        customerResponseDTO.setAdress(customer.getAdress());
        customerResponseDTO.setSalary(customer.getSalary());
        customerResponseDTO.setContactNumbers(customer.getContactNumbers());
        customerResponseDTO.setNic(customer.getNic());
        customerResponseDTO.setActiveStatus(customer.getActiveStatus());

        return customerResponseDTO;
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        List<CustomerResponseDTO> customerResponseDTOList = customerMapper.entityToDto(customers);
        return customerResponseDTOList;
    }

    @Override
    public String deleteCustomer(Long id) {
        customerRepo.deleteById(id);
        return "deleted customer.";
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO, Long id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        Customer customer = customerOptional.get();

        customer.setName(customerRequestDTO.getName());
        customer.setAdress(customerRequestDTO.getAdress());
        customer.setSalary(customerRequestDTO.getSalary());
        customer.setContactNumbers(customerRequestDTO.getContactNumbers());
        customer.setNic(customerRequestDTO.getNic());
        customer.setActiveStatus(customerRequestDTO.getActiveStatus());

        customerRepo.save(customerOptional.get());

        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setId(customer.getId());
        customerResponseDTO.setName(customer.getName());
        customerResponseDTO.setAdress(customer.getAdress());
        customerResponseDTO.setSalary(customer.getSalary());
        customerResponseDTO.setContactNumbers(customer.getContactNumbers());
        customerResponseDTO.setNic(customer.getNic());
        customerResponseDTO.setActiveStatus(customer.getActiveStatus());

        return customerResponseDTO;
    }

    @Override
    public List<CustomerResponseDTO> getActiveCustomers() {
        List<Customer> customers = customerRepo.findAllByActiveStatus(true);
        return customerMapper.entityToDto(customers);
    }

    @Override
    public List<CustomerNameResponseDTO> getActiveCustomersNames() {
        List<Customer> customers = customerRepo.findAllByActiveStatus(true);
        List<CustomerNameResponseDTO> customerNameResponseDTOS1 = new ArrayList<>();

        for(int i=0; i<customers.size(); i++){
            CustomerNameResponseDTO customerNameResponseDTO2 = new CustomerNameResponseDTO();
            customerNameResponseDTO2.setName(customers.get(i).getName());
            customerNameResponseDTO2.setContactNumbers(customers.get(i).getContactNumbers());
            customerNameResponseDTOS1.add(customerNameResponseDTO2);
        }
        return customerNameResponseDTOS1;
    }

    @Override
    public String updateCustomersByQuery(CustomerNameRequestByQueryDTO customerNameRequestByQueryDTO, Long id) {
        customerRepo.updateCustomersUsingQuery(customerNameRequestByQueryDTO.getName(), customerNameRequestByQueryDTO.getNic(), id);
        return "Updated succesfully.";
    }

    @Override
    public CustomerResponseDTO getCustomersByNic(String nic) {
        Optional<Customer> customer = customerRepo.findByNicEquals(nic);
        if(customer.isPresent()){
            CustomerResponseDTO customerResponseDTO = customerMapper.entityToDto(customer.get());
            return customerResponseDTO;
        }else{
            throw new NotFoundException("Not found this NIC.");
        }

    }

    @Override
    public CustomerSpecificDetailsResponseDTO getDetails(Long id) {
        Optional<Customer> customer = customerRepo.findByIdEquals(id);
        if(customer.isPresent()){
            CustomerSpecificDetailsResponseDTO customerSpecificDetailsResponseDTO = customerMapper.entityToSpecialDto(customer.get());
            return customerSpecificDetailsResponseDTO;
        }else{
            throw new NotFoundException("Not found this.");
        }
    }

    @Override
    public void updateSpecificCustomerDetails(CustomerSpecificDetailsRequestDTO customerSpecificDetailsRequestDTO, Long id) {
        Optional<Customer> customer = customerRepo.findByIdEquals(id);
        Customer customer1 = customer.get();
        if (customer.isPresent()){
            CustomerSpecificDetailsRequestDTO customerSpecificDetailsRequestDTO1 = new CustomerSpecificDetailsRequestDTO();
            customerSpecificDetailsRequestDTO1.setName(customerSpecificDetailsRequestDTO.getName());
            customerSpecificDetailsRequestDTO1.setSalary(customerSpecificDetailsRequestDTO.getSalary());
            customerSpecificDetailsRequestDTO1.setNic(customerSpecificDetailsRequestDTO.getNic());
        }else {
            throw new NotFoundException("Not Found.");
        }
    }

    @Override
    public String findActiveOrNot(Long id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        Customer customer = customerOptional.get();
        if(customer.getActiveStatus()==true){
            return "Customer is activated.";
        }else{
            return "Customer is not activated.";
        }
    }


}
