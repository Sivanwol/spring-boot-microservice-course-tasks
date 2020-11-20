package test.sivan.section4.section4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import test.sivan.section4.section4.data.CustomerDto;
import test.sivan.section4.section4.service.CustomerService;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
//import static org.mockito.BDDMockito.then;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.UUID;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @MockBean
    CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    CustomerDto validCustomerDto;


    @Before
    public void setUp() {
        validCustomerDto = CustomerDto.builder().id(UUID.randomUUID())
                .name("test")
                .build();
    }


    @Test
    public void getCustomer() throws Exception {
        given(customerService.GetCustomer(any(UUID.class))).willReturn(validCustomerDto);

        mockMvc.perform(get("/api/customer/" + validCustomerDto.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(validCustomerDto.getId().toString())))
                .andExpect(jsonPath("$.name", is("test")));
    }


}
