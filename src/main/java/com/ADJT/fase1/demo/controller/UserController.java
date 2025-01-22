package com.ADJT.fase1.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.ADJT.fase1.demo.entity.dto.*;
import com.ADJT.fase1.demo.exception.CJNotFoundException;
import com.ADJT.fase1.demo.service.UserService;
import com.ADJT.fase1.demo.util.CustomCodeException;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ADJT.fase1.demo.entity.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/user")
@Tag(name = "User",description = "User controller")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Operation(description = "Endpoint para listar todos os usuários", summary = "Este é um resumo para o endpoint obter todos os usuários")
    @GetMapping
    public ResponseEntity<GetAllUserDto> getAll() {
        List<User> user = userService.getAll();
        List<GetUserDto> getUserDtos = user.stream().map(users -> modelMapper.map(users, GetUserDto.class))
                .collect(Collectors.toList());
        GetAllUserDto getAllUserDto = new GetAllUserDto(getUserDtos, getUserDtos.size());
        return ResponseEntity.status(HttpStatus.OK).body(getAllUserDto);
    }

    @Operation(description = "Endpoint para obter usuário por nome", summary = "Este é um resumo para o endpoint de obter usuário por nome")
    @GetMapping("/{name}/name")
    public ResponseEntity<GetUserDto> getUserByName(@PathVariable String name) {
        User userDb = userService.getByName(name);
        if(ObjectUtils.isEmpty(userDb))
            throw new CJNotFoundException(CustomCodeException.CODE_400, "usuário não encontrado com o nome "+name);
        GetUserDto getUserDto = modelMapper.map(userDb, GetUserDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(getUserDto);
    }

    @Operation(description = "Endpoint para validar login", summary = "Este é um resumo para o endpoint de validação de login")
    @PostMapping("/login")
    public ResponseEntity<String> validateLogin(@RequestBody LoginDto loginDto) {
        boolean isValid = userService.validateLogin(loginDto.getLogin(), loginDto.getPassword());
        if (isValid) {
            return ResponseEntity.status(HttpStatus.OK).body("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @Operation(description = "Endpoint para salvar usuário", summary = "Este é um resumo para o endpoint de salvar usuário")
    @PostMapping
    public ResponseEntity<GetUserDto> saveUser(@Valid @RequestBody PostUserDto dto) {
        User users = modelMapper.map(dto, User.class);
        User userDb = userService.save(users);
        GetUserDto getUserDto = modelMapper.map(userDb, GetUserDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(getUserDto);
    }

    @Operation(description = "Endpoint para atualizar usuário", summary = "Este é um resumo para o endpoint de atualizar usuário")
    @PutMapping(value = "/{id}")
    public ResponseEntity<GetUserDto> updateUser(@Valid @RequestBody PutUserDto dto,
                                                 @PathVariable(name = "id") Long id) {
        User users = modelMapper.map(dto, User.class);
        User userDb = userService.update(users, id);
        GetUserDto getUserDto = modelMapper.map(userDb, GetUserDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(getUserDto);
    }

    @Operation(description = "Endpoint para deletar usuário", summary = "Este é um resumo para o endpoint de deletar usuário")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<GetUserDto> deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}