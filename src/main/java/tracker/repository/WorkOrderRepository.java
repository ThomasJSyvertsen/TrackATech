package tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tracker.beans.WorkOrder;

/**
 * @author Thomas Syvertsen - tjsyvertsen
 * CIS152 - Fall 2021
 * Dec 10, 2021
 */
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {

}
