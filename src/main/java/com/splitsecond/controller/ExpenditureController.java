package com.splitsecond.controller;

import com.splitsecond.controller.converter.DTOToDataObjectConverter;
import com.splitsecond.data.Expenditure;
import com.splitsecond.data.ExpenditureRepository;
import com.splitsecond.dto.ExpenditureDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/expenditure")
public class ExpenditureController {
    private final ExpenditureRepository expenditureRepository;
    private final DTOToDataObjectConverter dtoToDataObjectConverter;

    ExpenditureController(ExpenditureRepository expenditureRepository, DTOToDataObjectConverter dtoToDataObjectConverter) {
        this.expenditureRepository = expenditureRepository;
        this.dtoToDataObjectConverter = dtoToDataObjectConverter;
    }

    @GetMapping("/{tripId}")
    List<Expenditure> getExpendituresForTrip(@PathVariable UUID tripId) {
        return expenditureRepository.findByTripId(tripId);
    }

    @PostMapping
    Expenditure createExpenditure(@RequestBody ExpenditureDTO expenditureDTO) {
        Expenditure expenditure = dtoToDataObjectConverter.convertExpenditure(expenditureDTO);
        return expenditureRepository.save(expenditure);
    }

    @DeleteMapping("/{id}")
    void deleteExpenditure(@PathVariable UUID id) {
        expenditureRepository.deleteById(id);
    }
}
