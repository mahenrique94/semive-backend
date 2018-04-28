package br.com.matheuscastiglioni.semivebackend.domain.state;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class StateService extends GenericService<State, StateRepository, Integer> {

    public StateService(StateRepository repository) {
        super(repository);
    }

}
