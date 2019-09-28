package ch.heig.pl.business;

import ch.heig.pl.business.dao.ContactDAO;
import ch.heig.pl.model.Contact;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ContactService {

//    @Inject
//    private ContactMemory contactMemory;
//    public List<Contact> getContacts() { return contactMemory.getContacts(); }
//    public void add(Contact contact) {
//        contactMemory.add(contact);
//    }

    @Inject
    private ContactDAO contactDAO;
    public List<Contact> getContacts() { return contactDAO.getContacts(); }
    public void add(Contact contact) {
        contactDAO.add(contact);
    }
}
