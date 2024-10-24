package com.restart.cards.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditor")
public class ImpAuditorAware implements AuditorAware {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("CARDS_MS");
    }
}
