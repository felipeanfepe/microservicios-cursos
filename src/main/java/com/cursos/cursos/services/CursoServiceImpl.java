package com.cursos.cursos.services;

import com.commons.services.CommonServiceImpl;
import com.cursos.cursos.models.entity.Curso;
import com.cursos.cursos.models.repository.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

    /**
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Curso findCursoByAlumnoId(Long id) {
        return repository.findCursoByAlumnoId(id);
    }
}
