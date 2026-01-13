package optional;

import java.util.Optional;

public class User {
    private final Long id;
    private final String email;
    private final String middleName;
    private final Address address;

    public User(Long id, String email, String middleName, Address address) {
        this.id = id;
        this.email = email;
        this.middleName = middleName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Optional<String> getMiddleName() {
        return Optional.ofNullable(middleName);
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
}
