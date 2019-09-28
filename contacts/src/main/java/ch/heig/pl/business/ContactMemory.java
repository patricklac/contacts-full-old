package ch.heig.pl.business;

import ch.heig.pl.model.Contact;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ContactMemory {

    private List<Contact>  contacts;

    @PostConstruct
    public void init() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Pierre",1234));
        contacts.add(new Contact("Sylvie",1111));
    }

    @Lock(LockType.READ)
    public List<Contact> getContacts() {
        return contacts;
    }

    @Lock(LockType.WRITE)
    public void add(Contact contact) {
        contacts.add(contact);
    }
}
