package com.android.tripolis.boodilo.Database.Response;

import java.util.ArrayList;

/**
 * Created by v.karyagin on 9/19/17.
 */

public class InsertResponse {

    private ArrayList<Long> idsArray;

    public InsertResponse() {
        this.idsArray = new ArrayList<>();
    }

    public void addInsertingId(Long id) {
        idsArray.add(id);
    }

    public int getCount() {
        return idsArray.size();
    }

    public ArrayList<Long> getIds() {
       return idsArray;
    }
}
