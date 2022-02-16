package com.search.controller;

import java.util.List;

import com.search.model.Employee;
import com.search.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"","/","index","home"})
    public String homePage(Model model)
    {
        List<Employee> list=employeeService.listAll();
        model.addAttribute("employee", list);
        return "index";
    }
    @GetMapping("/filter/{keyword}")
    public String searchPageLink(Model model,@PathVariable String keyword)
    {
        List<Employee> list=employeeService.listAll(keyword);
        model.addAttribute("employee", list);
        return "index";
    }
    @GetMapping("/filter")
    public String searchPageBar(Model model,@RequestParam(value = "keyword") String keyword)
    {
        List<Employee> list=employeeService.listAll(keyword);
        model.addAttribute("employee", list);
        return "index";
    }

    @GetMapping("/newEmployee")
    public String newEmployeeForm(Model model)
    {   
        Employee employee=new Employee();
        model.addAttribute("newEmployee",employee);
        return "newEmployeeForm";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("newEmployee") Employee employee)
    {
        employeeService.save(employee);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView updateEmployee(@PathVariable Long id)
    {
        ModelAndView mav=new ModelAndView("edit_employee");
        Employee employee = employeeService.getById(id);
        mav.addObject("employee", employee);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,Model model)
    {
        employeeService.delete(id);
        return "redirect:/";
    }
}
