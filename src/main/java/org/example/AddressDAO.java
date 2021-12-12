package org.example;

import java.util.List;

public interface AddressDAO {

    void create(Address address);

    void update(Address address);

    void delete(Address address);

    Address getById(long id);

    void cityPerCountry();

    List<Address> getAll();
}
