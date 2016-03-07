package ru.devray;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Aleksandr Kuzmichev on 07.03.2016.
 */
public class SDummy implements Serializable{
    static transient int count=0;

    int id;
    String name;

    int valueInt;
    float valueFloat;
    String valueString;

    public SDummy() {
        id=++count;
        name="Exemplar-"+id;

        Random rnd=new Random();

        valueInt = rnd.nextInt();
        valueFloat = rnd.nextFloat();
        valueString = "[Stringed RND:"+rnd.nextLong()+"]";

    }

    @Override
    public String toString() {
        return "id:"+id+"; name:\""+name+"\";\nValues:\n"+valueInt+'\n'+valueFloat+'\n'+valueString;
    }
}
