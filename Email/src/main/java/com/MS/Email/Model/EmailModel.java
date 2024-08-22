package com.MS.Email.Model;


import com.MS.Email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_email")       //Entidade que irá mapear os atributos de email que serão usados
public class EmailModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailID;                            //ID aleatório para cada email

    @Column
    private String ownerRef;                        //Referência para o dono do email

    @Column
    private String emailFrom;                       //Endereço de email do dono do email

    @Column
    private String emailTO;                        //Pessoa que irá receber o email

    @Column
    private String subject;                        // Assunto do email, ou seja, o título

    @Column(columnDefinition = "TEXT")
    private String text;                //O texto do email

    @Column
    private LocalDateTime sendDateEmail; //Uma variável local datetime para gravar a hora do envio

    @Column
    private StatusEmail statusEmail;    //Status do email, se ele foi enviado com sucesso ou não

    public String getOwnerRef() {
        return ownerRef;
    }

    public void setOwnerRef(String ownerRef) {
        this.ownerRef = ownerRef;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTO() {
        return emailTO;
    }

    public void setEmailTO(String emailTO) {
        this.emailTO = emailTO;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }
}
