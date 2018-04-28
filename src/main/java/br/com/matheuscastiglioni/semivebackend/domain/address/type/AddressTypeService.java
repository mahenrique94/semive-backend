package br.com.matheuscastiglioni.semivebackend.domain.address.type;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class AddressTypeService extends GenericService<AddressType, AddressTypeRepository, Integer> {

    public AddressTypeService(AddressTypeRepository repository) {
        super(repository);
    }

}
