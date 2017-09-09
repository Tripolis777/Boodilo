package com.android.tripolis.boodilo.Database.Entries;

import java.util.List;

/**
 * Created by tripo on 9/9/2017.
 */

public interface DatabaseEntry {
    String getSQLCreateQuery();
    String getSQLDeleteQuery();
    List<String> getSQLUpdateQueries();
}
