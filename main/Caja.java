package main;
import java.util.ArrayList;

public class Caja {
    private ArrayList<Mail> mails = new ArrayList<>();
    
    public int size() { 
        return mails.size(); 
    
    public void add(Mail mail) { 
        mails.add(mail); 
    }

    public Mail get(int index) {
        return mails.get(index); 
    }
    
    public ArrayList<Mail> getAll() { 
    }
}
