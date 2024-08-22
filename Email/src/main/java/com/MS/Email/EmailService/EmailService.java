package com.MS.Email.EmailService;

import com.MS.Email.Model.EmailModel;
import com.MS.Email.Repository.EmailRepository;
import com.MS.Email.enums.StatusEmail;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;  //Injeção de dependência da classe email Repository

    @Autowired
    private JavaMailSender emailSender; //Injeção de dependência da classe JavaMailSender,
                                        //Responsável por montar e enviar emails

    public EmailModel sendEmail(EmailModel emailModel) {    //Função para enviar emails

        emailModel.setSendDateEmail(LocalDateTime.now());   //Setando a data em que acontece o envio

        try{      //Bloco de código sensível que iremos rodar mas com o catch ao lado caso haja erros

            SimpleMailMessage message = new SimpleMailMessage();  //Criando objeto message (email para envio)
            message.setFrom(emailModel.getEmailFrom());           //Setando o endereço de email de quem envia
            message.setTo(emailModel.getEmailTO());             //Setando o endereço de email de quem recebe
            message.setSubject(emailModel.getSubject());        //Setando assunto, ou seja o título
            message.setText(emailModel.getText());             //Setando o texto do email
            emailSender.send(message);                      //Enviando o email

            emailModel.setStatusEmail(StatusEmail.SENT);    //Setando o email como enviado
        }
        catch (MailException e){                            //Caso haja algúm problema no envio do email
            emailModel.setStatusEmail(StatusEmail.ERROR);   //Setando o envio do email como error
        }
        finally {       //Ação que será realizada não importa se o email foi enviado com sucesso ou não
            return emailRepository.save(emailModel);        //Salvando o email enviado ou não no banco de dados
        }

    }
}
