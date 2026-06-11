package com.ateeq.Java_Prj1.Controller;

import com.ateeq.Java_Prj1.model.Earnings;
import com.ateeq.Java_Prj1.repository.EarningsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/earnings")
public class EarningsController {

    @Autowired
    private EarningsRepository earningsRepository;

    @GetMapping
    public List<Earnings> getEarnings() {
        return earningsRepository.findAll();
    }
}