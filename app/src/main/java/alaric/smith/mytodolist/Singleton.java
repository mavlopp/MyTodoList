package alaric.smith.mytodolist;

import java.util.ArrayList;

/**
 * Created by smithal on 15/01/2018.
 */
public final class Singleton {

    private static volatile Singleton instance = null;

    public ArrayList<String> getList() {
        return list;
    }

    public void addElement(String e) {
        this.list.add(e);
    }

    public void empty() {
        //this.list = new ArrayList<String>();
        this.list.clear();
    }

    // D'autres attributs, classiques et non "static".
    private ArrayList<String> list = new ArrayList<String>();

    private Singleton() {
        super();
    }

    public final static Singleton getInstance() {
        if (Singleton.instance == null) {
            synchronized(Singleton.class) {
                if (Singleton.instance == null) {
                    Singleton.instance = new Singleton();
                }
            }
        }
        return Singleton.instance;
    }
}