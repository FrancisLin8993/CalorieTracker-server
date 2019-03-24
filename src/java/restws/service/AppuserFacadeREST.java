/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws.service;

import java.math.BigDecimal;
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
import restws.Appuser;

/**
 *
 * @author fengcilin
 */
@Stateless
@Path("restws.appuser")
public class AppuserFacadeREST extends AbstractFacade<Appuser> {

    @PersistenceContext(unitName = "FIT5046-ServerPU")
    private EntityManager em;

    public AppuserFacadeREST() {
        super(Appuser.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Appuser entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Appuser entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Appuser find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByFirstname/{firstname}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appuser> findByFirstname(@PathParam("firstname") String firstname){
        Query query = em.createNamedQuery("Appuser.findByFirstname");
        query.setParameter("firstname", firstname);
        return query.getResultList();
    }
    
    @GET
    @Path("findBySurname/{surname}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appuser> findByLastname(@PathParam("surname") String surname){
        Query query = em.createNamedQuery("Appuser.findBySurname");
        query.setParameter("surname", surname);
        return query.getResultList();
    }
    
    @GET
    @Path("findByEmail/{email}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appuser> findByEmail(@PathParam("email") String email){
        Query query = em.createNamedQuery("Appuser.findByEmail");
        query.setParameter("email", email);
        return query.getResultList();
    }
    
    @GET
    @Path("findByHeight/{height}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appuser> findByHeight(@PathParam("height") String height){
        Query query = em.createNamedQuery("Appuser.findByHeight");
        query.setParameter("height", new BigDecimal(height));
        return query.getResultList();
    }
    
    @GET
    @Path("findByWeight/{weight}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appuser> findByWeight(@PathParam("weight") String weight){
        Query query = em.createNamedQuery("Appuser.findByWeight");
        query.setParameter("weight", new BigDecimal(weight));
        return query.getResultList();
    }
    
    @GET
    @Path("findByGender/{gender}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appuser> findByGender(@PathParam("gender") String gender){
        Query query = em.createNamedQuery("Appuser.findByGender");
        query.setParameter("gender", gender.charAt(0));
        return query.getResultList();
    }
    
    @GET
    @Path("findByAddress/{address}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appuser> findByAddress(@PathParam("address") String address){
        Query query = em.createNamedQuery("Appuser.findByAddress");
        query.setParameter("address", address);
        return query.getResultList();
    }
    
    @GET
    @Path("findByPostcode/{postcode}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appuser> findByPostcode(@PathParam("postcode") String postcode){
        Query query = em.createNamedQuery("Appuser.findByPostcode");
        query.setParameter("postcode", postcode);
        return query.getResultList();
    }
    
    @GET
    @Path("findByLevelOfActivity/{levelOfActivity}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appuser> findByLevelOfActivity(@PathParam("levelOfActivity") String levelOfActivity){
        Query query = em.createNamedQuery("Appuser.findByLevelOfActivity");
        query.setParameter("levelOfActivity", levelOfActivity.charAt(0));
        return query.getResultList();
    }
    
    @GET
    @Path("findByStepsPerMile/{stepsPerMile}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appuser> findByStepsPerMile(@PathParam("stepsPerMile") Integer stepsPerMile){
        Query query = em.createNamedQuery("Appuser.findByStepsPerMile");
        query.setParameter("stepsPerMile", stepsPerMile);
        return query.getResultList();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appuser> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appuser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
