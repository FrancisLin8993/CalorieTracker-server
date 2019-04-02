/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restws.Credential;

/**
 *
 * @author fengcilin
 */
@Stateless
@Path("restws.credential")
public class CredentialFacadeREST extends AbstractFacade<Credential> {

    @PersistenceContext(unitName = "FIT5046-ServerPU")
    private EntityManager em;

    public CredentialFacadeREST() {
        super(Credential.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Credential entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Credential entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Credential find(@PathParam("id") String id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByUsername/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Credential> findByUsername(@PathParam("username") String username){
        Query query = em.createNamedQuery("Credential.findByUsername");
        query.setParameter("username", username);
        return query.getResultList();
    }
    
    //Task 2a
    @GET
    @Path("findByUserId/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Credential> findByUserId(@PathParam("userId") Integer userId){
        Query query = em.createNamedQuery("Credential.findByUserId");
        query.setParameter("userId", userId);
        return query.getResultList();
    }
    
    @GET
    @Path("findByPasswordHash/{passwordHash}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Credential> findByPasswordHash(@PathParam("passwordHash") String passwordHash){
        Query query = em.createNamedQuery("Credential.findByPasswordHash");
        query.setParameter("passwordHash", passwordHash);
        return query.getResultList();
    }
    
    @GET
    @Path("findBySignUpDate/{signUpDate}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Credential> findBySignUpDate(@PathParam("signUpDate") String signUpDate){
        Query query = em.createNamedQuery("Credential.findBySignUpDate");
        Date sqlDate = Date.valueOf(LocalDate.parse(signUpDate));
        query.setParameter("signUpDate", sqlDate);
        return query.getResultList();
    }
    
    //Task 3d
    @GET
    @Path("findByUsernameAndEmail/{username}/{email}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Credential> findByUsernameAndEmail(@PathParam("username") String username, @PathParam("email") String email){
        Query query = em.createNamedQuery("Credential.findByUsernameAndEmail");
        query.setParameter("username", username);
        query.setParameter("email", email);
        return query.getResultList();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Credential> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Credential> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
