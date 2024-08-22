package com.MS.Email.Consumers;

import com.MS.Email.DTO.EmailDTO;
import com.MS.Email.EmailService.EmailService;
import com.MS.Email.Model.EmailModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    //Nesta classe estamos definindo a classe que irá escutar a fila que configuramos no RabbitMQConfig e as
    //comunicações que saem de lá.


 //Aqui dizemos que a função irá escutar as requisições que o rebbitMQ envia através da fila setada no properties
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDTO){  //Aqui dizemos que iremos receber um DTO em formato Payload
        EmailModel emailModel = new EmailModel();    //Criamos o email novo
        BeanUtils.copyProperties(emailDTO, emailModel); //Convertemos os dados trazidos do DTO para o novo email
        emailService.sendEmail(emailModel);        //Enviamos para a classe service para que seja enviado e salvo
        System.out.println("Email Status: " + emailModel.getStatusEmail().toString());//Imprimimos o status do email
    }

}
