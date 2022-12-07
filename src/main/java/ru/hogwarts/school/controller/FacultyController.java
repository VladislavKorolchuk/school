package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.srvice.FacultyService;

import java.util.Collection;


@RestController
@RequestMapping("/faculty")
public class FacultyController {

    FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return this.facultyService.createFaculty(faculty);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteFaculty(@PathVariable("id") Long id) {
        this.facultyService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping({"/{id}"})
    public Faculty searchFaculty(@PathVariable("id") Long id, @RequestBody Faculty faculty) {
        return this.facultyService.updateFaculty(id, faculty);
    }

    @GetMapping({"/{id}"})
    public Faculty searchFaculty(@PathVariable("id") Long id) {
        return this.facultyService.searchFaculty(id);
    }

    @GetMapping
    public Collection<Faculty> getAllFaculty() {
        return this.facultyService.getAllFacultys();
    }

}
