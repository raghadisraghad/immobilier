package com.Gestion.Immobilier.Pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/pro")
@RestController
public class ProController {

    @Autowired
    private ProService proService;

    @PostMapping("/")
    public String addUser(@RequestBody Pro pro){
        proService.addPro(pro);
        return "User Added Successfully...";
    }

    @GetMapping("/")
    public List<Pro> getAllPro() {
        return proService.getAllPros();
    }

    @GetMapping("/{id}")
    public Optional<Pro> getProById(@PathVariable("id") UUID id) {
        return proService.getProById(id);
    }

    @PutMapping("/{id}")
    public String updatePro(@PathVariable("id") UUID id, @RequestBody Pro pro) {
        if (proService.updatePro(id, pro)!=0)
            return "User Updated Successfully...";
        else
            return "User Not Updated";
    }

    @DeleteMapping("/{id}")
    public void deletePro(@PathVariable("id") UUID id) {
        proService.deletePro(id);
    }
}