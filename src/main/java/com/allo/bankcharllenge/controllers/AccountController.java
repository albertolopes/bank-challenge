package com.allo.bankcharllenge.controllers;

import com.allo.bankcharllenge.dtos.AccountDTO;
import com.allo.bankcharllenge.dtos.CreateAccountDTO;
import com.allo.bankcharllenge.services.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
@Api("Account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @ApiOperation("Create a new accout")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody CreateAccountDTO dto){
        return ResponseEntity.ok(accountService.createAccount(dto));
    }

}
