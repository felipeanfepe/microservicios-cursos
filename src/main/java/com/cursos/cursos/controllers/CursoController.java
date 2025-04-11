package com.cursos.cursos.controllers;

import com.commons.controllers.CommonController;
import com.commons.models.entity.Alumno;
import com.cursos.cursos.models.entity.Curso;
import com.cursos.cursos.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Curso curso) {
        Optional<Curso> o = service.findById(id);

        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Curso cursoDb = o.get();

        cursoDb.setNombre(curso.getNombre());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
    }

    @PutMapping("/{id}/asignar-alumnos")
    public ResponseEntity<?> asignarAlumnos(@PathVariable Long id, @RequestBody List<Alumno> alumnos) {
        Optional<Curso> o = service.findById(id);

        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Curso cursoDb = o.get();

        alumnos.forEach(
                a -> {
                    cursoDb.addAlumno(a);
                }
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
    }

    @PutMapping("/{id}/eliminar-alumno")
    public ResponseEntity<?> eliminarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        Optional<Curso> o = service.findById(id);

        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Curso cursoDb = o.get();

        cursoDb.removeAlumno(alumno);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
    }

}
