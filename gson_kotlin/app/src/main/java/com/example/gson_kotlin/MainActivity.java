package com.example.gson_kotlin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Gson gson = new Gson();
        Address address = new Address("Ranchi",234);
        Employee employee = new Employee(15, "Ashish",345 , address);
        String json = gson.toJson(employee);
*/


//        Gson gson = new Gson();
//        String json1 =  "{\"id\":15,\"name\":\"Ashish\",\"roll\":345}";
//        Employee employee= gson.fromJson(json1,Employee.class);


   /*     Gson gson = new Gson();
        String json1=  "{\"address\":{\"city\":\"Ranchi\",\"pin\":234},\"id\":15,\"name\":\"Ashish\",\"roll\":345}";
        Employee employee = gson.fromJson(json1,Employee.class);*/

        /*Gson gson = new Gson();
        Address address = new Address("Ranchi",834002);
        ArrayList<familyMember> familyMembers = new ArrayList<>();
        familyMembers.add(new familyMember("Ashish","Son",23));
        familyMembers.add(new familyMember("Rajeev","big son",26));
        Employee employee = new Employee(34,"Ashish",345, address , familyMembers);*/
//        String json = gson.toJson(employee);
     //   String json = gson.toJson(familyMembers);

          Gson gson = new Gson();
       // String json1=  "{\"address\":{\"city\":\"Ranchi\",\"pin\":834002},\"id\":34,\"familyisnameis\":[{\"age\":23,\"name\":\"Ashish\",\"relation\":\"Son\"},{\"age\":26,\"name\":\"Rajeev\",\"relation\":\"big son\"}],\"name\":\"Ashish\",\"roll\":345}";
        String json2 = "[{\"age\":23,\"name\":\"Ashish\",\"relation\":\"Son\"},{\"age\":26,\"name\":\"Rajeev\",\"relation\":\"big son\"}]";
//        Employee employee = gson.fromJson(json1,Employee.class);

        familyMember[] family = gson.fromJson(json2,familyMember[].class);





    }
}