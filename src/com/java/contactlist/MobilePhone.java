package com.java.contactlist;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> contacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<Contacts>();
    }

    public boolean addNewContact(Contacts contacts) {
        if(findContact(contacts.getName()) >= 0) {
            System.out.println("Contact already exists");
            return false;
        }
        this.contacts.add(contacts);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact) {
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found");
            return false;
        } else if(findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists. Operation cancelled");
        }
        this.contacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " has replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contacts contact) {
        int foundPosition = findContact(contact);
        if(foundPosition < 0) {
            System.out.println(contact.getName() + " was not found");
            return false;
        }
        this.contacts.remove(foundPosition);
        System.out.println(contact.getName() + " was deleted");
        return true;
    }

    private int findContact(Contacts contact) {
        return this.contacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for(int i = 0; i < this.contacts.size(); i++) {
            Contacts contact = this.contacts.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contact) {
        if(findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if(position >= 0) {
            return contacts.get(position);
        }
        return null;
    }
    public void printContacts() {
        System.out.println("Contact List");
        for(int i = 0; i < this.contacts.size(); i++) {
            System.out.println((i+1) + "." +
                    this.contacts.get(i).getName() + " -> " +
                    this.contacts.get(i).getPhoneNumber());
        }
    }
}
