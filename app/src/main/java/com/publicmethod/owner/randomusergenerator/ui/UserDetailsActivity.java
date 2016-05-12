package com.publicmethod.owner.randomusergenerator.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.publicmethod.owner.randomusergenerator.R;
import com.publicmethod.owner.randomusergenerator.model.Location;
import com.publicmethod.owner.randomusergenerator.model.Result;
import com.squareup.picasso.Picasso;

public class UserDetailsActivity extends AppCompatActivity {

    private static final String TAG = "UserDetailsActivity";
    private EditText mEditTextFirstName,
            mEditTextLastName,
            mEditTextPhone,
            mEditTextCellPhone,
            mEditTextEmail,
            mEditTextLocation;

    private ImageView mImageViewToolbarLayout;
    private Uri mUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Get the result from the intent
        Result result = getIntent().getParcelableExtra("result");

        // Initialize the variables required
        initializeVariables(result);

        // Do the logical
        populateFields(result);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initializeVariables(Result result) {
        mEditTextFirstName = (EditText) findViewById(R.id.editText_name_first);
        mEditTextLastName = (EditText) findViewById(R.id.editText_name_last);
        mEditTextPhone = (EditText) findViewById(R.id.editText_phone);
        mEditTextCellPhone = (EditText) findViewById(R.id.editText_cell_phone);
        mEditTextEmail = (EditText) findViewById(R.id.editText_email);
        mEditTextLocation = (EditText) findViewById(R.id.editText_location);
        mImageViewToolbarLayout = (ImageView) findViewById(R.id.toolbar_layout_image_view);
        mUri = Uri.parse(result.getPicture().getLarge());
    }

    private void populateFields(Result result) {
        mEditTextFirstName.setText(result.getName().getFirst());

        Picasso.with(this)
                .load(mUri)
                .into(mImageViewToolbarLayout);

        mEditTextLastName.setText(result.getName().getLast());
        mEditTextPhone.setText(result.getPhone());
        mEditTextCellPhone.setText(result.getCell());
        mEditTextEmail.setText(result.getEmail());

        Location resultLocation = result.getLocation();
        String location = String.format("%s, %s, %s, %s",
                resultLocation.getStreet(),
                resultLocation.getCity(),
                resultLocation.getState(),
                resultLocation.getPostcode());
        mEditTextLocation.setText(location);

    }
}
