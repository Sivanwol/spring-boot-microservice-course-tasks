package test.sivan.section4.section4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.sivan.section4.section4.data.CustomerDto;
import test.sivan.section4.section4.service.CustomerService;

import java.util.UUID;

@RequestMapping("/api")
@RestController
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping({"/customer/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(this.customerService.GetCustomer(customerId), HttpStatus.OK);
    }
}
