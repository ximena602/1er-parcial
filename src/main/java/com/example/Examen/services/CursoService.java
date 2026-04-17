package com.example.Examen.services;

import com.example.Examen.dtos.CursoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CursoService {
    List<CursoDTO> cursos = new ArrayList<>();

    public CursoService() {
    }

    public List<CursoDTO> obtenerCursos() {
        return cursos;
    }


    public CursoDTO crearCurso(CursoDTO cursoNuevo) {
        cursos.add(cursoNuevo);
        return cursoNuevo;
    }

    public CursoDTO editarCurso(String nombre, CursoDTO cursoEditado) {
        CursoDTO temporal = obtenerCursos().stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);

        if (temporal == null) {
            throw new RuntimeException("CURSO NO ENCONTRADO");
        }
        if (cursoEditado.getNombre() != null) {
            temporal.setNombre(cursoEditado.getNombre());
        }
        if (cursoEditado.getDuracion() != null) {
            temporal.setDuracion(cursoEditado.getDuracion());
        }
        if (cursoEditado.getNivel() != 0) {
            temporal.setNivel(cursoEditado.getNivel());
        }
        if (cursoEditado.getInstructor() != null) {
            temporal.setInstructor(cursoEditado.getInstructor());
        }
        if (cursoEditado.getCosto() != 0) {
            temporal.setCosto(cursoEditado.getCosto());
        }
        return temporal;
    }
    public CursoDTO eliminarCurso(String nombre){
        CursoDTO temporal = obtenerCursos().stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
        if (temporal== null){
            throw new RuntimeException("CURSO NO ENCONTRADO");

        }
        cursos.remove(temporal);
        return temporal;
    }
}


