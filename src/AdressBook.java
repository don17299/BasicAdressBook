import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AdressBook {

    /**
     * list where are contained all the contacts.
     */
    ArrayList<Person> contacts;

    /**
     * initialization of the list
     */
    AdressBook(){
        this.contacts = new ArrayList<>();
        this.loadContacts();
    }

    /**
     * Procedure that allows to add a contact to the list
     * @param name name of the contact
     * @param address address of the contact
     * @param phone phone of the contact
     * @param birthdate birthdate of the contact
     */
    public void addContact(String name, String address, String phone, LocalDate birthdate){

        Person contact= new Person(name,address,phone,birthdate);
        contacts.add(contact);
    }

    /**
     * Search a contact by name
     * @param name name of the contact to search for
     * @return the contact object
     */
    public Person searchContact(String name){
        // old way:
        /*for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).getName().equals(name)){
                return contacts.get(i);
            }

        }
        */

        for (Person contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }

        }
        return null;
    }

    /**
     * Delete a contact
     * @param name name of the contact to delete for
     * @return true if deleted, false if not.
     */
    public Boolean deleteContact(String name){
        //old form:
        /*for (Person contact : contacts) {
            if (contact.getName().equals(name)) {
                contacts.remove(contact);
            }

        }
        */
       return contacts.removeIf(contact -> contact.getName().equals(name));

    }

    /**
     * persist contacts
     */
    public void saveContacts(){
        try(FileWriter writer = new FileWriter("contacts.txt")){

            String line="";
            PrintWriter pw = new PrintWriter(writer);
            for(Person p: contacts){
                line = p.getName()+","+p.getAddress()+","+p.getPhone()+","+p.getBirthDate();
                pw.println(line);
            }
            pw.flush();//this is to write the line immediately
            pw.close(); //close the printWriter.
            //writer.close(); this line is not needed anymore cause we put fileWriter in the () of the try, this will automatically close the writer when the code is executed

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadContacts(){
        String[] tokens = null; //it says that tokens[] is C-style so we put the String[] that is Java-Style
        String name, address, phone;
        LocalDate birthdate;
        try(FileReader reader= new FileReader("contacts.txt")){
            BufferedReader br = new BufferedReader(reader);
            String line= br.readLine();
            while(line!=null){
                tokens = line.split(",");
                name= tokens[0];
                address= tokens[1];
                phone= tokens[2];
                birthdate= LocalDate.parse(tokens[3]);
                Person p = new Person(name, address, phone, birthdate);
                contacts.add(p);
                line= br.readLine();
            }
            br.close();
            //reader.close(); not you know why Xd
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    @Override
    public String toString() {
        String contactsList= "";
        for(Person contact: contacts){
            contactsList+= "Name: "+contact.getName()+" | Address: "+ contact.getAddress() + " | Phone: "+contact.getPhone()+" | Birthdate: "+contact.getBirthDate()+"\n";
        }
        return contactsList;
    }
}
