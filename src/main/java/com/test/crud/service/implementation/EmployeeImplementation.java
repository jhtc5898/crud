package com.test.crud.service.implementation;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.test.crud.entities.Employee;
import com.test.crud.pojo.EmployeeVO;
import com.test.crud.pojo.IdentificationEmployeeVO;
import com.test.crud.repository.EmployeeRepository;
import com.test.crud.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class EmployeeImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Get all employees by active status
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Object findAllByStatus() {
        if (!employeeRepository.findAllByStatus(Boolean.TRUE).isEmpty()) {
            log.info(employeeRepository.findAllByStatus(Boolean.TRUE).toString());
            return employeeRepository.findAllByStatus(Boolean.TRUE);
        }
        return ResponseEntity.ok().body("Sin Informacion");

    }

    /**
     * Get all employees by active status and identified
     *
     * @return
     */


    @Override
    @Transactional(readOnly = true)
    public Object findByIdentificationCardAndStatus(IdentificationEmployeeVO identification) {

        Employee employee = employeeRepository.findByIdentificationCardAndStatus(
            identification.getIdentificationCard(), true);

        if (employee != null) {
            log.info(employee.toString());
            return employee;
        }
        return ResponseEntity.ok().body("Sin Informacion");

    }

    /**
     * Insert Employee
     *
     * @return
     */
    @Override
    @Transactional
    public Object insertEmployee(EmployeeVO employeeVO) throws ParseException {

        Employee employee = new Employee();
        employee.setIdentificationCard(employeeVO.getIdentificationCard());
        employee.setFirstname(employeeVO.getFirstname());
        employee.setSecond_name(employeeVO.getSecond_name());
        employee.setFirst_surname(employeeVO.getFirst_surname());
        employee.setSecond_surname(employeeVO.getSecond_surname());
        employee.setEmail(employeeVO.getEmail());
        employee.setGender(employeeVO.getGender());
        employee.setDate_birth(
            new SimpleDateFormat("dd/MM/yyyy").parse(employeeVO.getDate_birth()));
        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee);

    }

    /**
     * Delete Employee
     *
     * @return
     */
    @Override
    @Transactional
    public Object deleteEmployee(IdentificationEmployeeVO identification) {
        Employee employee = employeeRepository.findByIdentificationCardAndStatus(
            identification.getIdentificationCard(), true);
        if (employee != null) {
            employee.setStatus(false);
            employeeRepository.save(employee);
            return ResponseEntity.ok().body(employee);
        }
        return ResponseEntity.ok().body("Sin Informacion");
    }


}
