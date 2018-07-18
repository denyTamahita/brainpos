package com.brainmatics.pos;

import com.brainmatics.pos.core.Employee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTests {

	@Test
    public void default_employee_age_should_25() {
        Employee e = new Employee();
        assertEquals(25, e.getAge());
    }
}
