package dev.davidsalomon.webapp.controllers;

import dev.davidsalomon.webapp.service.AlumnoDataService;
import entities.Alumno;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class IndexController {

    private List<Alumno> alumnosList = new ArrayList<>();

    private Alumno alumno = new Alumno();

    @EJB
    AlumnoDataService alumnosServicio;

    @PostConstruct
    public void cargarAlumnos() {
        alumnosList = alumnosServicio.getAlumnos();
    }

    public void guardarAlumno() {
        if (alumno.getId() != null) {
            alumnosServicio.editAlumno(alumno);
        } else {
            alumnosServicio.saveAlumno(alumno);
        }
        alumno = new Alumno();
        cargarAlumnos();
        alumno = new Alumno();

    }

    public void editarAlumno(Alumno alumno) {
        this.alumno.setId(alumno.getId());
        this.alumno.setNombre(alumno.getNombre());
        this.alumno.setCarnet(alumno.getCarnet());
    }

    public void eliminarAlumno(Alumno alumno) {
        alumnosServicio.deleteAlumno(alumno);
        cargarAlumnos();
    }

    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }


}
