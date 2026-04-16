package com.example.Examen.dtos;

public class CursoDTO {

    private Long id;
    private String nombre;
    private String duracion;
    private int nivel;
    private String instructor;
    private int costo;

    public CursoDTO(){}
    public CursoDTO(Long id, String nombre,String duracion, int nivel, String instructor, int costo){
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.nivel = nivel;
        this.instructor = instructor;
        this.costo = costo;


    }

    public Long getId(){return this.id;}
    public String getNombre(){return  this.nombre;}
    public String getDuracion(){return this.duracion;}
    public int getnivel(){return  this.nivel;}
    public String getInstructor(){return  this.instructor;}
    public int getCosto(){return  this.costo;}

    public void setId(Long id){this.id= id;}
    public void setNombre(String nombre){this.nombre=nombre;}
    public void setDuracion(String duracion){this.duracion=duracion;}
    public void setNivel(int nivel){this.nivel=nivel;}
    public void setInstructor(String instructor){this.instructor=instructor;}
    public void setCosto(int costo){this.costo=costo;}
}
