package optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalTest {

    @Test
    void testApartmentFound() {
        UserRepository repository = new UserRepository();

        String apartment = repository.findById(1L)
                .flatMap(User::getAddress)
                .flatMap(Address::getApartment)
                .orElse("N/A");

        assertEquals("A-101", apartment);
    }

    @Test
    void testApartmentNotFoundBecauseNoAddress() {
        UserRepository repository = new UserRepository();

        String apartment = repository.findById(2L)
                .flatMap(User::getAddress)
                .flatMap(Address::getApartment)
                .orElse("N/A");

        assertEquals("N/A", apartment);
    }

    @Test
    void testApartmentNotFoundBecauseApartmentNull() {
        UserRepository repository = new UserRepository();

        String apartment = repository.findById(3L)
                .flatMap(User::getAddress)
                .flatMap(Address::getApartment)
                .orElse("N/A");

        assertEquals("N/A", apartment);
    }

    @Test
    void testApartmentNotFoundBecauseUserMissing() {
        UserRepository repository = new UserRepository();

        String apartment = repository.findById(100L)
                .flatMap(User::getAddress)
                .flatMap(Address::getApartment)
                .orElse("N/A");

        assertEquals("N/A", apartment);
    }
}
