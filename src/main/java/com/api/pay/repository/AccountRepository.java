package com.api.pay.repository;

import com.api.pay.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    /*
    @Query(
            "SELECT ac FROM Account ac WHERE ac.cpfCnpj = :CPF_CNPJ or ac.email = :EMAIL"
    )*/

//    Account findByCpfCnpjOrEmail(@Param("CPF_CNPJ") String cpfCnpj, @Param("EMAIL") String email);

    Account findByCpfCnpjOrEmail(String cpfCnpj, String email);

}
