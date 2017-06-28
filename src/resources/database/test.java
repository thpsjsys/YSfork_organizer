package resources.database;

import java.util.HashMap;
import java.util.List;

class test{
    public static void main(String[] args) {
        DB db = new DB();
        List data=db.read("SELECT * FROM test");
        if(data!=null) {
            for (Object o : data) {
                HashMap hm = (HashMap) o;
                System.out.print(hm.get("id") + " " + hm.get("name") + " " + hm.get("number"));
            }
        }
    }
}