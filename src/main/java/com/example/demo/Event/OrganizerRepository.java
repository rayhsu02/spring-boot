package com.example.demo.Event;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizerRepository {

    private final List<Organizer> organizers = List.of(
            new Organizer(101, "John Doe", "A mysterious organizer"),
            new Organizer(102, "Jane Doe", "Another mysterious organizer")
    );

    public List<Organizer> findAll() {
        return organizers;
    }

}
