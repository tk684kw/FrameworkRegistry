package org.registry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FrameworkRegistryTest {
	
    @Autowired
    private FrameworkService service;
     
    @Before
    public void addFramework() {
    	service.save(new Framework(0, "Angular", "1.1", new Date(0), 1));
    }
	 
    @Test
    public void testRegistry() {
    	//search
    	Framework editFramework = service.findByName("Angular").get(0);
    	assertNotNull(editFramework);
    	//edit
    	editFramework.setName("Vue");
    	service.save(editFramework);
  	  	assertEquals(editFramework.getName(), "Vue");
  	  	//delete
  	  	service.delete(editFramework.getId());
  	  	assertTrue(service.findByName("Vue").isEmpty());
    }
}

