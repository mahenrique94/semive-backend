package br.com.matheuscastiglioni.semivebackend.domain.unity;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unity")
public class UnityController extends GenericController<Unity, UnityService, Integer> {

    public UnityController(UnityService service) {
        super(service);
    }

}
