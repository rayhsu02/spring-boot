package com.example.demo.Registration;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface RegistrationRepository extends MongoRepository<Registration, String> {

    Optional<Registration> findByTicketCode(String ticketCode);

    void deleteByTicketCode(String ticketCode);

    //    public Registration create(Registration registration) {
//        int id = ID_GENERATOR.incrementAndGet();
//        String ticketCode = UUID.randomUUID().toString();
//
//        var saved = new Registration(id, registration.productId(), ticketCode, registration.attendeeName());
//        registrationsByTicketCode.put(ticketCode, saved);
//        return saved;
//    }

//    public Optional<Registration> findByTicketCode(String ticketCode) {
//        return Optional.ofNullable(registrationsByTicketCode.get(ticketCode));
//    }
//
//    public Registration update(Registration registration) {
//        String ticketCode = registration.ticketCode();
//
//        var opt = findByTicketCode(ticketCode);
//        if (opt.isPresent()) {
//            var existing = opt.get();
//
//            var saved = new Registration(existing.id(), existing.productId(), existing.ticketCode(), registration.attendeeName());
//            registrationsByTicketCode.put(ticketCode, saved);
//            return saved;
//        } else {
//            throw new NoSuchElementException("Registration with ticket code " + ticketCode + " not found");
//        }
//    }
//
//    public void deleteByTicketCode(String ticketCode) {
//        registrationsByTicketCode.remove(ticketCode);
//    }
}
