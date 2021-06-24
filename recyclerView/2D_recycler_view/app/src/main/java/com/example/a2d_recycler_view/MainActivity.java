package com.example.a2d_recycler_view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements implementonclick{

    private RecyclerView rvSubject;
    private SubjectAdapter subjectAdapter;
    private ArrayList<Subject> subjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        subjects = prepareData();
        //send this or MainActivity.this both are same
        subjectAdapter = new SubjectAdapter(subjects, this,MainActivity.this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvSubject.setLayoutManager(manager);
        rvSubject.setAdapter(subjectAdapter);

    }

    private void initComponents() {
        rvSubject = findViewById(R.id.rvSubject);
    }

    private ArrayList<Subject> prepareData() {
        ArrayList<Subject> subjects = new ArrayList<Subject>();

        Subject city = new Subject();
        city.subjectName = "City_name";
        city.chapters = new ArrayList<Chapter>();

        Chapter chapter1 = new Chapter();
        chapter1.chapterName = "Delhi";

        Chapter chapter2 = new Chapter();
        chapter2.chapterName = "Mumbai";


        Chapter chapter3 = new Chapter();
        chapter3.chapterName = "Gurgaon";


        Chapter chapter4 = new Chapter();
        chapter4.chapterName = "Chennai";


        Chapter chapter5 = new Chapter();
        chapter5.chapterName = "Kolkata";


        city.chapters.add(chapter1);
        city.chapters.add(chapter2);
        city.chapters.add(chapter3);
        city.chapters.add(chapter4);
        city.chapters.add(chapter5);



        Subject fruit = new Subject();
        fruit.subjectName = "Fruit name";
        fruit.chapters = new ArrayList<Chapter>();

        Chapter chapter6 = new Chapter();
        chapter6.chapterName = "Anar";


        Chapter chapter7 = new Chapter();
        chapter7.chapterName = "Mango";


        Chapter chapter8 = new Chapter();
        chapter8.chapterName = "litchi";


        Chapter chapter9 = new Chapter();
        chapter9.chapterName = "orange";


        Chapter chapter20 = new Chapter();
        chapter20.chapterName = "kiwi";

        Chapter chapter21 = new Chapter();
        chapter21.chapterName = "straberry";

        Chapter chapter22 = new Chapter();
        chapter22.chapterName = "banana";

        fruit.chapters.add(chapter6);
        fruit.chapters.add(chapter7);
        fruit.chapters.add(chapter8);
        fruit.chapters.add(chapter9);
        fruit.chapters.add(chapter20);
        fruit.chapters.add(chapter21);
        fruit.chapters.add(chapter22);

        Subject name = new Subject();
        name.subjectName = "UC_person_name";
        name.chapters = new ArrayList<Chapter>();

        Chapter chapter10 = new Chapter();
        chapter10.chapterName = "Sachin";


        Chapter chapter11 = new Chapter();
        chapter11.chapterName = "Vivek";


        Chapter chapter12 = new Chapter();
        chapter12.chapterName = "Satyam";

        Chapter chapter13 = new Chapter();
        chapter13.chapterName = "shrey";


        Chapter chapter31 = new Chapter();
        chapter31.chapterName = "Harshit";


        Chapter chapter32 = new Chapter();
        chapter32.chapterName = "Rohan";


        Chapter chapter33 = new Chapter();
        chapter33.chapterName = "Akash";


        Chapter chapter34 = new Chapter();
        chapter34.chapterName = "Akhil";



        name.chapters.add(chapter10);
        name.chapters.add(chapter11);
        name.chapters.add(chapter12);
        name.chapters.add(chapter13);
        name.chapters.add(chapter31);
        name.chapters.add(chapter32);
        name.chapters.add(chapter33);
        name.chapters.add(chapter34);

        Subject sport = new Subject();
        sport.subjectName = "Sports name";
        sport.chapters = new ArrayList<Chapter>();

        Chapter chapter14 = new Chapter();
        chapter14.chapterName = "Cricket";


        Chapter chapter15 = new Chapter();
        chapter15.chapterName = "football";


        Chapter chapter16 = new Chapter();
        chapter16.chapterName = "hockey";


        Chapter chapter17 = new Chapter();
        chapter17.chapterName = "wrestling";


        Chapter chapter18 = new Chapter();
        chapter18.chapterName = "Boxing";

        sport.chapters.add(chapter14);
        sport.chapters.add(chapter18);
        sport.chapters.add(chapter15);
        sport.chapters.add(chapter16);
        sport.chapters.add(chapter17);

        subjects.add(city);
        subjects.add(fruit);
        subjects.add(sport);
        subjects.add(name);

        return subjects;
    }

    @Override
    public void onclicklis(int position) {
        Toast.makeText(this,"Clicked position is "+position, Toast.LENGTH_SHORT).show();
    }
}