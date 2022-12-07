package kodlama.io.KodlamaioDevs.webApi.controllers;
import kodlama.io.KodlamaioDevs.business.abstracts.TechnologyService;
import kodlama.io.KodlamaioDevs.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.KodlamaioDevs.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.KodlamaioDevs.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.KodlamaioDevs.business.responses.technologies.GetAllTechnologiesResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
    private TechnologyService technologyService;


    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getAll")
    public List<GetAllTechnologiesResponse> getAll() {
        return technologyService.getAll();
    }

    @PostMapping("/add")
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        this.technologyService.add(createTechnologyRequest);
    }

    @PutMapping("/update")
    public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        this.technologyService.update(updateTechnologyRequest);

    }

    @DeleteMapping("/delete")
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
        this.technologyService.delete(deleteTechnologyRequest);
    }
}
