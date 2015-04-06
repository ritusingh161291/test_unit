package org.suda.customerMgr.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import java.io.Serializable;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.suda.customerMgr.controller.CustomerController;
import org.suda.customerMgr.dao.api.CustomerDAO;
import org.suda.customerMgr.domain.Customer;
import org.suda.customerMgr.service.CustomerServiceImpl;
import org.suda.customerMgr.service.api.CustomerService;


public class CustomerDaoImplTest {
	 
	 @Mock
	 SessionFactory sessionFactory;
	 
	 
	 @InjectMocks
	  CustomerDAOImpl customerdaoimpl;
	 
	 Customer customer;
	 
	 Session session=mock(Session.class);
	 Serializable value = null;
	 
	@Before
	public void setUp() throws Exception {
		
		 MockitoAnnotations.initMocks(this);
		 
			//when(customerdaoimpl.addCustomer(customer)).thenReturn(true);
			when(sessionFactory.getCurrentSession()).thenReturn(session);
			
		//customerdaoimpl = new CustomerDAOImpl();
	}

	
@Test
public void testaddcustomer()
{
	
	when(session.save(customer)).thenReturn(value);
	assertTrue(customerdaoimpl.addCustomer(customer));
	
}


//@Test
//public void testaddcustomerFalse()
//{
//assertFalse(customerdaoimpl.addCustomer(new Customer()));
//}

@Test
public void testListCustomer()
{
	//when(sessionFactory.getCurrentSession()).thenReturn(session);
	List listMock=mock(List.class);
	//list.add(customer);
	Query query=mock(Query.class);
	when(session.createQuery(anyString())).thenReturn(query);
	when(query.list()).thenReturn(listMock);
	System.out.println(customerdaoimpl.listCustomer());
	assertEquals(0,customerdaoimpl.listCustomer().size());
}




}
