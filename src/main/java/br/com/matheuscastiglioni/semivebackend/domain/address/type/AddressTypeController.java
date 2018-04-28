package br.com.matheuscastiglioni.semivebackend.domain.address.type;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address/type")
public class AddressTypeController extends GenericController<AddressType, AddressTypeService, Integer> {

    public AddressTypeController(AddressTypeService service) {
        super(service);
    }

}
