package com.nwhite.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nwhite.dao.ContactDAO;
import com.nwhite.model.Contact;

@Controller
public class ContactsController {
	@Autowired
    private ContactDAO contactDAO;
	
	@GetMapping(value = {"/", "/list"})
    public String list(Model model) throws IOException {
		List<Contact> listContacts = contactDAO.list();
		model.addAttribute("listContacts", listContacts);
		
		return "home";
	}
	
	@GetMapping("/newContact")
    public String newContact(Model model) {
        Contact newContact = new Contact();
        model.addAttribute("contactForm", newContact);
        
        return "ContactForm";
    }
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Contact contact) {
        contactDAO.saveOrUpdate(contact);
        return new ModelAndView("redirect:/");
    }

	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactDAO.get(contactId);
        ModelAndView model = new ModelAndView("ContactForm");
        model.addObject("contactForm", contact);
        return model;
    }
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        contactDAO.delete(contactId);
        return new ModelAndView("redirect:/");
    }
}
