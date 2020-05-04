package br.codenation.projectfinal.endpoint;

import br.codenation.projectfinal.dto.EventDTO;
import br.codenation.projectfinal.dto.LevelDTO;
import br.codenation.projectfinal.dto.LogDTO;
import br.codenation.projectfinal.error.ResourceNotFound;
import br.codenation.projectfinal.model.Event;
import br.codenation.projectfinal.service.EventService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1.0")
@ApiOperation(value = " Endpoints for creating, retrieving and updating log events")
public class EventController {

    @Autowired
    public EventService eventService;

    @GetMapping(value = "/event/{id}")
    @ApiOperation(value = "Returns event by ID")
    public ResponseEntity<LogDTO> getEventById(@PathVariable("id") Long id){
        Event event = eventService.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Log event ID "+ id +" not found!"));

        return new ResponseEntity<>(new LogDTO(event),HttpStatus.OK);
    }

    @GetMapping(value = "/event")
    @ApiOperation(value = "Returns all log events")
    public ResponseEntity<List<EventDTO>>
    getEvents(@RequestParam(required = false,defaultValue = "0") Integer page,
               @RequestParam(required = false,defaultValue = "10") Integer size,
               @RequestParam(required = false,defaultValue = "description") String sort){

        List<Event> events  =  eventService.findAll(page,size,sort);
        return new ResponseEntity<>(EventDTO.listEventosDTO(events),HttpStatus.OK);
    }

    @GetMapping("/event/level/{type}")
    @ApiOperation(value = "Returns all log events filtered by \"level\" ")
    public ResponseEntity<LevelDTO> getEventsByLevel(@PathVariable("type") String type){

        List<Event> events = eventService.findByLevel(type.toLowerCase());

        LevelDTO levelDTO = new LevelDTO(events,type.toLowerCase(),events.size());

        return new ResponseEntity<>(levelDTO, HttpStatus.OK);

    }

    @PostMapping("/event")
    @ApiOperation(value = "Save or update a log event")
    public ResponseEntity<EventDTO> save(@Valid @RequestBody Event event){
        event.setLevel(event.getLevel().toLowerCase());
        EventDTO eventoPersisted = new EventDTO(eventService.save(event));
        return new ResponseEntity<>(eventoPersisted,HttpStatus.CREATED);
    }



}
