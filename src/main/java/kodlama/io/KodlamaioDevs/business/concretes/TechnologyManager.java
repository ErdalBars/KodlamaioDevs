package kodlama.io.KodlamaioDevs.business.concretes;

import kodlama.io.KodlamaioDevs.business.abstracts.TechnologyService;
import kodlama.io.KodlamaioDevs.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.KodlamaioDevs.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.KodlamaioDevs.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.KodlamaioDevs.business.responses.technologies.GetAllTechnologiesResponse;
import kodlama.io.KodlamaioDevs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.KodlamaioDevs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.KodlamaioDevs.entities.concretes.Language;
import kodlama.io.KodlamaioDevs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {
    private TechnologyRepository technologyRepository;
    private LanguageRepository languageRepository;

    public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
        super();
        this.technologyRepository = technologyRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllTechnologiesResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologiesResponse> technologyResponse = new ArrayList<GetAllTechnologiesResponse>();
        for (Technology technology : technologies) {
            GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
            responseItem.setId(technology.getId());
            responseItem.setName(technology.getName());
            technologyResponse.add(responseItem);

        }
        return technologyResponse;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        Technology technology = new Technology();
        Language language = this.languageRepository.findById(createTechnologyRequest.getLanguageId()).get();
        if (createTechnologyRequest.getName().isEmpty()) {
            throw new Exception("Teknoloji adı boş geçilemez");
        } else if (isNameExist(createTechnologyRequest.getName())) throw new Exception("Teknoloji ismi tekrar edemez");
        else {
            technology.setName(createTechnologyRequest.getName());
            technology.setLanguage(language);
            technologyRepository.save(technology);
        }

    }

    private boolean isNameExist(String name) {
        for (GetAllTechnologiesResponse getAllTechnologiesResponse : getAll()) {
            if (name.equals(getAllTechnologiesResponse.getName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isIdExist(int id) {
        for (GetAllTechnologiesResponse technology : getAll()) {
            if (technology.getId() == id) return true;
        }
        return false;
    }

    private boolean isNameEmpty(String name) {
        if (name.isEmpty()) return true;
        return false;
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        Technology technology = this.technologyRepository.findById(updateTechnologyRequest.getId()).get();
        Language language = this.languageRepository.findById(updateTechnologyRequest.getLanguageId()).get();
        if (isNameExist(updateTechnologyRequest.getName())) throw new Exception("Bu dil zaten kayıtlı");
        if (isNameEmpty(updateTechnologyRequest.getName())) throw new Exception("Dil ismi boş geçilemez.");
        technology.setName(updateTechnologyRequest.getName());
        technology.setLanguage(language);
        this.technologyRepository.save(technology);

    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
        if (!isIdExist(deleteTechnologyRequest.getId())) throw new Exception("Teknoloji id bulunamadı");
        this.technologyRepository.deleteById(deleteTechnologyRequest.getId());

    }
}
