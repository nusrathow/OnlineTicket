package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Ticket;
import net.javaguides.springboot.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @RequestMapping(value = "/ticket",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity<?> createTicket(@RequestBody Ticket ticket) throws URISyntaxException {
            Long maxId= ticketRepository.getMaxId();
            Long newId=(maxId==null)?1:(maxId+1);
            ticket.setId(newId);
        Ticket result= ticketRepository.save(ticket);
        return ResponseEntity.ok()
                .body(result);
    }


    @RequestMapping(value = "/ticket", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> updateTicket(@RequestBody Ticket ticket) throws URISyntaxException {

        if (ticket.getId() == null) {
            return createTicket(ticket);
        }System.out.println("(Service Side) Editing confirmBusTicket with Id: "+ ticket.getId());

        Ticket result = ticketRepository.save(ticket);
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

    @RequestMapping(value = "/ticket/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> getTicketById(@PathVariable("id") Long id) {
        return Optional.ofNullable(ticketRepository.findById(id))
                .map(hrmAgentPhoto -> new ResponseEntity<>(hrmAgentPhoto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}

