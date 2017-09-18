package com.android.tripolis.boodilo.Database.Response;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by v.karyagin on 9/18/17.
 */

public class SimpleSelectResponse<T> extends SelectResponse<T> {

    public SimpleSelectResponse(SelectResponseIterator<T> iterator) {
        super(iterator);
    }

    @Override
    public ArrayList<T> getAll() {
        ArrayList<T> entries = (ArrayList) Collections.EMPTY_LIST;

        while (iterator.hasNext()) {
            entries.add(iterator.next());
        }

        return entries;
    }
}
