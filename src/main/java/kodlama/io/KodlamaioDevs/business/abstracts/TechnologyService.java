package kodlama.io.KodlamaioDevs.business.abstracts;

import kodlama.io.KodlamaioDevs.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.KodlamaioDevs.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.KodlamaioDevs.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.KodlamaioDevs.business.responses.technologies.GetAllTechnologiesResponse;

import java.util.List;

public interface TechnologyService {
    List<GetAllTechnologiesResponse> getAll();

    void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;

    void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;

    void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;
}
