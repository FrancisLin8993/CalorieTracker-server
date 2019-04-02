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
import restws.Food;

/**
 *
 * @author fengcilin
 */
@Stateless
@Path("restws.food")
public class FoodFacadeREST extends AbstractFacade<Food> {

    @PersistenceContext(unitName = "FIT5046-ServerPU")
    private EntityManager em;

    public FoodFacadeREST() {
        super(Food.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Food entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Food entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Food find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByName/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Food> findByName(@PathParam("name") String name){
        Query query = em.createNamedQuery("Food.findByName");
        query.setParameter("name", name);
        return query.getResultList();
    }
    
    @GET
    @Path("findByCategory/{category}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Food> findByCategory(@PathParam("category") String category){
        Query query = em.createNamedQuery("Food.findByCategory");
        query.setParameter("category", category);
        return query.getResultList();
    }
    
    @GET
    @Path("findByCalorieAmount/{calorieAmount}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Food> findByCalorieAmount(@PathParam("calorieAmount") Integer calorieAmount){
        Query query = em.createNamedQuery("Food.findByCalorieAmount");
        query.setParameter("calorieAmount", calorieAmount);
        return query.getResultList();
    }
    
    @GET
    @Path("findByServingUnit/{servingUnit}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Food> findByServingUnit(@PathParam("servingUnit") String servingUnit){
        Query query = em.createNamedQuery("Food.findByServingUnit");
        query.setParameter("servingUnit", servingUnit);
        return query.getResultList();
    }
    
    @GET
    @Path("findByFat/{fat}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Food> findByFat(@PathParam("fat") Integer fat){
        Query query = em.createNamedQuery("Food.findByFat");
        query.setParameter("fat", fat);
        return query.getResultList();
    }
    
    @GET
    @Path("findByServingAmount/{servingAmount}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Food> findByServingAmount(@PathParam("servingAmount") String servingAmount){
        Query query = em.createNamedQuery("Food.findByServingAmount");
        query.setParameter("servingAmount", new BigDecimal(servingAmount));
        return query.getResultList();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Food> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Food> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
