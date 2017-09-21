package com.android.tripolis.boodilo.Database.Response;

/**
 * Created by v.karyagin on 21.09.2017.
 */

public class UpdateResponse {

    protected int affectedCount;

    public UpdateResponse(int affectedCount) {
        this.affectedCount = affectedCount;
    }

    public int getAffectedCount() {
        return affectedCount;
    }

}
