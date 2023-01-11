package com.test.crud.service;

import java.text.ParseException;
import com.test.crud.pojo.EmployeeVO;
import com.test.crud.pojo.IdentificationEmployeeVO;

public interface EmployeeService {


    /**
     * Get all employees by active status
     *
     * @return
     */
    Object findAllByStatus();

    /**
     * Find by employee identification card and status
     *
     * @param identification
     * @param status
     */

    Object findByIdentificationCardAndStatus(IdentificationEmployeeVO identification);

    /**
     * Insert employee
     */

    Object insertEmployee(EmployeeVO employeeVO) throws ParseException;

    /**
     * Delete employee
     */

    Object deleteEmployee(IdentificationEmployeeVO employeeVO);

}
