package controller;

import deneme.model.Projects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController // Http isteklerini yakalayan bir denetleyici
@RequestMapping("/api")
public class ProjectsController {
    List<Projects> liste = new ArrayList<>();
    @RequestMapping(value = "/api/POST",method = RequestMethod.POST)
    public ResponseEntity<String> createProjects(@RequestBody Projects p){
        System.out.println("id"+p.getId());
        System.out.println("name"+p.getName());
        System.out.print("description"+p.getDescription());
        liste.add(p);
        return new ResponseEntity<>("projects oluşturuldu.",HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/api/GET",method =RequestMethod.GET)
    public ResponseEntity<List<Projects>>getProcets(){
        System.out.println("Liste boyu"+liste.size());
        return new ResponseEntity<>(liste,HttpStatus.OK);
    }
/*
    @RequestMapping(value = "/api/{id}",method = RequestMethod.GET)
        public ResponseEntity<Projects> getById(@PathVariable("id") int id){
            for (Projects p:liste){
                if(p.getId() == id){
                    return new ResponseEntity<>(p, HttpStatus.OK);
                }
            }
            return new ResponseEntity<>("bulamadım", HttpStatus.NOT_FOUND);
        }
*/

/*

    private final ProjectsRepository projectsRepository;

    @Autowired
    public ProjectsController (ProjectsRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
*/

   // @RequestMapping(value = "/api/{id}",method = GET)
    //public Projects getId(@PathVariable int id){
       // return ProjectsRepository.findOne(id);
    //}


   /* @GetMapping("/api/{id}") //regular expressions parametresi alıyor. sadece id leri getiricek.:8080 adresine gelen get isteklerini alıyor
    int searchId(@RequestParam int id) {
        return projectsRepository.findbyId(id);
    }
*/

}
