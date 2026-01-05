package curs_managment.controller;

import curs_managment.entity.Departement;
import curs_managment.service.departmentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class departmentController {
    private final departmentService departmentService;

    public departmentController(departmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Departement createDepartment(@RequestBody Departement departement) {
        return departmentService.saveDepartment(departement);
    }

    @GetMapping
    public List<Departement> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Departement getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }

}
