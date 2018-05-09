package br.com.matheuscastiglioni.semivebackend.domain.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mock")
public class MockController {

    private final MockService mockService;

    @Autowired
    public MockController(MockService mockService) {
        this.mockService = mockService;
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok(this.mockService.delete());
    }

    @PostMapping
    public ResponseEntity<String> seed() {
        return ResponseEntity.ok(this.mockService.seed());
    }

}
