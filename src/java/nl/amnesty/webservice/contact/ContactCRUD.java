package nl.amnesty.webservice.contact;

import java.util.Calendar;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import nl.amnesty.crm.entity.Contact;
import nl.amnesty.crm.entity.Document;
import nl.amnesty.crm.entity.Role;

// algemene webservices uitgezet uit beveiligingsoogpunt
@WebService()
@Stateless()

public class ContactCRUD {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "dummy")
    public String dummy() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     
    @WebMethod(operationName = "create")
    public long create(
            @WebParam(name = "Roleid") long roleid,
            @WebParam(name = "Document") Document document,
            @WebParam(name = "Type") String type,
            @WebParam(name = "Incoming") boolean incoming,
            @WebParam(name = "Date") Date date,
            @WebParam(name = "Subject") String subject,
            @WebParam(name = "Content") String content) {
        //TODO write your implementation code here:
        long contactid = 123456789;
        return contactid;
    }
    */

    /**
     * Web service operation
     
    @WebMethod(operationName = "read")
    public Contact read(long contactid) {
        //TODO write your implementation code here:
        Contact contact = new Contact();
        contact.setRoleid(0);
        Document document = new Document();
        contact.setDocument(document);
        contact.setType("Type");
        contact.setIncoming(true);
        contact.setDate(Calendar.getInstance().getTime());
        contact.setSubject("Subject");
        contact.setContent("Content");
        return contact;
    }
    */

    /**
     * Web service operation
     
    @WebMethod(operationName = "update")
    public long update(@WebParam(name = "Contactid") long contactid,
            @WebParam(name = "Role") Role role,
            @WebParam(name = "Document") Document document,
            @WebParam(name = "Type") String type,
            @WebParam(name = "Incoming") boolean incoming,
            @WebParam(name = "Date") Date date,
            @WebParam(name = "Subject") String subject,
            @WebParam(name = "Content") String content) {
        //TODO write your implementation code here:
        return contactid;
    }
    */

    /**
     * Web service operation
     
    @WebMethod(operationName = "delete")
    public long delete(long contactid) {
        //TODO write your implementation code here:
        return contactid;
    }
    */
}
