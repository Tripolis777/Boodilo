package com.android.tripolis.boodilo.Database.Table;

import java.util.List;

/**
 * Created by v.karyagin on 9/11/17.
 */

public interface SQLiteTableManager {
    String getSQLCreateQuery();
    String getSQLDeleteQuery();
    List<String> getSQLUpdateQueries();
}
