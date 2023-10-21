package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.sql.Time;
import java.util.List;

public interface BusRepository extends JpaRepository<Bus,Long> {

    @Query(value = "SELECT max(id) FROM Bus ")
    Long getMaxId();

    @Query(value = "SELECT journeyFrom FROM Bus")
    List findAlljourneyFrom();

    @Query(value = "SELECT model FROM Bus model WHERE (:journeyFrom IS NULL OR model.journeyFrom = :journeyFrom) AND (:journeyTo IS NULL OR model.journeyTo = :journeyTo) AND (:doj IS NULL OR model.doj = :doj)")
    List<Bus> search(@Param("journeyFrom") String journeyFrom, @Param("journeyTo") String journeyTo, @Param("doj") String doj);


    @Query(value = "SELECT model.id FROM Bus model WHERE (:journeyFrom IS NULL OR model.journeyFrom = :journeyFrom) AND (:journeyTo IS NULL OR model.journeyTo = :journeyTo) AND (:doj IS NULL OR model.doj = :doj) AND (:arriveTime IS NULL OR model.arriveTime = :arriveTime)AND (:departureTime IS NULL OR model.departureTime = :departureTime)AND (:busTypes IS NULL OR model.busTypes = :busTypes)AND (:fare IS NULL OR model.fare = :fare)AND (:operator IS NULL OR model.operator = :operator)AND (:seatAvailable IS NULL OR model.seatAvailable = :seatAvailable)")
    Long findBusId(@Param("journeyFrom")String journeyFrom,@Param("journeyTo")String journeyTo, @Param("doj")String doj,@Param("arriveTime")Time arriveTime,@Param("departureTime")Time departureTime,@Param("busTypes")String busTypes,@Param("fare")Integer fare,@Param("operator")String operator,@Param("seatAvailable")Integer seatAvailable);
}
