package com.example.Examen.controllers;

import com.example.Examen.dtos.CursoDTO;
import org.springframework.web.bind.annotation.*;
import com.example.Examen.services.CursoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin(origins = "*") // <--- ESTA LÍNEA ES LA CLAVE


@RestController
@RequestMapping
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @GetMapping("/cursos")
    public List<CursoDTO> getCursos(){
        return cursoService.obtenerCursos();
    }
    @PostMapping("curso")
    public  CursoDTO postCuerso(@RequestBody CursoDTO nuevo){
        return cursoService.crearCurso(nuevo);
    }
    @PostMapping("/curso{nombre}")
    public CursoDTO putCurso(@PathVariable String nombre, @RequestBody CursoDTO editado){
        return cursoService.editarCurso(nombre, editado);


    }

    @DeleteMapping("/curso/{nombre}")
    public CursoDTO deleteCurso (@PathVariable String nombre){
        return cursoService.eliminarCurso(nombre);
    }


}
