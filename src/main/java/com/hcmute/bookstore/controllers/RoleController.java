package com.hcmute.bookstore.controllers;

import com.hcmute.bookstore.dtos.role.RoleDto;
import com.hcmute.bookstore.entities.ResponseObject;
import com.hcmute.bookstore.services.RoleService;
import com.hcmute.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.ok().body(ResponseObject.builder().status(HttpStatus.OK).message(
                Constant.SUCCESS).data(roleService.getAllRole()).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getRole(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok().body(ResponseObject.builder().status(HttpStatus.OK).message(
                Constant.SUCCESS).data(roleService.getRole(id)).build());
    }

    @PostMapping()
    public ResponseEntity<ResponseObject> addRole(@RequestBody RoleDto roleDto) {
        return ResponseEntity.ok().body(ResponseObject.builder().status(HttpStatus.OK).message(
                Constant.SUCCESS).data(roleService.addRole(roleDto)).build());
    }

//    @PostMapping("/permission")
//    public DataResponse addUserToRole(@RequestBody UserRoleDto userRoleDto) {
//        return new DataResponse(roleService.addUserToRole(userRoleDto));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteRole(@PathVariable(value = "id") Integer id) {
        roleService.deleteRole(id);
        return ResponseEntity.ok().body(ResponseObject.builder().status(HttpStatus.OK).message(
                Constant.SUCCESS).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateRole(@PathVariable(value = "id") Integer id, @RequestBody RoleDto roleDto) {
        return ResponseEntity.ok().body(ResponseObject.builder().status(HttpStatus.OK).message(
                Constant.SUCCESS).data(roleService.updateRole(id, roleDto)).build());
    }
}
