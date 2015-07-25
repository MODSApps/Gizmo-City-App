/***
 * Excerpted from "Hello, Android",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/eband3 for more book information.
 ***/
package org.example.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Sudoku extends Activity implements OnClickListener {
    //initialize variables
    private static final String TAG = "Sudoku";
    private static final String PREFS = "prefs";                                                    //filename to keep SharedPreferences in 1 loc
    private static final String PREF_NAME = "name";                                                 //key to store name in shared preferences
    SharedPreferences mySharedPreferences;
    private String username;                                                                        //variable if use Bundle, OnSaveInstanceState, OnRestoreInstanceState to save username

    //Constructor; called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Set up onClickListener's for ALL buttons
        /*View puzzles_Button = findViewById(R.id.puzzles_button);                                    //get button object that can be "worked on"
        puzzles_Button.setOnClickListener(this);                                                    //says: if clicked, want to know. setOnClickListener is CONNECTED to onClick().
        View physics_Button = findViewById(R.id.physics_ti_button);                                 //text image
        physics_Button.setOnClickListener(this);
        View technology_Button = findViewById(R.id.technology_ti_button);
        technology_Button.setOnClickListener(this);
        View back_Button = findViewById(R.id.back_button);
        back_Button.setOnClickListener(this);
        View map_Button = findViewById(R.id.map_button);
        map_Button.setOnClickListener(this);
        View about_Button = findViewById(R.id.about_button);
        //about_Button.setOnClickListener(this);                                    ******FIX******************
        View continueButton = findViewById(R.id.sounds_and_visual_waves_button);
        continueButton.setOnClickListener(this);
        View recent_Button = findViewById(R.id.recent_button);
        recent_Button.setOnClickListener(this);
        View home_Button = findViewById(R.id.home_button);
        home_Button.setOnClickListener(this);*/

        //w/o onClick xml attribute
        /*View continuewavesButton = findViewById(R.id.sounds_and_visual_waves_button);
        continuewavesButton.setOnClickListener(this);
        View continuepuzzlesButton = findViewById(R.id.puzzles_button);
        continuepuzzlesButton.setOnClickListener(this);
        View continuewavesimageButton = findViewById(R.id.sounds_and_visual_waves_image_button);
        continuewavesimageButton.setOnClickListener(this);
        View continuepuzzlesimageButton = findViewById(R.id.puzzles_image_button);
        continuepuzzlesimageButton.setOnClickListener(this);*/

        Button nameButton = (Button) findViewById(R.id.name_button);                                //Access the nameButton defined in main.xml and listen for it here.
        //nameButton.setOnClickListener(this);                                                        //dialog's can't use onClick xml attribute

        //set Button to say "Welcome, 'username'" if name.length()>0
        mySharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);                            //MODE_PRIVATE - another app can't overwrite it if used same key
        //String name = mySharedPreferences.getString(PREF_NAME, "");                                 //Get user's name, or an empty string. "" is default val returned if no val stored in key
        String name = "";  //to clear saved username

        if (name.length() > 0) {
            nameButton.setText("Welcome " + name + "!");
        }

        /*if (savedInstanceState != null) {                                                           //variable if use Bundle, OnSaveInstanceState, OnRestoreInstanceState to save username
            nameButton.setText("Welcome " + username + "!");
        }*/
    }

    //can startActivity(page) from here, if button is pressed.
    public void onClick(View v) {
        /*switch (v.getId()) {
            case R.id.puzzles_ti_button:
                Log.d(TAG, "clicked on Puzzles");
                startActivity(new Intent(this, Puzzles.class));
                break;
                case R.id.puzzles_image_button:
                    Log.d(TAG, "clicked on Puzzles Image");
                    startActivity(new Intent(this, Puzzles.class));
                    break;
            case R.id.sounds_and_visual_waves_ti_button:
                Log.d(TAG, "clicked on Sounds and Visual Waves");
                startActivity(new Intent(this, Waves.class));
                break;
                case R.id.sounds_and_visual_waves_image_button:
                    Log.d(TAG, "clicked on Sounds and Visual Waves Image");
                    startActivity(new Intent(this, Waves.class));
                    break;
            case R.id.physics_ti_button:
                Log.d(TAG, "clicked on Physics");
                break;
            case R.id.technology_ti_button:
                Log.d(TAG, "clicked on Technology");
                break;
            case R.id.back_button:
                Log.d(TAG, "clicked on Back");
                break;
            case R.id.recent_button:
                Log.d(TAG, "clicked on Recent");
                break;
            case R.id.home_button:
                Log.d(TAG, "clicked on Home");
                break;
            case R.id.map_button:
                Log.d(TAG, "clicked on Map");
                break;
            case R.id.about_button:
                Log.d(TAG, "clicked on About");
                break;
            case R.id.name_button:
                Log.d(TAG, "clicked on Name Button");
                displayWelcome();
                break;
        }*/
    }

    //handle and display welcome toast
    public void displayWelcome()
    {
        mySharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);                            //Get device's key-value storage. MODE_PRIVATE - another app can't overwrite it if used same key
        //String name = mySharedPreferences.getString(PREF_NAME, "");                                 //Get user's name, or an empty string. "" is default val returned if no val stored in key
        String name = "";  //to clear saved username

        if (name.length() > 0)
        {
            //different style welcome toast
            //Toast.makeText(this, "Welcome back, " + name + "!", Toast.LENGTH_LONG).show();

            //DISPLAYING THE TOAST
            LayoutInflater inflater = getLayoutInflater();                                          //LayoutInflater used instantiate XMLs that create Views. This involves parsing the XML, creating the View object, and finally adding it to the View hierarchy. create (or fill) View based on XML file in runtime. For example if you need to generate views dynamically for your ListView items.
            View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.custom_toast_layout));     // Inflate the Layout

            TextView text = (TextView) layout.findViewById(R.id.textToShow);                        //set text shown
            text.setText("Welcome back, " + name + "!");
            text.setTextSize(18);                                                                   //set toast text size

            Toast toast = new Toast(getApplicationContext());                                       //set where toast is displayed
            toast.setGravity(Gravity.TOP, 50, 0);

            LinearLayout layoutC = new LinearLayout(this);                                          //set toast background color
            layoutC.setBackgroundResource(R.color.toast_background);

            TextView toastText = new TextView(this);                                                //set toast text color
            toastText.setTextColor(Color.parseColor("#FFA500"));

            toast.setDuration(Toast.LENGTH_LONG);                                                   //set toast appearance duration
            toast.setView(layout);

            toast.show();
        }
        else
        {
            //Pop-up and ask for user's name
            AlertDialog.Builder askName = new AlertDialog.Builder(Sudoku.this);                     //Dialog-s are small askName windows and offer ways for user to input or make choices.
            askName.setTitle("Hello!");
            askName.setMessage("What is your name?");

            //Create EditText for entry
            final EditText username = new EditText(this);
            askName.setView(username);

            askName.setPositiveButton("OK", new DialogInterface.OnClickListener()                   //Create "OK" button
            {   //if OK button pressed:
                public void onClick(DialogInterface dialog, int whichButton) {
                    String inputName = username.getText().toString();                               //Get typed username, convert to type String

                    //Put username in memory and commit!
                    SharedPreferences.Editor e = mySharedPreferences.edit();
                    e.putString(PREF_NAME, inputName);                                              //tell (where, what) to save.
                    e.commit();                                                                     //commit.

                    // Welcome new user; different style toast
                    //Toast.makeText(getApplicationContext(), "Welcome, " + inputName + "!", Toast.LENGTH_LONG).show();

                    //DISPLAYING THE TOAST
                    LayoutInflater inflater = getLayoutInflater();                                  //LayoutInflater used instantiate XMLs that create Views. This involves parsing the XML, creating the View object, and finally adding it to the View hierarchy. create (or fill) View based on XML file in runtime. For example if you need to generate views dynamically for your ListView items.
                    View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.custom_toast_layout));     // Inflate the Layout

                    TextView text = (TextView) layout.findViewById(R.id.textToShow);
                    text.setText("Welcome, " + inputName + "!");                                    //set text shown
                    text.setTextSize(18);                                                                   //set toast text size

                    Toast toast = new Toast(getApplicationContext());                               //set where toast is displayed
                    toast.setGravity(Gravity.TOP, 50, 0);

                    LinearLayout layoutC = new LinearLayout(Sudoku.this);                           //set toast background color
                    layoutC.setBackgroundResource(R.color.toast_background);

                    TextView toastText = new TextView(Sudoku.this);                                 //set toast text color
                    toastText.setTextColor(Color.parseColor("#FFA500"));

                    toast.setDuration(Toast.LENGTH_LONG);                                           //set toast appearance duration
                    toast.setView(layout);

                    toast.show();

                    Button nameButton = (Button) findViewById(R.id.name_button);                                //Access the nameButton defined in main.xml and listen for it here.
                    nameButton.setText("Welcome " + inputName + "!");
                }
            });
            askName.show();                                                                         //ask user enter username
        }
    }

    //SAVE USERNAME USING BUNDLE, ONSAVEINSTANCESTATE, AND ONRESTOREINSTANCESTATE
     //Stores data before pausing the activity.
     protected void onSaveInstanceState(Bundle outState)                                            //protected - can only be accessed by elements in OWN CLASS or classes in the same package
     {
         super.onSaveInstanceState(outState);                                                       //overrides
         outState.putCharSequence("savedName", username);                                           //stores text
         Log.i(TAG, "onSaveIS");
     }

     @Override
     //Retrieves that data back.
     protected void onRestoreInstanceState(Bundle savedInstanceState)
     {
         super.onRestoreInstanceState(savedInstanceState);                                          //overrides
         //Get user's typed text
         username = savedInstanceState.getString(username);                                         //sets textBox as user's text
         Log.i(TAG, "onRestoreIS");
     }

    //onClick xml Attribute
    public void clickWaves(final View view)
    {
        startActivity(new Intent(this, Waves.class));
    }

    public void clickNameButton(final View view)
    {
        Log.d(TAG, "clicked on Name Button");
        displayWelcome();
    }


    public void clickPuzzles( View view)
    {
        Log.d(TAG, "clicked on Puzzles");
        startActivity(new Intent(this, Puzzles.class));
    }

    public void clickPhysics(final View view)
    {

        Log.d(TAG, "clicked on Physics");
        startActivity(new Intent(this, Physics.class));
    }

    public void clickTechnology(final View view)
    {
        startActivity(new Intent(this, Technology.class));
    }

    public void clickHome(final View view)
    {
      //  startActivity(new Intent(this, Home.class));
    }

    public void clickMap(final View view)
    {
       // startActivity(new Intent(this, Map.class));
    }

    public void clickBack(final View view)
    {
      //  startActivity(new Intent(this, Back.class));
    }





    /**
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    */

    //can return something if select an item/.
    /**
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_button:
                return true;
            // More items go here (if any) ...
        }
        return false;
    }
    */

    /**
    //Ask and choose difficulty level
    private void openNewGameDialog()
     {
        new AlertDialog.Builder(this)
        .setTitle(R.string.new_game_title)
        .setItems(R.array.difficulty, new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialoginterface,int i)
                {
                    startGame(i);
                }
            }
        )
        .show();
    }

    /**
     * Start a new game with the given difficulty level
     */
    private void startGame(int i) {
        Log.d(TAG, "clicked on " + i);
        // Start game here...
    }

    public void clickAnimalGame(final View view)
    {
        Intent intent = new Intent();
        intent.setAction("com.deitel.flagquiz");
        sendBroadcast(intent);
    }
}
