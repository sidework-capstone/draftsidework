package com.codeup.sidework.daos;

import com.codeup.sidework.models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findByDepartmentName(String departmentName);

}
