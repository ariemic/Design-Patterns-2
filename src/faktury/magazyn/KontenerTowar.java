package faktury.magazyn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KontenerTowar extends Kategoria {
    protected List<Towar> children = new ArrayList<>();
    public KontenerTowar(Towar... components){
        super(0, "item");
        add(components);
    }

    public void add(Towar component){
        children.add(component);
    }

    public void add(Towar... components){
        //add all elements from components given as ArrayList converted to list into children
        children.addAll(Arrays.asList(components));
    }

    public void addMultiple(Towar component, int count){
        while(count > 0){
            children.add(component);
            count--;
        }
    }

    public void remove(Towar component){
        children.remove(component);
    }

    public void remove(Towar... components){
        children.removeAll(Arrays.asList(components));
    }


    public void clear(){
        //erase all elements from the list
        children.clear();
    }


    public void displayContents() {
        for (Towar k : children) {
            System.out.println(k);
        }
    }


    @Override
    public double getCena(){
        if(children.size() == 0){
            return 0;
        }
        double suma = 0;
        for(Towar child: children){
            suma += child.getCena();
        }
        return suma;
    }


}
