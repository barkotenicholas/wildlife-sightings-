import model.Animal;
import model.EndangeredAnimal;
import model.NormalAnimal;
import model.Ranger;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;



public class App {
    public static void main(String[] args) {


        get("/",(request, response) -> {
          return new ModelAndView(new HashMap<>(),"index.hbs");
        },new HandlebarsTemplateEngine());

        get("/viewanimals",(request, response) -> {

            Map<String ,Object> model = new HashMap<>();
            model.put("animals",NormalAnimal.all());
            model.put("endangeredAnimals",EndangeredAnimal.all());

            return new ModelAndView(model,"animal.hbs");
        },new HandlebarsTemplateEngine());

        get("/animal/new",(request, response) -> {

            return new ModelAndView(new HashMap<>(),"animalsnew.hbs");
        },new HandlebarsTemplateEngine());

        get("/endangered/new",(request, response) -> {


            return new ModelAndView(new HashMap<>(),"endangerednew.hbs");
        },new HandlebarsTemplateEngine());

        get("/rangers",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            model.put("rangers",Ranger.all());
            return new ModelAndView(model,"ViewRangers.hbs");
        },new HandlebarsTemplateEngine());

        get("/newranger",(request, response) -> {
            return new ModelAndView(new HashMap<>(),"rangernew.hbs");
        },new HandlebarsTemplateEngine());

        post("/addnewranger",(request, response) -> {
            String rangerName = request.queryParams("rangerName");
            String rangerID = request.queryParams("rangerID");
            Map<String,Object> model = new HashMap<>();
            model.put("animalName","Ranger "+rangerName);
            try {
                int rangerid = Integer.parseInt(rangerID);
                Ranger ranger = new Ranger(rangerName,rangerid);
                ranger.save();
            }catch ( IllegalArgumentException e){}

            return new ModelAndView(model,"success.hbs");

        },new HandlebarsTemplateEngine());
        post("/endangered/animal",(request, response) -> {
            String animalName = request.queryParams("animalName");
            String animalhealth = request.queryParams("animalhealth");
            String animalage = request.queryParams("animalage");
            Map<String,Object> model = new HashMap<>();

            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(animalName,animalhealth,animalage);
            endangeredAnimal.save();

            model.put("animalName","Endangered animal "+animalName);
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());
        post("/animal",(request, response) -> {
            Map<String, Object> model = new HashMap<>();


            String animalName = request.queryParams("animalName");

            try{
                NormalAnimal normalAnimal = new NormalAnimal(animalName);
                normalAnimal.save();
            }catch (IllegalArgumentException e){}

            model.put("animalName",animalName);
            return new ModelAndView(model,"success.hbs");

        },new HandlebarsTemplateEngine());
    }
}
