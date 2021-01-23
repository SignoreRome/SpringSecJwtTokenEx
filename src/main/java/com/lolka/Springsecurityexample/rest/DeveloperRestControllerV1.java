package com.lolka.Springsecurityexample.rest;

import com.lolka.Springsecurityexample.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

    private List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L, "Roman", "Romanov"),
            new Developer(3L, "Semen", "Semenov")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll(){
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id){
        return DEVELOPERS.stream().filter(developer -> developer.getId()
                .equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer){
        this.DEVELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        this.DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }


}
