package uz.pdp.appmultipledb.controller;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appmultipledb.dto.BookDTO;
import uz.pdp.appmultipledb.paylaod.ApiResult;

import java.util.List;

@RequestMapping("/api-book")
public interface BookController {

    @GetMapping
    ApiResult<List<BookDTO>> getAll();

    @GetMapping("/{id}")
    ApiResult<BookDTO> getById(@PathVariable Integer id);

    @PostMapping
    ApiResult<BookDTO> create(@Valid @RequestBody BookDTO bookDTO);

    @PutMapping("/edit/{id}")
    ApiResult<BookDTO> edit(@PathVariable Integer id,
                            @Valid @RequestBody BookDTO bookDTO);

    @DeleteMapping("/delete/{id}")
    ApiResult<?> deleteAById(@PathVariable Integer id);

    @DeleteMapping("/delete")
    ApiResult<?> deleteAll();



}
