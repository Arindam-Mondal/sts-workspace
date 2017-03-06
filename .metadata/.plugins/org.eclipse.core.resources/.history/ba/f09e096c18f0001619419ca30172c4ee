package com.howtodoinjava.demo.controller;


import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.howtodoinjava.demo.editors.DepartmentEditor;
import com.howtodoinjava.demo.model.DepartmentEntity;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.service.DepartmentManager;
import com.howtodoinjava.demo.service.EmployeeManager;

@Controller
@RequestMapping("/employee-module")
@SessionAttributes("employee")
public class EmployeeController
{
	
	Logger logger = Logger.getLogger(EmployeeController.class);
	
	
	@Autowired
	EmployeeManager empmanager;
	
	@Autowired
	DepartmentManager deptmanager;
	
	@Autowired
	DepartmentEditor deptEditor;

	private Validator validator;

	//Bind custom validator for submitted form
	public EmployeeController()
	{
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
	
	/**
	 * Bind DepartmentEditor to DepartmentEntity; Look at JSP file for clearer picture
	 * */
//	@InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(DepartmentEntity.class, new DepartmentEditor());
//    }
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(DepartmentEntity.class, deptEditor);
    }
	/**
	 * Bind all departments
	 * */
	@ModelAttribute("allDepartments")
    public List<DepartmentEntity> populateDepartments() 
    {		
        List<DepartmentEntity> departments = empmanager.getAllDepartments();
        return departments;
    }
	
	/**
	 * Bind all employees list
	 * */
	@ModelAttribute("allEmployees")
    public List<EmployeeEntity> populateEmployees() 
    {
        List<EmployeeEntity> employees = empmanager.getAllEmployees();
        return employees;
    }
	
	@ModelAttribute("headerMesssage")
	public String headerMessge(){
		return "Employee Management App";
	}
	
	/**
	 * Method will be called in initial page load at GET /employee-module
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model)
	{
		logger.info("Logging :: Inside setupForm");
		EmployeeEntity employeeVO = new EmployeeEntity();
		model.addAttribute("employee", employeeVO);
		return "listEmployeeView";
	}

	/**
	 * Method will be called on submitting add employee form POST /employee-module
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("employee") EmployeeEntity employeeVO,
			BindingResult result, SessionStatus status, HttpServletRequest request) {
		System.out.println("Inside submitForm method");

		Set<ConstraintViolation<EmployeeEntity>> violations = validator.validate(employeeVO);
		
		for (ConstraintViolation<EmployeeEntity> violation : violations) 
		{
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            // Add JSR-303 errors to BindingResult
            // This allows Spring to display them in view via a FieldError
            result.addError(new FieldError("employee", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
        }

		if (result.hasErrors()) {
			return "listEmployeeView";
		}
		// Store the employee information in database
		empmanager.addEmployee(employeeVO);
		
		// Mark Session Complete and redirect to URL so that page refresh do not re-submit the form
		status.setComplete();
		
//		String redirectUrl = request.getScheme() + "employee-module";
//	    return "redirect:" + redirectUrl;
				
		return "redirect:/employee-module";
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteEmployee(HttpServletRequest request){
		System.out.println("Inside deleteEmployee method");
		System.out.println("Parameters Name: "+request.getParameterNames());
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(empmanager.deleteEmployee(id));
		
		return "redirect:/employee-module";
	}

}