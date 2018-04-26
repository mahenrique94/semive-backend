package br.com.matheuscastiglioni.semivebackend.domain.document;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class DocumentTypeService extends GenericService<DocumentType, DocumentTypeRepository, Integer> {

    public DocumentTypeService(DocumentTypeRepository repository) {
        super(repository);
    }

}
