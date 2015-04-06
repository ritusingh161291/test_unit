package org.suda.customerMgr.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.commons.collections.functors.TruePredicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Spy;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.suda.customerMgr.dao.api.CustomerDAO;
import org.suda.customerMgr.domain.Customer;
import org.suda.customerMgr.service.api.CustomerService;






public class CustomerControllerTest {
	
  @Mock
  CustomerService customerService;

  @Mock
  BindingResult result;
 
  
  @InjectMocks
  CustomerController customerController=new CustomerController();
  
  
  Customer customer;
  
  @Before public void initMocks() {
      MockitoAnnotations.initMocks(this);
      
      customer = new Customer();
      customer.setEmail("xyz@gmail.com");
      customer.setFirstname("ritu");
      customer.setLastname("singh");
      
  }
  
//  
//  @Test
//  public void testAddEmployee() throws Exception {
//   
//  	CustomerDAO customerdao=mock(CustomerDAO.class);
//     when(customerService).addCustomer(any(Customer.class));
//      System.out.println(customerController.addCustomer(customer, null));
//      
//  }
  
  @Test
  public void testDeleteCustomer()
  {
	  doNothing().when(customerService).removeCustomer(anyInt());
	  assertEquals("redirect:/list",customerController.deleteCustomer(105));
  }
	
  @Test
  public void testListContacts() throws Exception
  {
	  List<Customer> listcust=new ArrayList<Customer>();
    
    listcust.add(customer);
    
    when(customerService.listCustomer()).thenReturn(listcust);
    
    Map<String,Object> map=new HashMap<String,Object>();
  
    map.put("customer", customer);
    
    map.put("customerList",customerService.listCustomer() );
    System.out.println(map);
    customerController.listCustomer(map);
    customerController.loadAddCustomer(map);
    
    
  	//doNothing().when(employeeService).deleteEmployee(anyInt());
  	//assertEquals("redirect:/list",employeeController.deleteEmplyee(101));
   //assertEquals(2,map.size());
   // assertEquals("list",customerController.listCustomer(map));
  }
  
 @Test
 public void addCustomerTest()
 {
	// when(result.hasErrors()).thenReturn(anyBoolean());
    //verify(result).hasErrors();
	 
	
	 assertEquals("redirect:/add",customerController.addCustomer(customer, result));
	 
	 
 }
 
 
 }
	
	

