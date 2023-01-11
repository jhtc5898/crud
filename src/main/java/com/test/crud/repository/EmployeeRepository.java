package com.test.crud.repository;

import java.io.Serializable;
import java.util.List;
import com.test.crud.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {

    List<Employee> findAllByStatus(Boolean status);

    Employee findByIdentificationCardAndStatus(String identification, Boolean status);


}
