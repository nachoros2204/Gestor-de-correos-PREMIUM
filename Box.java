import java.util.ArrayList;

public class Box {
    private ArrayList<Mail> mails = new ArrayList<>();
    public int size(){
        return mails.size();
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