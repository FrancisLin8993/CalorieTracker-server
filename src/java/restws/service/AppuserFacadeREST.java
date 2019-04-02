/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws.service;

import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
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
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Appuser entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_JSON})
    public Appuser find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByFirstname/{firstname}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findByFirstname(@PathParam("firstname") String firstname){
        Query query = em.createNamedQuery("Appuser.findByFirstname");
        query.setParameter("firstname", firstname);
        return query.getResultList();
    }
    
    @GET
    @Path("findBySurname/{surname}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findByLastname(@PathParam("surname") String surname){
        Query query = em.createNamedQuery("Appuser.findBySurname");
        query.setParameter("surname", surname);
        return query.getResultList();
    }
    
    //Task 3b
    @GET
    @Path("findByFirstnameANDSurname/{firstname}/{surname}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findByFirstnameANDSurname(@PathParam("firstname") String firstname, @PathParam("surname") String surname){
        TypedQuery<Appuser> query = em.createQuery("SELECT a FROM Appuser a WHERE a.firstname = :firstname AND a.surname = :surname", Appuser.class);
        query.setParameter("firstname", firstname);
        query.setParameter("surname", surname);
        return query.getResultList();
    }
    
    @GET
    @Path("findByEmail/{email}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findByEmail(@PathParam("email") String email){
        Query query = em.createNamedQuery("Appuser.findByEmail");
        query.setParameter("email", email);
        return query.getResultList();
    }
    
    @GET
    @Path("findByDob/{dob}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findByDob(@PathParam("dob") String dob){
        Query query = em.createNamedQuery("Appuser.findByDob");
        Date sqlDate = Date.valueOf(LocalDate.parse(dob));
        query.setParameter("dob", sqlDate);
        return query.getResultList();
    }
    
    @GET
    @Path("findByHeight/{height}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findByHeight(@PathParam("height") String height){
        Query query = em.createNamedQuery("Appuser.findByHeight");
        query.setParameter("height", new BigDecimal(height));
        return query.getResultList();
    }
    
    @GET
    @Path("findByWeight/{weight}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findByWeight(@PathParam("weight") String weight){
        Query query = em.createNamedQuery("Appuser.findByWeight");
        query.setParameter("weight", new BigDecimal(weight));
        return query.getResultList();
    }
    
    @GET
    @Path("findByGender/{gender}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findByGender(@PathParam("gender") String gender){
        Query query = em.createNamedQuery("Appuser.findByGender");
        query.setParameter("gender", gender.charAt(0));
        return query.getResultList();
    }
    
    @GET
    @Path("findByAddress/{address}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findByAddress(@PathParam("address") String address){
        Query query = em.createNamedQuery("Appuser.findByAddress");
        query.setParameter("address", address);
        return query.getResultList();
    }
    
    @GET
    @Path("findByPostcode/{postcode}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findByPostcode(@PathParam("postcode") String postcode){
        Query query = em.createNamedQuery("Appuser.findByPostcode");
        query.setParameter("postcode", postcode);
        return query.getResultList();
    }
    
    @GET
    @Path("findByLevelOfActivity/{levelOfActivity}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findByLevelOfActivity(@PathParam("levelOfActivity") String levelOfActivity){
        Query query = em.createNamedQuery("Appuser.findByLevelOfActivity");
        query.setParameter("levelOfActivity", levelOfActivity.charAt(0));
        return query.getResultList();
    }
    
    @GET
    @Path("findByStepsPerMile/{stepsPerMile}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findByStepsPerMile(@PathParam("stepsPerMile") Integer stepsPerMile){
        Query query = em.createNamedQuery("Appuser.findByStepsPerMile");
        query.setParameter("stepsPerMile", stepsPerMile);
        return query.getResultList();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Appuser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    //Task 4a
    @GET
    @Path("calculateCaloriesBurnedPerStep/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public JsonArray calculateCaloriesBurnedPerStep(@PathParam("userId") Integer userId){
        Appuser user = find(userId);
        int stepsPerMile = user.getStepsPerMile();
        BigDecimal weight = BigDecimal.valueOf(user.getWeight());
        weight = weight.multiply(new BigDecimal(2.205));
        BigDecimal caloriesBurnedPerMile = weight.multiply(new BigDecimal(0.49));      
        BigDecimal caloriesBurnedPerStep = caloriesBurnedPerMile.divide(new BigDecimal(stepsPerMile), 3, HALF_UP);
        //form the result into json format
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        JsonObject resultObject = Json.createObjectBuilder()
                .add("caloriesBurnedPerStep", caloriesBurnedPerStep)
                .build();
        arrayBuilder.add(resultObject);
        JsonArray jsonArray = arrayBuilder.build();
        return jsonArray;
    }
    
    //Task 4b
    @GET
    @Path("calculateBMR/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public JsonArray calculateBMR(@PathParam("userId") Integer userId){
        //Retrieve the user 
        Appuser user = find(userId);
        //Get the value of corresponding attributes
        char gender = user.getGender();
        BigDecimal height = BigDecimal.valueOf(user.getHeight());
        BigDecimal weight = BigDecimal.valueOf(user.getWeight());
        //Convert sql Date to java LocalDate
        LocalDate dob = user.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        //Calculate age
        long age = ChronoUnit.YEARS.between(currentDate, dob);
        BigDecimal bigDecimalAge = new BigDecimal(age);
        BigDecimal bmr = BigDecimal.ZERO;
        //Calculate bmr
        if (gender == 'M') {
            bmr = weight.multiply(new BigDecimal(13.75))
                    .add(height.multiply(new BigDecimal(5.003)))
                    .subtract(bigDecimalAge.multiply(new BigDecimal(6.755)))
                    .add(new BigDecimal(66.5));        
        } else if (gender == 'F') {
            bmr = weight.multiply(new BigDecimal(9.563))
                    .add(height.multiply(new BigDecimal(1.85)))
                    .subtract(bigDecimalAge.multiply(new BigDecimal(4.676)))
                    .add(new BigDecimal(655.1));
        }
        //form the result into json format
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        JsonObject resultObject = Json.createObjectBuilder()
                .add("bmr", bmr.setScale(3, HALF_UP))
                .build();
        arrayBuilder.add(resultObject);
        JsonArray jsonArray = arrayBuilder.build();
        return jsonArray;
    }
    
    //Task 4c
    @GET
    @Path("calculateTotalCaloriesBurnedAtRest/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public JsonArray calculateTotalCaloriesBurnedAtRest(@PathParam("userId") Integer userId){
        Appuser user = find(userId);
        char levelOfActivity = user.getLevelOfActivity();
        //Define the 0.175 difference of the multiplied numbers in the formula between adjacent level of activity
        BigDecimal baseDifference = new BigDecimal(0.175);
        //Calculate the total difference needed to be added to the multiplied number based on level of activities of users.
        //For example, if a user's level of activity is 3,
        //The total difference should be 0.175 * (3 - 1) = 0.35
        //So the multiplied number of the formula should be 1.2 + 0.35 = 1.55
        BigDecimal difference = baseDifference.multiply(new BigDecimal(Character.getNumericValue(levelOfActivity) - 1));
        BigDecimal bmr = new BigDecimal(calculateBMR(userId).getJsonObject(0).getInt("bmr"));
        BigDecimal totalCaloriesBurnedAtRest = bmr.multiply(new BigDecimal(1.2).add(difference));
        //form the result into json format
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();        
        JsonObject resultObject = Json.createObjectBuilder()
                .add("totalCaloriesBurnedAtRest", totalCaloriesBurnedAtRest.setScale(3, HALF_UP))
                .build();
        arrayBuilder.add(resultObject);
        
        JsonArray jsonArray = arrayBuilder.build();
        return jsonArray;         
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
