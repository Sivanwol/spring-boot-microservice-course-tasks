package test.sivan.section4.section4.service;

import org.springframework.stereotype.Service;
import test.sivan.section4.section4.data.CustomerDto;

import java.util.UUID;

@Service
public class CustomerService implements ICustomerService {
    @Override
    public CustomerDto GetCustomer(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Test")
                .build();
    }
}
