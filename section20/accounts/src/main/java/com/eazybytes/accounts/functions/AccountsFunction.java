package com.eazybytes.accounts.functions;

import com.eazybytes.accounts.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class AccountsFunction {

    @Bean
    public Consumer<Long> updateCommunication(AccountService accountService) {
        return accountNumber -> {
            log.info("Updating Communication Status for the account number: {}", accountNumber);
            accountService.updateCommunicationStatus(accountNumber);
        };
    }
}
