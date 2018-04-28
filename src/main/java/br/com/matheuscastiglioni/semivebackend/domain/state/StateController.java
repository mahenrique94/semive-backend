package br.com.matheuscastiglioni.semivebackend.domain.state;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("state")
public class StateController extends GenericController<State, StateService, Integer> {

    public StateController(StateService service) {
        super(service);
    }

}
