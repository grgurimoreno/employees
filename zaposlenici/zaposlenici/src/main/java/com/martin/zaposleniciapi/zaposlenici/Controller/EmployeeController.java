package com.martin.zaposleniciapi.zaposlenici.Controller;

import com.martin.zaposleniciapi.zaposlenici.Data.EmployeeRepository;
import com.martin.zaposleniciapi.zaposlenici.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 6/6/2017.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(method=RequestMethod.GET, value="/employees")
    public String getAllEmployees(Model model){
        model.addAttribute("employees",employeeRepository.findAll());
        return "EmployeesView";
    }


    @RequestMapping(method=RequestMethod.GET, value="/employees/add")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "AddEmployee";
    }

    @RequestMapping(method=RequestMethod.POST, value="/employees")
    public String addEmployee (Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(method=RequestMethod.GET, value="/employees/{id}")
    public  String getEmployee(@PathVariable Integer id, Model model){
        model.addAttribute("employee", employeeRepository.findOne(id));
        return "ViewEmployee";
    }

    @RequestMapping(method=RequestMethod.PUT, value="/employees/{id}")
    public String updateEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/employees/{id}")
    public @ResponseBody void deleteEmployee(@PathVariable Integer id){
        employeeRepository.delete(id);
    }

}
