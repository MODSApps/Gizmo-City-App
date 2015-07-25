package org.example.sudoku;

/**
 * Created by D on 7/13/2015.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class Puzzles extends Activity {
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzles);
    }

    public void clickGreenTandSixTriangles(final View view)
    {
        startActivity(new Intent(this, GreenTandSixTriangles.class));
    }

}

