import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {

    private static final AdressBook ab= new AdressBook();

    public static void main(String[] args) {
        showMenu();
    }

    /**
     * this Menu is the main window of the application.
     */
    public static void showMenu(){
        boolean flag=true;
        String name="";
        String address="";
        String phone="";
        LocalDate birthdate = null;
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int op=0;

        while(flag) {
            while (op != 1 && op != 2 && op != 3 && op != 4 && op != 5 && op != 6) {
            String answer = JOptionPane.showInputDialog("1) Create \n2) Search\n3) Edit\n4) Delete\n5) Show All\n6) Exit");
            if(answer!=null && !answer.isEmpty()) {
                try {
                    op = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid number format");
                }
                }else{
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
            }
            switch (op){
                case 1:
                    birthdate=null;
                    name = JOptionPane.showInputDialog("Enter the Name");
                    while(!name.matches(".*[a-zA-Z ]+.*")){
                       name = JOptionPane.showInputDialog("Error, Enter the Name Again");
                    }
                    address = JOptionPane.showInputDialog("Enter the address");

                    phone = JOptionPane.showInputDialog("Enter the phone");
                    while(!phone.matches("\\d{10}")) {
                        phone = JOptionPane.showInputDialog("Error, Enter the phone Again");
                    }

                    while(birthdate==null) {
                        String input= JOptionPane.showInputDialog("Enter the birth date in format dd/MM/yyyy");

                        try {
                            birthdate = LocalDate.parse(input, formatter);
                        } catch (DateTimeParseException e) {
                            JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the date in dd/MM/yyyy format.");}
                    }
                        ab.addContact(name, address, phone, birthdate);

                    break;
                case 2:
                    name = JOptionPane.showInputDialog("Enter the Name of the contact to search");
                    Person result= ab.searchContact(name);
                    if(result!=null){
                        JOptionPane.showMessageDialog(null, "Found:\n"+result.toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "Not Found");
                    }
                    break;
                case 3:
                    birthdate=null;
                    name = JOptionPane.showInputDialog("Enter the Name of the contact to Edit");
                    Person person= ab.searchContact(name);
                    if(person!=null) {
                        name = JOptionPane.showInputDialog("Enter the Name");
                        while (!name.matches(".*[a-zA-Z ]+.*")) {
                            name = JOptionPane.showInputDialog("Error, Enter the Name Again");
                        }
                        address = JOptionPane.showInputDialog("Enter the address");

                        phone = JOptionPane.showInputDialog("Enter the phone");
                        while (!phone.matches("\\d{10}")) {
                            phone = JOptionPane.showInputDialog("Error, Enter the phone Again");
                        }
                        while(birthdate==null) {
                            String input= JOptionPane.showInputDialog("Enter the birth date in format dd/MM/yyyy");

                            try {
                                birthdate = LocalDate.parse(input, formatter);
                            } catch (DateTimeParseException e) {
                                JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the date in dd/MM/yyyy format.");}
                        }
                        person.setName(name);
                        person.setAddress(address);
                        person.setPhone(phone);
                        person.setBirthdate(birthdate);
                        JOptionPane.showMessageDialog(null, "Updated:\n"+person.toString());
                    }else{
                        JOptionPane.showMessageDialog(null,"Not Found");
                    }
                    break;
                case 4:
                    name = JOptionPane.showInputDialog("Enter the Name of the contact to Delete");
                    boolean deleted= ab.deleteContact(name);
                    if(deleted){
                        JOptionPane.showMessageDialog(null,"Contact deleted");
                    }else{
                        JOptionPane.showMessageDialog(null,"Contact Not Found");
                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null,ab.toString());
                    break;
                case 6:
                    flag=false;
                    ab.saveContacts();
                    break;
            }
        }
    }
}
