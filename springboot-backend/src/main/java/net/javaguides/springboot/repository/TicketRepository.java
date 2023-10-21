package net.javaguides.springboot.repository;
import net.javaguides.springboot.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Query(value = "SELECT max(id) FROM Ticket")
    Long getMaxId();

    @Query(value = "SELECT journeyFrom FROM Bus")
    List findAllConfirmedTicket();
}

