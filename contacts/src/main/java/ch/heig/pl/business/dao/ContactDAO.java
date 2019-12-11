package ch.heig.pl.business.dao;

import ch.heig.pl.business.ContactMemory;
import ch.heig.pl.model.Contact;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class ContactDAO {

    @Resource(lookup = "jdbc/ContactsDS")
    private DataSource dataSource;

    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM contacts");){
//            Connection connection = dataSource.getConnection();
//            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM contacts");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String nom = rs.getString("nom");
                int telephone = rs.getInt("telephone");
                contacts.add(new Contact(nom, telephone));
            }
//            pstmt.close();
//            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return contacts;
    }

    public void add(Contact contact) {
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement
                    ("insert into contacts (nom,telephone) values (?,?)");){
            pstmt.setString(1,contact.getNom());
            pstmt.setInt(2,contact.getTelephone());
            pstmt.executeUpdate();
//            pstmt.close();
//            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
