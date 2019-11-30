package com.example.cruiseapp.helpers;

import android.content.Context;

import com.example.cruiseapp.db.entities.StateRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {

    public List<StateRoom> read(Context ctx, String filename) throws IOException
    {
        List<StateRoom> elist = new ArrayList<StateRoom>();
        // tech spec: https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html
        InputStream is = ctx.getAssets().open(filename);

        // tech spec: https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
        InputStreamReader isr = new InputStreamReader(is);

        BufferedReader br = new BufferedReader(isr); // can read per line

        String s, data[] ; // Note: only data is an array
        StateRoom emp;
        while ( (s=br.readLine())!= null) {
            data = s.split(";") ; // id, fn, ln, email
            emp = new StateRoom(data[1],data[2],data[3],Double.parseDouble(data[4]),Integer.parseInt(data[5]),data[6]);
            elist.add(emp);
        }

        br.close();


        return elist;
    }
}

