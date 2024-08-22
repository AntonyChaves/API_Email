package com.MS.Email.Configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


    //Classe para configuração do RabbitMQ na API, aqui estamos criando a fila por onde irá passar as mensagens

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue}")      //Setando o valor da string com o valor da queue que foi digitada no
    private String queue;                   //application.properties

    @Bean
    Queue queue() {                    //Criando a queue, que irá retornar o caminho da queue passada antes
        return new Queue(queue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }   //Tipo de dado criádo para converter os valores que irão vir da fila para valores que possamos armazenar
}
