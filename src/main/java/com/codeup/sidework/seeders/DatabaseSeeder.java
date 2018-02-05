package com.codeup.sidework.seeders;


import com.codeup.sidework.daos.DepartmentRepository;
import com.codeup.sidework.daos.DivisionRepository;
import com.codeup.sidework.daos.PositionsRepository;
import com.codeup.sidework.models.Department;
import com.codeup.sidework.models.Division;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class DatabaseSeeder {

    private Logger logger = Logger.getLogger(DatabaseSeeder.class);
    private PositionsRepository positionsRepository;
    private DivisionRepository divisionRepository;
    private DepartmentRepository departmentRepository;
//    private ListingsRepository listingsRepository;
//    private TagRepository tagRepository;
    private JdbcTemplate jdbcTemplate;


    @Autowired
    public DatabaseSeeder(
            PositionsRepository positionsRepository,
            DivisionRepository divisionRepository,
            DepartmentRepository departmentRepository,
            JdbcTemplate jdbcTemplate) {
        this.positionsRepository = positionsRepository;
        this.divisionRepository = divisionRepository;
        this.departmentRepository = departmentRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
//        seedPositionsTable();
        seedDivisionsTable();
        seedDepartmentTable();
    }

    private void seedDepartmentTable() {
        String dc0 = "Front of House", dc1 = "Back of House", dc2 = "Operators";
        String sql = "SELECT * FROM department c WHERE department_name IN (\"" + dc0 + "\", \"" + dc1 + "\", \"" + dc2 + "\")";
        List<Department> rs = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if(rs == null || rs.size() <= 0) {
            Department deptFOH = new Department("Front of House");
            Department deptBOH = new Department("Back of House");
            Department deptMGMT = new Department("Operators");
            departmentRepository.save(Arrays.asList(deptFOH, deptBOH, deptMGMT));
            logger.info("department table seeded");
        } else {
            logger.trace("Department Seeding Not Required");
        }
    }

    private void seedDivisionsTable() {
        String ds = "floorJobs", ds1 = "barJobs", ds2 = "kitchenJobs", ds3 = "supportJobs", ds4 = "mgmtJobs";
        String sql = "SELECT * FROM positions_division s WHERE division_id IN (\"" + ds + "\", \"" + ds1 + "\", \"" + ds2 + "\", \"" + ds3 + "\"," +
                " \"" + ds4 + "\")";
        List<Division> rs = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if(rs == null || rs.size() <= 0) {
            Division floorJobs = new Division("floorJobs");
            Division barJobs = new Division("barJobs");
            Division kitchenJobs = new Division("kitchenJobs");
            Division supportJobs = new Division("supportJobs");
            Division mgmtJobs = new Division("mgmtJobs");
            divisionRepository.save(Arrays.asList(floorJobs, barJobs, kitchenJobs, supportJobs, mgmtJobs));
            logger.info("division table seeded");
        } else {
            logger.trace("Division Seeding Not Required.");
        }
    }

//    private void seedPositionsTable(jobListFloor) {
//        io.vavr.collection.List list = io.vavr.collection.List.of("jobListFloor", "jobListBar", "jobListKitchen", "jobListSupport", "jobListOperator");
//        String sql = "SELECT * FROM positions_division WHERE job_title IN (" + list.mkString("\"", "\",\"", "\"", + ")";
//        List<Positions> rs = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
//        if(rs == null || rs.size() <= 0) {
//            Positions t1 = new Positions("Server");
//            Positions t2 = new Positions("Host");
//            Positions t3 = new Positions("Banquet Server");
//            Positions t4 = new Positions("Receptionist");
//            Positions t5 = new Positions()
//
//            positionsRepository.save(Arrays.asList(t1,t2,t3,t4,t5));
//            logger.info("positions table seeded");
//        } else {
//            logger.trace("Positions Seeding Not Required.");
//        }
//    }


}
