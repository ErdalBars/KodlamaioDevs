package kodlama.io.KodlamaioDevs.business.concretes;

import kodlama.io.KodlamaioDevs.business.abstracts.LanguageService;
import kodlama.io.KodlamaioDevs.business.requests.languages.CreateLanguageRequest;
import kodlama.io.KodlamaioDevs.business.requests.languages.DeleteLanguageRequest;
import kodlama.io.KodlamaioDevs.business.requests.languages.UpdateLanguageRequest;
import kodlama.io.KodlamaioDevs.business.responses.languages.GetAllLanguageResponse;
import kodlama.io.KodlamaioDevs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.KodlamaioDevs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        super();
        this.languageRepository = languageRepository;

    }

    @Override
    public List<GetAllLanguageResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguageResponse> languageResponse = new ArrayList<GetAllLanguageResponse>();
        for (Language language : languages) {
            GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getLanguageName());
            languageResponse.add(responseItem);

        }
        return languageResponse;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
        if (createLanguageRequest.getName().isEmpty()) throw new Exception("Dil ismi boş geçilemez");
        else if (isNameExist(createLanguageRequest.getName())) {
            throw new Exception("Dil ismi tekrar edemez");
        } else {
            Language language = new Language();
            language.setLanguageName(createLanguageRequest.getName());
            languageRepository.save(language);
        }

    }

    private boolean isNameExist(String name) {
        for (GetAllLanguageResponse getAllLanguageResponse : getAll()) {
            if (name.equals(getAllLanguageResponse.getName())) {
                return true;
            }
        }
        return false;


    }

    private boolean isIdExist(int id) {
        for (GetAllLanguageResponse language : getAll()) {
            if (language.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private boolean isNameEmpty(String name) {
        if (name.isEmpty()) return true;
        return false;
    }


    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
        Language language = this.languageRepository.findById(updateLanguageRequest.getId()).get();
        if (isNameExist(updateLanguageRequest.getName())) throw new Exception("Bu dil zaten kayıtlı");
        if (isNameEmpty(updateLanguageRequest.getName())) throw new Exception("Dil ismi boş geçilemez");
        language.setLanguageName(updateLanguageRequest.getName());
        this.languageRepository.save(language);

    }

    @Override
    public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {
        if (!isIdExist(deleteLanguageRequest.getId())) throw new Exception("İd bulunamadı");
        this.languageRepository.deleteById(deleteLanguageRequest.getId());

    }
}
