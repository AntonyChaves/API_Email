package com.MS.Email.EmailController;

import com.MS.Email.DTO.EmailDTO;
import com.MS.Email.EmailService.EmailService;
import com.MS.Email.Model.EmailModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
public class EmailController {


    @Autowired
    EmailService emailService; //Injeção de dependência da classe service


            //Método controller que irá receber as requisições HTTP

    @PostMapping("/sending_Email")          //Método responsável por enviar emails
    public ResponseEntity sendEmail (@RequestBody @Valid EmailDTO emailDTO){

        EmailModel emailModel = new EmailModel();           //Novo email
        BeanUtils.copyProperties(emailDTO, emailModel);     //Copia os dados do DTO
        emailService.sendEmail(emailModel);                 //Envia para a função do email Service
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);

    }
}
