package com.example.project.bookmyshowbackend.controller;

import com.example.project.bookmyshowbackend.dto.EntryRequest.UserEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.UserResponseDto;
import com.example.project.bookmyshowbackend.dto.TicketDto;
import com.example.project.bookmyshowbackend.service.impl.UserServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @PostMapping("add")
    public ResponseEntity addUser(@RequestBody UserEntryDto userEntryDto) throws Exception{

        try {
            userService.addUser(userEntryDto);
            return new ResponseEntity("Added a success User", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
//            throw new Exception(e);
            return new ResponseEntity<>(""+e,HttpStatus.ALREADY_REPORTED);
        }




    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable(value = "id")int id){

        try {
            UserResponseDto userResponseDto = userService.getUser(id);
            return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("No such Id is present :"+e,HttpStatus.OK);
        }

    }

}
