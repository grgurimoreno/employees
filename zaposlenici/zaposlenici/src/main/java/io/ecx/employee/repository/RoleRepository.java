package io.ecx.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ecx.employee.model.Role;

/**
 * Created by Martin on 6/15/2017.
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>
{
    Role findByRole(String role);
}
