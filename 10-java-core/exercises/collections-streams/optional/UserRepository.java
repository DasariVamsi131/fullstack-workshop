package optional;

import java.util.*;

public class UserRepository {

    private final Map<Long, User> usersById = new HashMap<>();
    private final Map<String, User> usersByEmail = new HashMap<>();

    public UserRepository() {
        // sample data
        User u1 = new User(1L, "alice@gmail.com", null, new Address("A-101"));
        User u2 = new User(2L, "bob@gmail.com", "K", null);
        User u3 = new User(3L, "charlie@gmail.com", "M", new Address(null));

        save(u1);
        save(u2);
        save(u3);
    }

    private void save(User user) {
        usersById.put(user.getId(), user);
        usersByEmail.put(user.getEmail(), user);
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(usersById.get(id));
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(usersByEmail.get(email));
    }
}
