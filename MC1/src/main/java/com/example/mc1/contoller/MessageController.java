package com.example.mc1.contoller;

import com.example.mc1.dto.MessageDTO;
import com.example.mc1.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    @GetMapping(
            path = {"/start"},
            produces = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> start() {
        boolean isStarted = this.getMessageService().startTask();
        return ResponseEntity.status(HttpStatus.OK).body(isStarted ? "Task is successfully started" : "Task is already started");
    }

    @GetMapping(
            path = {"/stop"},
            produces = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> stop() {
        boolean isStopped = this.getMessageService().stopTask();
        return ResponseEntity.status(HttpStatus.OK).body(isStopped ? "Task is successfully stopped" : "Task isn't started");
    }

    @PostMapping(
            path = {"/fromMC3"}
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> fromMc3(@RequestBody MessageDTO messageDTO) {
        this.getMessageService().receiveFromMc3(messageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Record successfully created");
    }
}
