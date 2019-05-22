package br.usp.parquecientec.account.util;

import br.usp.parquecientec.account.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {

    public void validate(User user) throws Exception {
        if (null == user.getFirstName() || user.getFirstName().isEmpty() || user.getFirstName().length() < 2) {
            throw new Exception();
        }

        if (null == user.getLastName() || user.getLastName().isEmpty()) {
            throw new Exception();
        }

        if (null == user.getDocumentCode() || user.getDocumentCode().isEmpty()) {
            throw new Exception();
        }

        if (null == user.getDocumentType() || user.getDocumentType().isEmpty()) {
            throw new Exception();
        }

        if (null == user.getBusinessRole() || user.getBusinessRole().isEmpty()) {
            throw new Exception();
        }

        if (null == user.getEmail() || user.getEmail().isEmpty()) {
            throw new Exception();
        }

        if (null == user.getPhone()|| user.getPhone().isEmpty()) {
            throw new Exception();
        }

    }

}