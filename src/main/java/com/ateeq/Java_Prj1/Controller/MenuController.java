package com.ateeq.Java_Prj1.Controller;

import com.ateeq.Java_Prj1.model.Menu;
import com.ateeq.Java_Prj1.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping
    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }

    @PostMapping
    public Menu addMenuItem(@RequestBody Menu menu) {
        return menuRepository.save(menu);
    }
}