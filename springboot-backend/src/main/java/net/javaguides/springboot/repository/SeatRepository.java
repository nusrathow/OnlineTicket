package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Seat;
import net.javaguides.springboot.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Long> {

    @Query(value = "SELECT max(id) FROM Seat ")
    Long getMaxId();

    @Query(value = "SELECT journeyFrom FROM Bus")
    List findAllConfirmedTicket();

    @Query(value = "SELECT model.seatNo FROM Seat model WHERE model.busId = :ticket")
    List findSeatByBusId(@Param("ticket")Long ticket);

}
