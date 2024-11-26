package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private final String myNumber;
    private final ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = (contacts != null) ? new ArrayList<>(contacts) : new ArrayList<>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundIndex = findContact(oldContact);
        if (foundIndex < 0) {
            System.out.println("Contact not found.");
            return false;
        }

        if (findContact(newContact.getName()) != -1 && !oldContact.getName().equals(newContact.getName())) {
            System.out.println("A contact with the name " + newContact.getName() + " already exists.");
            return false;
        }

        myContacts.set(foundIndex, newContact);
        System.out.println("Contact updated successfully.");
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundIndex = findContact(contact);
        if (foundIndex < 0) {
            System.out.println("Contact not found.");
            return false;
        }
        myContacts.remove(foundIndex);
        System.out.println("Contact removed successfully.");
        return true;
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int foundIndex = findContact(name);
        return (foundIndex >= 0) ? myContacts.get(foundIndex) : null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
