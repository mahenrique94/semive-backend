package br.com.matheuscastiglioni.semivebackend.domain.document;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("document/type")
public class DocumentTypeController extends GenericController<DocumentType, DocumentTypeService, Integer> {

    public DocumentTypeController(DocumentTypeService service) {
        super(service);
    }

}
