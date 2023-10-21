package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.BusDto;
import net.javaguides.springboot.model.Bus;
import net.javaguides.springboot.model.Seat;
import net.javaguides.springboot.repository.BusRepository;
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
public class BusController {

    @Autowired
    private BusRepository busRepository;

    @RequestMapping(value = "/bus",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity<?> createNewBus(@RequestBody Bus bus) throws URISyntaxException {
        Long maxId= busRepository.getMaxId();
        Long newId=(maxId==null)?1:(maxId+1);
        bus.setId(newId);
        Bus result= busRepository.save(bus);
        return ResponseEntity.ok()
                .body(result);
    }


    @RequestMapping(value = "/bus", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> updateBus(@RequestBody Bus bus) throws URISyntaxException {
        if (bus.getId() == null) {
            return createNewBus(bus);
        }

        Bus result = busRepository.save(bus);
        return ResponseEntity.ok()
                .body(result);
    }


    // get all employees
    @GetMapping("/bus/journeyFrom")
    public List getAllBus() {
        return busRepository.findAlljourneyFrom();
    }


    @RequestMapping(value = "/bus/search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity<?> busSearch(@RequestBody BusDto bus) {

        List<Bus> list = busRepository.search(bus.getJourneyFrom(),bus.getJourneyTo(),bus.getDoj());
        return ResponseEntity.ok()
                .body(list);
    }


    @RequestMapping(value = "/bus/getBusId",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity<?> getBusId(@RequestBody BusDto bus) {

        Long busId = busRepository.findBusId(bus.getJourneyFrom(),bus.getJourneyTo(),bus.getDoj(),bus.getArriveTime(),bus.getDepartureTime(),bus.getBusTypes(),bus.getFare(),bus.getOperator(),bus.getSeatAvailable());
        return ResponseEntity.ok()
                .body(busId);
    }


    @RequestMapping(value = "/bus/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> getBusById(@PathVariable("id") Long id) {
        return Optional.ofNullable(busRepository.findById(id))
                .map(bus -> new ResponseEntity<>(bus, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
