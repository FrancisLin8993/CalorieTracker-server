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
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restws.Consumption;

/**
 *
 * @author fengcilin
 */
@Stateless
@Path("restws.consumption")
public class ConsumptionFacadeREST extends AbstractFacade<Consumption> {

    @PersistenceContext(unitName = "FIT5046-ServerPU")
    private EntityManager em;

    public ConsumptionFacadeREST() {
        super(Consumption.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Consumption entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Consumption entity) {
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
    public Consumption find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("findByDate/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findByDate(@PathParam("date") String date) {
        Query query = em.createNamedQuery("Consumption.findByDate");
        Date sqlDate = Date.valueOf(LocalDate.parse(date));
        query.setParameter("date", sqlDate);
        return query.getResultList();
    }

    @GET
    @Path("findByQuantity/{quantity}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findByQuantity(@PathParam("quantity") Integer quantity) {
        Query query = em.createNamedQuery("Consumption.findByQuantity");
        query.setParameter("quantity", quantity);
        return query.getResultList();
    }

    //Task 2a
    @GET
    @Path("findByFoodId/{foodId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findByFoodId(@PathParam("foodId") Integer foodId) {
        Query query = em.createNamedQuery("Consumption.findByFoodId");
        query.setParameter("foodId", foodId);
        return query.getResultList();
    }

    //Task 2a
    @GET
    @Path("findByUserId/{userId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findByUserId(@PathParam("userId") Integer userId) {
        Query query = em.createNamedQuery("Consumption.findByUserId");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    //Task 3b
    @GET
    @Path("findByUserIdANDdate/{userId}/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findByUserIdANDdate(@PathParam("userId") Integer userId,
            @PathParam("date") String date) {
        TypedQuery<Consumption> query = em.createQuery("SELECT c FROM Consumption c WHERE c.userId.userId = :userId AND c.date = :date", Consumption.class);
        query.setParameter("userId", userId);
        Date sqlDate = Date.valueOf(LocalDate.parse(date));
        query.setParameter("date", sqlDate);
        return query.getResultList();
    }

    //Task 3c
    @GET
    @Path("findByQuantityANDFoodName/{quantity}/{foodName}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findByQuantityANDFoodName(@PathParam("quantity") Integer quantity,
            @PathParam("foodName") String foodName) {
        TypedQuery<Consumption> query = em.createQuery("SELECT c FROM Consumption c WHERE c.quantity = :quantity AND c.foodId.name = :foodName", Consumption.class);
        query.setParameter("quantity", quantity);
        query.setParameter("foodName", foodName);
        return query.getResultList();
    }

    //Task 4d
    @GET
    @Path("calculateTotalCaloriesConsumed/{userId}/{date}")
    @Produces({MediaType.TEXT_PLAIN})
    public Integer calculateTotalCaloriesConsumed(@PathParam("userId") Integer userId,
            @PathParam("date") String date) {
        //Retrieve the consumption list by userId and date
        List<Consumption> consumptionList = findByUserIdANDdate(userId, date);
        //Calculate the calorie of individual food and add up       
        int totalCaloriesConsumed = consumptionList.stream().mapToInt(consumption -> {
            return consumption.getFoodId().getCalorieAmount() * consumption.getQuantity();
        }).sum();
        return totalCaloriesConsumed;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
