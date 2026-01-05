package curs_managment.service;

import curs_managment.entity.Departement;
import curs_managment.repository.departmentRepository;
import org.springframework.stereotype.Service;

@Service
public class departmentService {

    private final curs_managment.repository.departmentRepository departmentRepository;

    public departmentService(departmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;

    }

    public Departement saveDepartment(Departement departement) {
        return departmentRepository.save(departement);
    }

    public Departement getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public java.util.List<Departement> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Departement deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
        return null;
    }

}
