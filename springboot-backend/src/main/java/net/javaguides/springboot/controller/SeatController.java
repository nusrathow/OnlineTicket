package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Bus;
import net.javaguides.springboot.model.Seat;
import net.javaguides.springboot.model.Ticket;
import net.javaguides.springboot.repository.SeatRepository;
import net.javaguides.springboot.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @RequestMapping(value = "/seat",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity<?> createNewSeat(@RequestBody Seat seat) throws URISyntaxException {
        Long maxId= seatRepository.getMaxId();
        Long newId=(maxId==null)?1:(maxId+1);
        seat.setId(newId);
        Seat result= seatRepository.save(seat);
        return ResponseEntity.ok()
                .body(result);
    }

    @RequestMapping(value = "seat/listOfSeat", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> addListHrmAgentChild(@RequestBody List<Seat> seat) throws URISyntaxException {
        for (Seat temp : seat) {
            updateSeat(temp);
        }
        return ResponseEntity.ok(seat);
    }


    @RequestMapping(value = "/seat", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> updateSeat(@RequestBody Seat seat) throws URISyntaxException {

        if (seat.getId() == null) {
            return createNewSeat(seat);
        }System.out.println("(Service Side) Editing confirmBusTicket with Id: "+ seat.getId());

        Seat result = seatRepository.save(seat);
        return ResponseEntity.ok()
                .body(result);
    }


    /*@RequestMapping(value = "/confirmBusTicket", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> getAllConfirmBusTicket(Pageable pageable) throws URISyntaxException {

        Page<ConfirmBusTicket> page = confirmBusTicketRepository.findAll(pageable);
        page= confirmBusTicketRepository.findAll(paginationUtil.listPage(page,"id"));

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/hrmAgentPhoto");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }*/

    @RequestMapping(value = "/seat/{ticketId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> getSeatByTicketId(@PathVariable("ticketId") Long ticket) {
        return Optional.ofNullable(seatRepository.findSeatByBusId(ticket))
                .map(hrmAgentPhoto -> new ResponseEntity<>(hrmAgentPhoto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}


