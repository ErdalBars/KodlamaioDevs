package kodlama.io.KodlamaioDevs.business.abstracts;

import kodlama.io.KodlamaioDevs.business.requests.languages.CreateLanguageRequest;
import kodlama.io.KodlamaioDevs.business.requests.languages.DeleteLanguageRequest;
import kodlama.io.KodlamaioDevs.business.requests.languages.UpdateLanguageRequest;
import kodlama.io.KodlamaioDevs.business.responses.languages.GetAllLanguageResponse;

import java.util.List;

public interface LanguageService {
    List<GetAllLanguageResponse> getAll();

    void add(CreateLanguageRequest createLanguageRequest) throws Exception;

    void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;

    void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;
}
