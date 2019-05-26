package com.winowicz.szkolenie;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animal")
public class MyApi {

    private AnimalRepo animalRepo;

    public MyApi(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }


    @GetMapping
    public Iterable<Animal> getAnimal() {
        return animalRepo.findAll();

    }

    @PutMapping
    public void putAnimal(@RequestBody Animal animal) {
        animalRepo.save(animal);
    }

    @PostMapping
    public void postAnimal(@RequestBody Animal animal) {
        animalRepo.save(animal);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        animalRepo.deleteById(id);

    }
}
