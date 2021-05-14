package com.phoebelord.oapi;

import javax.validation.Valid;

import com.phoebelord.swagger.api.PetApi;
import com.phoebelord.swagger.model.Pet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Controller
@Validated
public class PetController implements PetApi {

  private Logger logger = LoggerFactory.getLogger(PetController.class);

  @Override
  public ResponseEntity<Void> addPet(@Valid Pet body) {
    logger.info("Request create pet: {}", body);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

}
