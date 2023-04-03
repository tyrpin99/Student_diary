package com.company;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;


public class ClassContainer {
    Map<String,Class> groups = new TreeMap<String, Class>();

    public void addClass(String name, Class class1){
        groups.put(name,class1);
    }
    public Class getGroupB (String name)
    {
        return groups.get(name);

    }

    public Map<String, Class> getAllGroups() {
        return groups;
    }

    public void removeClass(String name){
        groups.remove(name);
    }
    public ArrayList<Class> findEmpty() {
        ArrayList<Class> empty = new ArrayList<>();
        for (Class singleClass : groups.values()) {
            if (singleClass.studentList.isEmpty()) {
                empty.add(singleClass);
              //  System.out.println(singleClass.groupName);
            }

        }
        return empty;
    }




    public void summary(){
        for(Class singleClass: groups.values()){
           System.out.println("Group name: "+(singleClass.groupName)+ " Filling : "+(singleClass.studentList.size()/(double)singleClass.studentMax)*100+"%" );

          //  String groupName = (singleClass.groupName);
          //  String filling = (Str(singleClass.studentList.size()/(double)singleClass.studentMax)*100+"%" );
        }

    }
}
