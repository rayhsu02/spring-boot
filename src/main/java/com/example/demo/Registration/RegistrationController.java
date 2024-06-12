package com.example.demo.Registration;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/registrations")
public class RegistrationController {

    private final RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public Registration create(@RequestBody @Valid Registration registration) {
        String ticketCode = UUID.randomUUID().toString();

        return registrationRepository.save(new Registration(
                null,
                registration.productId(),
                ticketCode,
                registration.attendeeName()));
    }

    @GetMapping(path = "/{ticketCode}")
    public Registration get(@PathVariable("ticketCode") String ticketCode) {
        return registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticket code " + ticketCode + " not found"));
    }
    @PutMapping
    public Registration update(@RequestBody Registration registration) {
        String tickerCode = registration.ticketCode();
        var existing = registrationRepository.findByTicketCode(tickerCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticket code " + tickerCode + " not found"));

        return registrationRepository.save(new Registration(
                existing.id(),
                registration.productId(),
                tickerCode,
                registration.attendeeName()));
    }

    @DeleteMapping(path = "/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode) {
        registrationRepository.deleteByTicketCode(ticketCode);
    }
}
