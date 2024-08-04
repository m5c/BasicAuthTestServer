package io.github.m5c.basicauthtest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DummyResource {

@GetMapping("dummyresource")
  public String getDummyResource() {
    return "OK!";
  }
}
