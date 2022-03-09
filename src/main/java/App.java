import model.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.Timestamp;
import java.util.*;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/viewanimals", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            try{
                model.put("animals", NormalAnimal.all());
                model.put("endangeredAnimals", EndangeredAnimal.all());

            }catch (Exception e){
                System.out.println(e);
            }

            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animal/new", (request, response) -> {

            return new ModelAndView(new HashMap<>(), "animalsnew.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered/new", (request, response) -> {


            return new ModelAndView(new HashMap<>(), "endangerednew.hbs");
        }, new HandlebarsTemplateEngine());

        get("/rangers", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("rangers", Ranger.all());
            return new ModelAndView(model, "ViewRangers.hbs");
        }, new HandlebarsTemplateEngine());

        get("/newranger", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "rangernew.hbs");
        }, new HandlebarsTemplateEngine());

        get("/location",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> location = new ArrayList<>();

            location.add("ZoneA");
            location.add("ZoneB");
            location.add("ZoneC");
            location.add("ZoneD");
            model.put("location", location);
            return new ModelAndView(model, "location.hbs");

        },new HandlebarsTemplateEngine());

        get("/viewsightings", (request, response) -> {

            Map<String,Object> model = new HashMap<>();
            model.put("sightings",Sighting.all());


            return new ModelAndView(model,"sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/location/:local",(request, response) -> {
            String location = request.params(":local");
            Map<String,Object> model = new HashMap<>();
            model.put("sightings",Sighting.findall(location));
            return new ModelAndView(model,"sightings.hbs");
        },new HandlebarsTemplateEngine());
        get("/addsighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<String> location = new ArrayList<>();

            location.add("ZoneA");
            location.add("ZoneB");
            location.add("ZoneC");
            location.add("ZoneD");
            model.put("location", location);

            model.put("ranger", Ranger.all());
            model.put("animal", NormalAnimal.all());
            model.put("Eanimal", EndangeredAnimal.all());

            return new ModelAndView(model, "sighting.hbs");
        }, new HandlebarsTemplateEngine());

        post("/newsighting", (request, response) -> {
            String animal_id = request.queryParams("animal");
            String location = request.queryParams("location");
            String rangerid = request.queryParams("ranger");
            Map<String, Object> model = new HashMap<>();
            try {
                Timestamp now = new Timestamp(new Date().getTime());
                int animal = Integer.parseInt(animal_id);
                int ranger_id = Integer.parseInt(rangerid);
                Sighting sighting = new Sighting(animal, location, now, ranger_id);
                sighting.save();

                model.put("animalName", "sighting at location " + location);
            } catch (IllegalArgumentException ignored) {

            }

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/addnewranger", (request, response) -> {
            String rangerName = request.queryParams("rangerName");
            String rangerID = request.queryParams("rangerID");
            Map<String, Object> model = new HashMap<>();
            model.put("animalName", "Ranger " + rangerName);
            try {
                int rangerid = Integer.parseInt(rangerID);
                Ranger ranger = new Ranger(rangerName, rangerid);
                ranger.save();
            } catch (IllegalArgumentException e) {
            }

            return new ModelAndView(model, "success.hbs");

        }, new HandlebarsTemplateEngine());
        post("/endangered/animal", (request, response) -> {
            String animalName = request.queryParams("animalName");
            String animalhealth = request.queryParams("animalhealth");
            String animalage = request.queryParams("animalage");
            Map<String, Object> model = new HashMap<>();

            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(animalName, animalhealth, animalage);
            endangeredAnimal.save();

            model.put("animalName", "Endangered animal " + animalName);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        post("/animal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();


            String animalName = request.queryParams("animalName");

            try {
                NormalAnimal normalAnimal = new NormalAnimal(animalName);
                normalAnimal.save();
            } catch (IllegalArgumentException e) {
            }

            model.put("animalName", animalName);
            return new ModelAndView(model, "success.hbs");

        }, new HandlebarsTemplateEngine());
    }
}
