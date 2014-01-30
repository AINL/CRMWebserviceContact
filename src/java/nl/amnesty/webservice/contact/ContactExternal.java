/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.amnesty.webservice.contact;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import nl.amnesty.crm.entity.Contact;
import nl.amnesty.crm.persistence.EMContact;
import nl.amnesty.crm.persistence.EntityManager;

/**
 *
 * @author evelzen
 */
@WebService()
@Stateless()
public class ContactExternal {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public long add(
            @WebParam(name = "Type") String type,
            @WebParam(name = "Subject") String subject,
            @WebParam(name = "Content") String content,
            @WebParam(name = "Source") String source,
            @WebParam(name = "Roleid") long roleid) {
        return doAdd(type, subject, content, source, roleid);
    }

    /**
     * 
     * @param type
     * @param subject
     * @param content
     * @param source
     * @param roleid
     * @return 
     */
    private long doAdd(String type, String subject, String content, String source, long roleid) {
        try {
            //DEBUG
            //Logger.getLogger(ContactExternal.class.getName()).log(Level.INFO, "doAdd: type {0}, subject {1}, content {2}, source {3} roleid {4}", new Object[]{type, subject, content, source, roleid});
            
            EntityManager em = new EMContact();
            Contact contact = new Contact();
            if (type==null) {
                type="";
            }
            if (subject==null) {
                subject="";
            }
            if (content==null) {
                content="";
            }
            if (source==null) {
                source="";
            }
            contact.parseContent(content.replace(";", "").replace("&", "").replace("%", ""));
            contact.parseSource(source.replace(";", "").replace("&", "").replace("%", ""));
            contact.parseSubject(subject.replace(";", "").replace("&", "").replace("%", ""));
            contact.parseType(type.replace(";", "").replace("&", "").replace("%", ""));
            contact.setRoleid(roleid);
            Contact contactnew = em.persist(contact);
            if (contactnew != null) {
                return contactnew.getContactid();
            } else {
                return 0;
            }
        } catch (Exception e) {
            Logger.getLogger(ContactExternal.class.getName()).log(Level.SEVERE, null, e);
            return 0;
        }
    }
}
