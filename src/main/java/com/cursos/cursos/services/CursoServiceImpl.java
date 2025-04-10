package com.cursos.cursos.services;

import com.commons.services.CommonServiceImpl;
import com.cursos.cursos.models.entity.Curso;
import com.cursos.cursos.models.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

}
