package dev.davidsalomon.webapp.resources;

import dev.davidsalomon.webapp.service.MateriaDataService;
import entities.Materia;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

/**
 *
 * @author david
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/materias")
public class RecursoMateria {
    @EJB
    MateriaDataService service;
    
    @GET
    public Response getMaterias(){
        List<Materia> materias = service.getMaterias();
        
        return Response.ok(materias).build();
    }
    
    @POST
    public Response saveMateria(Materia alumno){
        service.saveMateria(alumno);
        
        return Response.ok("Materia creado exitosamente").build();
    }
    
    @PUT
    public Response editMateria(Materia alumno){
        service.editMateria(alumno);
        
        return Response.ok("Materia editado exitosamente").build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteMateria(@PathParam("id") Integer id){
        service.deleteMateria(new Materia(id));
        
        return Response.ok("Materia eliminado exitosamente").build();
    }
    
    
}
