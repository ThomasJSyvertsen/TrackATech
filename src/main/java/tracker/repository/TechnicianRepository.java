package tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tracker.beans.Technician;

/**
 * @author Thomas Syvertsen - tjsyvertsen
 * CIS152 - Fall 2021
 * Dec 10, 2021
 */
@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {

}
