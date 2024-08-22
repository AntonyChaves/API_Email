package com.MS.Email.Repository;

import com.MS.Email.Model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
}

//Classe Repository para usar métodos JPA no email