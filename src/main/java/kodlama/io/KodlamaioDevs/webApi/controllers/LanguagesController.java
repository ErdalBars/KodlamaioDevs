package kodlama.io.KodlamaioDevs.webApi.controllers;

import kodlama.io.KodlamaioDevs.business.abstracts.LanguageService;
import kodlama.io.KodlamaioDevs.business.requests.languages.CreateLanguageRequest;
import kodlama.io.KodlamaioDevs.business.requests.languages.DeleteLanguageRequest;
import kodlama.io.KodlamaioDevs.business.requests.languages.UpdateLanguageRequest;
import kodlama.io.KodlamaioDevs.business.responses.languages.GetAllLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;

    }

    @GetMapping("/getAll")
    public List<GetAllLanguageResponse> getAll() {
        return languageService.getAll();
    }

    @PostMapping("/add")
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
        this.languageService.add(createLanguageRequest);

    }

    @DeleteMapping("/delete")
    public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {
        this.languageService.delete(deleteLanguageRequest);
    }

    @PutMapping("/update")
    public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
        this.languageService.update(updateLanguageRequest);

    }

}
