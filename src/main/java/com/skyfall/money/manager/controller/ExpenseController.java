package com.skyfall.money.manager.controller;

import com.skyfall.money.manager.model.Expense;
import com.skyfall.money.manager.service.ExpenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Expense Controller", description = "REST API for managing Expense")

@RestController
@RequestMapping(value = "/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @ApiOperation(value = "Add expense in the System ", response = Expense.class, tags = "Expense")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @PostMapping("/addExpense")
    public ResponseEntity<java.io.Serializable> addExpense(@RequestBody Expense expense) {
        Expense savedExpense = expenseService.addExpense(expense);
        if (savedExpense.getId() != null) {
            return new ResponseEntity<>(savedExpense, HttpStatus.OK);
        } else {
            return new ResponseEntity<java.io.Serializable>("failed to add new expense", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Get all expense in the System ", response = List.class, tags = "Expense")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("/all")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @ApiOperation(value = "Get expense by Id ", response = Expense.class, tags = "Expense")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("/byId/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable int id) {
        Expense expenses = expenseService.findById(id);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @ApiOperation(value = "Update expense by Id ", response = Expense.class, tags = "Expense")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @PutMapping("/updateExpense/{id}")
    public ResponseEntity<java.io.Serializable> addExpense(@RequestBody Expense expense, @PathVariable int id) {
        Expense savedExpense = expenseService.updateExpense(expense, id);
        if (savedExpense.getId() != null) {
            return new ResponseEntity<>(savedExpense, HttpStatus.OK);
        } else {
            return new ResponseEntity<java.io.Serializable>("failed to update expense", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Delete expense by Id ", response = Expense.class, tags = "Expense")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @DeleteMapping("/deleteExpense/{id}")
    public ResponseEntity<String> removeExpense(@PathVariable int id) {
        try {
            expenseService.deleteExpense(id);
            return new ResponseEntity<>("Deleted expense successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to delete expense.", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
