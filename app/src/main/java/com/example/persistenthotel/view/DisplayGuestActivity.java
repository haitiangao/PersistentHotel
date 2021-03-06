package com.example.persistenthotel.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.persistenthotel.database.myDatabaseHelper;
import com.example.persistenthotel.model.Guest;
import com.example.persistenthotel.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayGuestActivity extends AppCompatActivity {
    public static final String GUEST_KEY ="get.guest.info";

    @BindView(R.id.selected_Prefix)
    TextView selectedPrefix;
    @BindView(R.id.selected_Guest)
    TextView selectedGuest;
    @BindView(R.id.dateView)
    TextView dateView;
    @BindView(R.id.finishButton)
    Button finishButton;
    @BindView(R.id.hotel_Number_view)
    TextView hotelRoomView;
    @BindView(R.id.profile_imageview)
    ImageView profilePicture;



    private myDatabaseHelper databaseHelper;
    private Guest showGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_guest);

        ButterKnife.bind(this);

        Bundle data = getIntent().getExtras();
        showGuest = (Guest) data.getParcelable(GUEST_KEY);
        selectedGuest.setText(showGuest.getActualName());
        selectedPrefix.setText(showGuest.getPrefix());
        dateView.setText(showGuest.getDateMade());
        hotelRoomView.setText(String.format("Room number: %s", showGuest.getRoomNumber()));

        Log.d("TAG_H", "Guest prefex:  " + showGuest.getPrefix());

        if (showGuest.getPrefix().equals("")) {
            Glide.with(this)
                    .load("https://www.pngkey.com/png/full/308-3081138_contact-avatar-generic.png")
                    .into(profilePicture);
        }
        else if ("Mr.".equals(showGuest.getPrefix())) {
            Glide.with(this)
                    .load("https://www.krocmemphis.org/wp-content/uploads/2016/10/generic-avatar.png")
                    .into(profilePicture);

        }
        else if ("Mrs.".equals(showGuest.getPrefix())) {
            Glide.with(this).load("https://curatti.com/wp-content/uploads/2017/05/generic-avatar-image1.png").into(profilePicture);

        }
        else if ("Ms.".equals(showGuest.getPrefix())) {
            Glide.with(this).load("https://publicdomainvectors.org/tn_img/Female-Avatar-3.png").into(profilePicture);

        }
        else if ("Dr.".equals(showGuest.getPrefix())) {
            Glide.with(this).load("https://www.rochesterregional.org/physician-directory/t/taylor-adia/-/media/rrh/physicians/t/generic-avatar.jpg").into(profilePicture);

        }
        databaseHelper = new myDatabaseHelper(this,
                null, null, 0);

    }


    public void deleteGuest(View view) {
        databaseHelper.deleteGuest(showGuest);

        //Log.d("TAG_H", "Username:  " + showGuest.getGuestID());
        databaseHelper.close();
        finish();
    }

    public void backToPrevious(View view){
        finish();
    }

}
