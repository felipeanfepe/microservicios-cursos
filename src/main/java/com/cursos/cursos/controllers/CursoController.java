package com.cursos.cursos.controllers;

import com.commons.controllers.CommonController;
import com.cursos.cursos.models.entity.Curso;
import com.cursos.cursos.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, Curso curso) {
        Optional<Curso> o = service.findById(id);

        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Curso cursoDb = o.get();

        cursoDb.setNombre(curso.getNombre());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
    }

}
