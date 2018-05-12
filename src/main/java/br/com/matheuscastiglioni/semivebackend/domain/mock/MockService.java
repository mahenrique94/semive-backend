package br.com.matheuscastiglioni.semivebackend.domain.mock;

import br.com.matheuscastiglioni.semivebackend.domain.address.type.AddressType;
import br.com.matheuscastiglioni.semivebackend.domain.city.City;
import br.com.matheuscastiglioni.semivebackend.domain.document.type.DocumentType;
import br.com.matheuscastiglioni.semivebackend.domain.order.Order;
import br.com.matheuscastiglioni.semivebackend.domain.order.OrderRepository;
import br.com.matheuscastiglioni.semivebackend.domain.order.item.OrderItem;
import br.com.matheuscastiglioni.semivebackend.domain.order.item.OrderItemRepository;
import br.com.matheuscastiglioni.semivebackend.domain.order.value.OrderValue;
import br.com.matheuscastiglioni.semivebackend.domain.order.value.OrderValueRepository;
import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import br.com.matheuscastiglioni.semivebackend.domain.person.PersonRepository;
import br.com.matheuscastiglioni.semivebackend.domain.person.address.PersonAddress;
import br.com.matheuscastiglioni.semivebackend.domain.person.address.PersonAddressRepository;
import br.com.matheuscastiglioni.semivebackend.domain.person.contact.PersonContact;
import br.com.matheuscastiglioni.semivebackend.domain.person.contact.PersonContactRepository;
import br.com.matheuscastiglioni.semivebackend.domain.person.definition.PersonDefinition;
import br.com.matheuscastiglioni.semivebackend.domain.person.definition.PersonDefinitionRepository;
import br.com.matheuscastiglioni.semivebackend.domain.person.document.PersonDocument;
import br.com.matheuscastiglioni.semivebackend.domain.person.document.PersonDocumentRepository;
import br.com.matheuscastiglioni.semivebackend.domain.person.group.PersonGroup;
import br.com.matheuscastiglioni.semivebackend.domain.product.Product;
import br.com.matheuscastiglioni.semivebackend.domain.product.ProductRepository;
import br.com.matheuscastiglioni.semivebackend.domain.product.cattegory.ProductCattegory;
import br.com.matheuscastiglioni.semivebackend.domain.product.cattegory.ProductCattegoryRepository;
import br.com.matheuscastiglioni.semivebackend.domain.product.stock.ProductStock;
import br.com.matheuscastiglioni.semivebackend.domain.product.stock.ProductStockRepository;
import br.com.matheuscastiglioni.semivebackend.domain.product.type.ProductType;
import br.com.matheuscastiglioni.semivebackend.domain.product.type.ProductTypeRepository;
import br.com.matheuscastiglioni.semivebackend.domain.product.value.ProductValue;
import br.com.matheuscastiglioni.semivebackend.domain.product.value.ProductValueRepository;
import br.com.matheuscastiglioni.semivebackend.domain.unity.Unity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    private final ProductStockRepository productStockRepository;
    private final ProductValueRepository productValueRepository;

    @Autowired
    public MockService(OrderValueRepository orderValueRepository, OrderItemRepository orderItemRepository, OrderRepository orderRepository, PersonRepository personRepository, PersonAddressRepository personAddressRepository, PersonContactRepository personContactRepository, PersonDefinitionRepository personDefinitionRepository, PersonDocumentRepository personDocumentRepository, ProductCattegoryRepository productCattegoryRepository, ProductTypeRepository productTypeRepository, ProductRepository productRepository, ProductStockRepository productStockRepository, br.com.matheuscastiglioni.semivebackend.domain.product.value.ProductValueRepository productValueRepository) {
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
        this.productStockRepository = productStockRepository;
        this.productValueRepository = productValueRepository;
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

        this.productValueRepository.deleteAll();
        this.productStockRepository.deleteAll();
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

        this.personAddressRepository.save(new PersonAddress(p1, new City(3530706), new AddressType(1), "Rua Teste", "1", "13845-000", "Teste"));
        this.personAddressRepository.save(new PersonAddress(p2, new City(3530805), new AddressType(1), "Rua Teste Dois", "12", "13845-100", "Teste Dois"));
        this.personAddressRepository.save(new PersonAddress(p3, new City(3530706), new AddressType(3), "Rua Teste Tres", "123", "13845-120", "Teste Tres"));
        this.personAddressRepository.save(new PersonAddress(p4, new City(3530805), new AddressType(4), "Rua Teste Quatro", "1234", "13845-123", "Teste Quatro"));
        this.personAddressRepository.save(new PersonAddress(p5, new City(3522604), new AddressType(2), "Rua Teste Cinco", "12345", "13845-200", "Teste Cinco"));

        this.personContactRepository.save(new PersonContact(p1, "Damodara Naveen", "damodaranaveen@teste.com"));
        this.personContactRepository.save(new PersonContact(p2, "Theodulus Manish", "theodulusmanish@teste.com"));
        this.personContactRepository.save(new PersonContact(p3, "Isaak Amaal", "isaakamaal@teste.com"));
        this.personContactRepository.save(new PersonContact(p4, "Osberht Naoki", "osberhtnaoki@teste.com"));
        this.personContactRepository.save(new PersonContact(p5, "Shura Shirou", "shurashirou@teste.com"));

        this.personDefinitionRepository.save(new PersonDefinition(p1, new PersonGroup(1)));
        this.personDefinitionRepository.save(new PersonDefinition(p2, new PersonGroup(1)));
        this.personDefinitionRepository.save(new PersonDefinition(p3, new PersonGroup(2)));
        this.personDefinitionRepository.save(new PersonDefinition(p4, new PersonGroup(2)));
        this.personDefinitionRepository.save(new PersonDefinition(p5, new PersonGroup(1)));

        this.personDocumentRepository.save(new PersonDocument(p1, new DocumentType(1), "123.456.789-12"));
        this.personDocumentRepository.save(new PersonDocument(p2, new DocumentType(2), "12.345.678-9"));
        this.personDocumentRepository.save(new PersonDocument(p3, new DocumentType(2), "12.345.678-1"));
        this.personDocumentRepository.save(new PersonDocument(p4, new DocumentType(1), "321.4654.789-21"));
        this.personDocumentRepository.save(new PersonDocument(p5, new DocumentType(2), "12.345.678-0"));

        ProductCattegory c1 = this.productCattegoryRepository.save(new ProductCattegory("Testando"));
        ProductCattegory c2 = this.productCattegoryRepository.save(new ProductCattegory("Testando Dois"));
        ProductCattegory c3 = this.productCattegoryRepository.save(new ProductCattegory("Testando Tres"));

        ProductType t1 = this.productTypeRepository.save(new ProductType(c1, "Testando"));
        ProductType t2 = this.productTypeRepository.save(new ProductType(c2, "Testando Dois"));
        ProductType t3 = this.productTypeRepository.save(new ProductType(c3, "Testando Tres"));

        Product pr1 = this.productRepository.save(new Product(t1, new Unity(1), "Testando", "Teste"));
        Product pr2 = this.productRepository.save(new Product(t2, new Unity(2), "Testando Dois", "Teste Dois"));
        Product pr3 = this.productRepository.save(new Product(t3, new Unity(3), "Testando Tres", "Teste Tres"));

        this.productStockRepository.save(new ProductStock(pr1));
        this.productStockRepository.save(new ProductStock(pr2));
        this.productStockRepository.save(new ProductStock(pr3));

        this.productValueRepository.save(new ProductValue(pr1));
        this.productValueRepository.save(new ProductValue(pr2));
        this.productValueRepository.save(new ProductValue(pr3));

        Order o1 = this.orderRepository.save(new Order(p1, Instant.now()));
        Order o2 = this.orderRepository.save(new Order(p2, Instant.now()));
        Order o3 = this.orderRepository.save(new Order(p3, Instant.now()));

        this.orderItemRepository.save(new OrderItem(o1, pr1, new BigDecimal(10)));
        this.orderItemRepository.save(new OrderItem(o2, pr2, new BigDecimal(20)));
        this.orderItemRepository.save(new OrderItem(o3, pr3, new BigDecimal(30)));

        this.orderValueRepository.save(new OrderValue(o1));
        this.orderValueRepository.save(new OrderValue(o2));
        this.orderValueRepository.save(new OrderValue(o3));

        return "Database has been mocked";
    }
}
