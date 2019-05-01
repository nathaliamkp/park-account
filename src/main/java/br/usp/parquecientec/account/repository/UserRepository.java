package br.usp.parquecientec.account.repository;

import br.usp.parquecientec.account.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer> {

}
