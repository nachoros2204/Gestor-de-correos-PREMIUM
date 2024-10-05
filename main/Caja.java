package main;
import java.util.ArrayList;

public class Caja {
    private ArrayList<Mail> mails = new ArrayList<>();
    public int tamaño(){
        return mails.tamaño();
    }
    
    public void agregar(Mail mail){
        mails.agregar(mail);
    }
}
public Mail get(int index){
    return mails.get(index);
}
public ArrayList<Mail> getTodo(){
    return mails;
}