package test.sivan.section4.section4.service;

import test.sivan.section4.section4.data.CustomerDto;

import java.util.UUID;

public interface ICustomerService {
    CustomerDto GetCustomer(UUID customerId);
}
