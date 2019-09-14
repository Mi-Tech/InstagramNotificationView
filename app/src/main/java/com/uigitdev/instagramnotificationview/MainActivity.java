package com.uigitdev.instagramnotificationview;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.uigitdev.instagramnotificationview.model.MNotification;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout notification_button;
    private RelativeLayout like_parent, comment_parent, follow_parent;
    private TextView like_num, comment_num, follow_num;

    private int maxNums = 999;
    private MNotification notification;

    //Test
    private int testNotification = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setType();
        setOnClickNotifications();
        notification = new MNotification(1, 1, 1);
        notificationView(notification);
        //Test method
        setNotificationTest();
    }

    private void setType() {
        notification_button = findViewById(R.id.notification_button);
        like_parent = findViewById(R.id.like_parent);
        comment_parent = findViewById(R.id.comment_parent);
        follow_parent = findViewById(R.id.follow_parent);
        like_num = findViewById(R.id.like_num);
        comment_num = findViewById(R.id.comment_num);
        follow_num = findViewById(R.id.follow_num);
    }

    private void setOnClickNotifications() {
        notification_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Notification click", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void notificationView(MNotification notification) {
        if (notification.getLikes() > 0) {
            like_parent.setVisibility(View.VISIBLE);
            if (notification.getLikes() > maxNums) {
                like_num.setText(maxNums + "+");
            } else {
                like_num.setText(String.valueOf(notification.getLikes()));
            }
        } else {
            like_parent.setVisibility(View.GONE);
        }
        if (notification.getComments() > 0) {
            comment_parent.setVisibility(View.VISIBLE);
            if (notification.getComments() > maxNums) {
                comment_num.setText(maxNums + "+");
            } else {
                comment_num.setText(String.valueOf(notification.getComments()));
            }
        } else {
            comment_parent.setVisibility(View.GONE);
        }
        if (notification.getFollowers() > 0) {
            follow_parent.setVisibility(View.VISIBLE);
            if (notification.getFollowers() > maxNums) {
                follow_num.setText(maxNums + "+");
            } else {
                follow_num.setText(String.valueOf(notification.getFollowers()));
            }
        } else {
            follow_parent.setVisibility(View.GONE);
        }
    }

    private void setNotificationTest() {
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                testNotification++;

                switch (testNotification) {
                    case 1:
                        notification.setLikes(0);
                        notification.setComments(18);
                        notification.setFollowers(1888);
                        notificationView(notification);
                        setNotificationTest();
                        break;
                    case 2:
                        notification.setLikes(998);
                        notification.setComments(0);
                        notification.setFollowers(1);
                        notificationView(notification);
                        setNotificationTest();
                        break;
                    case 3:
                        notification.setLikes(0);
                        notification.setComments(0);
                        notification.setFollowers(501);
                        notificationView(notification);
                        setNotificationTest();
                        break;
                    case 4:
                        notification.setLikes(8);
                        notification.setComments(18);
                        notification.setFollowers(1888);
                        notificationView(notification);
                        setNotificationTest();
                        break;
                    case 5:
                        notification.setLikes(1000);
                        notification.setComments(1000);
                        notification.setFollowers(1000);
                        notificationView(notification);
                        setNotificationTest();
                        break;
                    case 6:
                        notification.setLikes(81);
                        notification.setComments(185);
                        notification.setFollowers(0);
                        notificationView(notification);
                        break;
                }
            }
        }.start();
    }
}
