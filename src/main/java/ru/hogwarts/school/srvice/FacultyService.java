package ru.hogwarts.school.srvice;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.reception.FacultyNotFoundReception;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private long count = 0;

    public Faculty createFaculty(Faculty faculty) {
        Long createid = ++count;
        faculty.setId(createid);
        Faculty newfaculty = facultyMap.put(createid, faculty);
        return newfaculty;
    }

    public void deleteFaculty(Long id) {
        if (facultyMap.containsKey(id)) {
            facultyMap.remove(id);
        } else {
            throw new FacultyNotFoundReception();
        }
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        if (facultyMap.containsKey(id)) {
            Faculty updateFaculty = facultyMap.get(id);
            updateFaculty.setName(faculty.getName());
            updateFaculty.setColor(faculty.getColor());
            return faculty;
        } else {
            throw new FacultyNotFoundReception();
        }
    }

    public Faculty searchFaculty(Long id) {
        if (facultyMap.containsKey(id)) {
            return facultyMap.get(id);
        } else {
            throw new FacultyNotFoundReception();
        }
    }

    public Collection<Faculty> getAllFacultys() {
        return facultyMap.values();
    }

    public Collection<Faculty> getFacultysByColor(String color) {
        Collection<Faculty> facultys;
        facultys = facultyMap.values().stream().
                filter(a -> a.getColor().equals(color)).
                collect(Collectors.toList());
        return facultys;
    }

}
