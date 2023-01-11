package com.test.crud.controller;


import javax.validation.Valid;
import com.test.crud.exceptions.ErrorRequest;
import com.test.crud.pojo.EmployeeVO;
import com.test.crud.pojo.IdentificationEmployeeVO;
import com.test.crud.service.EmployeeService;
import com.test.crud.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee/")
@CrossOrigin(origins = "*")
public class EmployeeControllers {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Get employee information
     *
     * @return
     */
    @Operation(summary = "Get find all employee information",
        responses = {@ApiResponse(responseCode = "600", description = "Exepcion Internal")})
    @GetMapping(value = "/findAllByStatus")
    public ResponseEntity<Object> findAllByStatus() {
        try {
            return ResponseEntity.badRequest().body(employeeService.findAllByStatus());
        } catch (Exception e) {
            ErrorRequest errorRequest = new ErrorRequest(e.getCause().getCause().getMessage(),
                Constants.CODE_ERROR_INTERNAL, e.getCause());
            return ResponseEntity.internalServerError().body(errorRequest);
        }
    }

    /**
     * Find by employee identification card and status
     *
     * @return
     */

    @PostMapping(value = "/findByIdentificationCardAndStatus")
    public ResponseEntity<Object> findByIdentificationCardAndStatus(
        @Valid @RequestBody IdentificationEmployeeVO identificationEmployeeVO) {
        try {
            return ResponseEntity.badRequest()
                .body(employeeService.findByIdentificationCardAndStatus(
                    identificationEmployeeVO));
        } catch (Exception e) {
            ErrorRequest errorRequest = new ErrorRequest(e.getCause().getCause().getMessage(),
                Constants.CODE_ERROR_INTERNAL, e.getCause());
            return ResponseEntity.internalServerError().body(errorRequest);
        }
    }

    /**
     * Find by employee identification card and status
     *
     * @return
     */

    @PostMapping(value = "/insertEmployee")
    public ResponseEntity<Object> insertEmployee(@Valid @RequestBody EmployeeVO employeeVO) {
        try {
            return ResponseEntity.badRequest().body(employeeService.insertEmployee(employeeVO));
        } catch (Exception e) {
            ErrorRequest errorRequest = new ErrorRequest(e.getCause().getCause().getMessage(),
                Constants.CODE_ERROR_INTERNAL, e.getCause());
            return ResponseEntity.internalServerError().body(errorRequest);
        }
    }


    /**
     * Delete Employee
     *
     * @return
     */

    @PostMapping(value = "/deleteEmployee")
    public ResponseEntity<Object> deleteEmployee(
        @Valid @RequestBody IdentificationEmployeeVO identificationEmployeeVO) {
        try {
            return ResponseEntity.badRequest()
                .body(employeeService.deleteEmployee(identificationEmployeeVO));
        } catch (Exception e) {
            ErrorRequest errorRequest = new ErrorRequest(e.getCause().getCause().getMessage(),
                Constants.CODE_ERROR_INTERNAL, e.getCause());
            return ResponseEntity.internalServerError().body(errorRequest);
        }
    }


}
