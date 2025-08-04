package com.app.ems.service.impl;

import com.app.ems.dto.EmployeeDto;
import com.app.ems.entity.Employee;
import com.app.ems.exception.ResourceNotFoundException;
import com.app.ems.mapper.EmployeeMapper;
import com.app.ems.repository.EmployeeRepository;
import com.app.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee is present with the given id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
