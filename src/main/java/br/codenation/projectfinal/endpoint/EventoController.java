package br.codenation.projectfinal.endpoint;

import br.codenation.projectfinal.dto.EventoDTO;
import br.codenation.projectfinal.dto.LevelDTO;
import br.codenation.projectfinal.dto.LogDTO;
import br.codenation.projectfinal.model.Evento;
import br.codenation.projectfinal.service.EventoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1.0")
public class EventoController {

    @Autowired
    public EventoService eventoService;


    @GetMapping(value = "/evento/{id}")
    @ApiOperation(value = "Retorna o evento com o id")
    public ResponseEntity<LogDTO> getEventosById(@PathVariable("id") Long id){
        Evento evento = eventoService.findById(id);

        return new ResponseEntity<>(new LogDTO(evento),HttpStatus.OK);
    }

    @GetMapping(value = "/evento")
    @ApiOperation(value = "Retorna todos os eventos de logs na central")
    public ResponseEntity<List<EventoDTO>>
    getEventos(@RequestParam(required = false,defaultValue = "0") Integer page,
               @RequestParam(required = false,defaultValue = "10") Integer size,
               @RequestParam(required = false,defaultValue = "descricao") String sort){

        List<Evento> eventos  =  eventoService.findAll(page,size,sort);
        return new ResponseEntity<>(EventoDTO.listEventosDTO(eventos),HttpStatus.OK);
    }


    @GetMapping("/evento/level/{type}")
    @ApiOperation(value = "Retorna os eventos filtrados pelo tipo \"level\" ")
    public ResponseEntity<LevelDTO> getEventosByLevel(@PathVariable("type") String type){

        List<Evento> eventos = eventoService.findByLevel(type);
        LevelDTO levelDTO = new LevelDTO(eventos,type.toUpperCase(),eventos.size());

        return new ResponseEntity<>(levelDTO, HttpStatus.OK);

    }

    @PostMapping("/evento")
    @ApiOperation(value = "Salva ou atualiza um evento")
    public ResponseEntity<EventoDTO> save(@RequestBody Evento evento){
        EventoDTO eventoPersisted = new EventoDTO(eventoService.save(evento));
        return new ResponseEntity<>(eventoPersisted,HttpStatus.CREATED);
    }



}
