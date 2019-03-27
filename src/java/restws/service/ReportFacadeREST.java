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
import restws.Report;

/**
 *
 * @author fengcilin
 */
@Stateless
@Path("restws.report")
public class ReportFacadeREST extends AbstractFacade<Report> {

    @PersistenceContext(unitName = "FIT5046-ServerPU")
    private EntityManager em;

    public ReportFacadeREST() {
        super(Report.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Report entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Report entity) {
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
    public Report find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByUserId/{userId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findByUserId(@PathParam("userId") Integer userId){
        Query query = em.createNamedQuery("Report.findByUserId");
        query.setParameter("userId", userId);
        return query.getResultList();
    }
    
    @GET
    @Path("findByDate/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findByDate(@PathParam("date") String date){
        Query query = em.createNamedQuery("Report.findByDate");
        Date sqlDate = Date.valueOf(LocalDate.parse(date));
        query.setParameter("date", sqlDate);
        return query.getResultList();
    }
    
    @GET
    @Path("findByTotalCalorieConsumed/{totalCalorieConsumed}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findByTotalCalorieConsumed(@PathParam("totalCalorieConsumed") Integer totalCalorieConsumed){
        Query query = em.createNamedQuery("Report.findByTotalCalorieConsumed");
        query.setParameter("totalCalorieConsumed", totalCalorieConsumed);
        return query.getResultList();
    }
    
    @GET
    @Path("findByTotalCalorieBurned/{totalCalorieBurned}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findByTotalCalorieBurned(@PathParam("totalCalorieBurned") Integer totalCalorieBurned){
        Query query = em.createNamedQuery("Report.findByTotalCalorieBurned");
        query.setParameter("totalCalorieBurned", totalCalorieBurned);
        return query.getResultList();
    }
    
    @GET
    @Path("findByTotalSteps/{totalSteps}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findByTotalSteps(@PathParam("totalSteps") Integer totalSteps){
        Query query = em.createNamedQuery("Report.findByTotalSteps");
        query.setParameter("totalSteps", totalSteps);
        return query.getResultList();
    }
    
    @GET
    @Path("findByCalorieGoal/{calorieGoal}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findByCalorieGoal(@PathParam("calorieGoal") Integer calorieGoal){
        Query query = em.createNamedQuery("Report.findByCalorieGoal");
        query.setParameter("calorieGoal", calorieGoal);
        return query.getResultList();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
