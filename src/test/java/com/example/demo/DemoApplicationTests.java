package com.example.demo;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.models.Project;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment(){
		Department department = new Department("Technology and other whimsical endeavours");
		departmentRepository.save(department);

		Employee employee1 = new Employee("Janet", "Coxhead", 1, department);
		employeeRepository.save(employee1);

	}

	@Test
	public void addEmployeesAndProjects(){
		Department department = new Department("Technology and other whimsical endeavours");
		departmentRepository.save(department);

		Employee employee1 = new Employee("Janet", "Coxhead", 32, department);
		employeeRepository.save(employee1);

		Project project1 = new Project("Revolution.", 7);
		projectRepository.save(project1);

		project1.addEmployee(employee1);
		projectRepository.save(project1);

	}

}
