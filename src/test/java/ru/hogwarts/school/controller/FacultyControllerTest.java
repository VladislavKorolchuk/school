package ru.hogwarts.school.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.srvice.FacultyService;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FacultyControllerTest {

    FacultyService facultyService = new FacultyService();

    @BeforeEach
    void setUp() {
        Faculty faculty1 = new Faculty(0L, "Прикладной механики", "Красный");
        facultyService.createFaculty(faculty1);
        Faculty faculty2 = new Faculty(0L, "САПР", "Синий");
        facultyService.createFaculty(faculty2);
        Faculty faculty3 = new Faculty(0L, "ВТ", "Красный");
        facultyService.createFaculty(faculty3);
    }

    @Test
    void createFaculty() {
        Faculty faculty = new Faculty(0L, "Физики", "Желтый");
        facultyService.createFaculty(faculty);
        assertEquals(faculty, facultyService.searchFaculty(faculty.getId()));
        assertEquals(facultyService.getAllFacultys().size(),4);
    }

    @Test
    void deleteFaculty() {
        assertEquals(facultyService.getAllFacultys().size(), 3);
        facultyService.deleteFaculty(1L);
        assertEquals(facultyService.getAllFacultys().size(), 2);
    }

    @Test
    void updateSFaculty() {
        Faculty faculty = new Faculty(0L, "САПР", "Зеленый");
        facultyService.updateFaculty(1L,faculty);
        assertEquals(faculty.getName(),"САПР");
        assertEquals(faculty.getColor(),"Зеленый");
    }

    @Test
    void searchFaculty() {
        Faculty faculty = facultyService.searchFaculty(2L);
        assertEquals(faculty.getName(),"САПР");
        assertEquals(faculty.getColor(),"Синий");
    }

    @Test
    void getAllFaculty() {
        Collection<Faculty> collection = facultyService.getAllFacultys();
        assertEquals(collection.size(),3);
    }

    @Test
    void test() {
        Collection<Faculty> collection = facultyService.getFacultysByColor("Красный");
        assertEquals(collection.size(), 2);
    }

}