import java.util.Scanner;

class FriendsContact {
    private String name;
    private String email;
    private String phone;

    public FriendsContact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "****** Contacts Information ******" + "\nName: " + name + "\nEmail: " + email + "\nPhone: " + phone;
    }
}

class ContactBook {
    private FriendsContact[] contacts;
    private int contactCount;

    public ContactBook(int size) {
        contacts = new FriendsContact[size];
        contactCount = 0;
    }

    public void addContact(String name, String phone, String email) {
        if (contactCount < contacts.length) {
            contacts[contactCount] = new FriendsContact(name, email, phone);
            contactCount++; // Adds Contacts to Array, after checking if there is still space available
            System.out.println("Contact '" + name + "' added successfully.");
        } else {
            System.out.println("Contact book is full. Cannot add more contacts.");
        }
    }

    public void deleteContact(String name) {
        int i = 0;
        int foundIndex = -1;

        while (i < contactCount) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                foundIndex = i;
                break;
            }
            i++;
        }

        if (foundIndex != -1) {
            contacts[foundIndex] = contacts[contactCount - 1];
            contacts[contactCount - 1] = null;
            contactCount--;
            System.out.println("Contact '" + name + "' deleted successfully.");
        } else {
            System.out.println("Contact '" + name + "' not found.");
        }
    }

    public void emailSearch(String email) {
        int i = 0;
        int foundIndex = -1;

        while (i < contactCount) {
            if (contacts[i].getEmail().equalsIgnoreCase(email)) {
                System.out.println(contacts[i]);
                foundIndex = i;
            }
            i++;
        }

        if (foundIndex == -1) {
            System.out.println("No contacts found with email '" + email + "'.");
        }
    }

    public void printList() {
        if (contactCount == 0) {
            System.out.println("Contact list is empty.");
        } else {
            int i = 0;
            while (i < contactCount) {
                System.out.println(contacts[i]);
                i++;
            }
        }
    }

    public void search(String name) {
        int i = 0;
        int foundIndex = -1;

        while (i < contactCount) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                System.out.println(contacts[i]);
                foundIndex = i;
            }
            i++;
        }

        if (foundIndex == -1) {
            System.out.println("No contacts found with name '" + name + "'.");
        }
    }
}

public class ContactBookApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactBook contactBook = new ContactBook(10);

        while (true) {
            System.out.println("**************************************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch by Name");
            System.out.println("(Q)uit");
            System.out.println("**************************************");
            System.out.print("Please enter a command: ");
            String command = scanner.nextLine().trim().toUpperCase();

            if (command.equals("A")) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phone = scanner.nextLine();
                System.out .print("Enter email: ");
                String email = scanner.nextLine();
                contactBook.addContact(name, phone, email);
            }

            else if (command.equals("D")) {
                System.out.print("Enter name of the contact to delete: ");
                String deleteName = scanner.nextLine();
                contactBook.deleteContact(deleteName);
            }

            else if (command.equals("E")) {
                System.out.print("Enter email to search: ");
                String searchEmail = scanner.nextLine();
                contactBook.emailSearch(searchEmail);
            }

            else if (command.equals("P")) {
                contactBook.printList();
            }

            else if (command.equals("S")) {
                System.out.print("Enter name to search: ");
                String searchName = scanner.nextLine();
                contactBook.search(searchName);
            }

            else if (command.equals("Q")) {
                System.out.println("Exiting the contact book.");
                scanner.close();
                return;
            }

            else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}