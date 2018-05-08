package br.com.matheuscastiglioni.semivebackend.domain.mock;

import br.com.matheuscastiglioni.semivebackend.domain.order.OrderRepository;
import br.com.matheuscastiglioni.semivebackend.domain.order.item.OrderItemRepository;
import br.com.matheuscastiglioni.semivebackend.domain.order.value.OrderValueRepository;
import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import br.com.matheuscastiglioni.semivebackend.domain.person.PersonRepository;
import br.com.matheuscastiglioni.semivebackend.domain.person.address.PersonAddressRepository;
import br.com.matheuscastiglioni.semivebackend.domain.person.contact.PersonContactRepository;
import br.com.matheuscastiglioni.semivebackend.domain.person.definition.PersonDefinitionRepository;
import br.com.matheuscastiglioni.semivebackend.domain.person.document.PersonDocumentRepository;
import br.com.matheuscastiglioni.semivebackend.domain.product.ProductRepository;
import br.com.matheuscastiglioni.semivebackend.domain.product.cattegory.ProductCattegoryRepository;
import br.com.matheuscastiglioni.semivebackend.domain.product.type.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class MockService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderValueRepository orderValueRepository;

    private final PersonRepository personRepository;
    private final PersonAddressRepository personAddressRepository;
    private final PersonContactRepository personContactRepository;
    private final PersonDefinitionRepository personDefinitionRepository;
    private final PersonDocumentRepository personDocumentRepository;

    private final ProductCattegoryRepository productCattegoryRepository;
    private final ProductTypeRepository productTypeRepository;
    private final ProductRepository productRepository;

    @Autowired
    public MockService(OrderValueRepository orderValueRepository, OrderItemRepository orderItemRepository, OrderRepository orderRepository, PersonRepository personRepository, PersonAddressRepository personAddressRepository, PersonContactRepository personContactRepository, PersonDefinitionRepository personDefinitionRepository, PersonDocumentRepository personDocumentRepository, ProductCattegoryRepository productCattegoryRepository, ProductTypeRepository productTypeRepository, ProductRepository productRepository) {
        this.orderValueRepository = orderValueRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.personRepository = personRepository;
        this.personAddressRepository = personAddressRepository;
        this.personContactRepository = personContactRepository;
        this.personDefinitionRepository = personDefinitionRepository;
        this.personDocumentRepository = personDocumentRepository;
        this.productCattegoryRepository = productCattegoryRepository;
        this.productTypeRepository = productTypeRepository;
        this.productRepository = productRepository;
    }

    public String delete() {
        this.orderValueRepository.deleteAll();
        this.orderItemRepository.deleteAll();
        this.orderRepository.deleteAll();

        this.personDocumentRepository.deleteAll();
        this.personDefinitionRepository.deleteAll();
        this.personContactRepository.deleteAll();
        this.personAddressRepository.deleteAll();
        this.personRepository.deleteAll();

        this.productRepository.deleteAll();
        this.productTypeRepository.deleteAll();
        this.productCattegoryRepository.deleteAll();
        return "Database has been unmocked";
    }

    public String seed() {
        Person p1 = this.personRepository.save(new Person("Damodara Naveen", "F", Instant.now()));
        Person p2 = this.personRepository.save(new Person("Theodulus Manish", "M", Instant.now()));
        Person p3 = this.personRepository.save(new Person("Isaak Amaal", "M", Instant.now()));
        Person p4 = this.personRepository.save(new Person("Osberht Naoki", "M", Instant.now()));
        Person p5 = this.personRepository.save(new Person("Shura Shirou", "F", Instant.now()));



        return "Database has been mocked";
    }
}
