package com.example.android.lastass;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import com.hsalf.smilerating.SmileRating;
public class RatingActivity extends AppCompatActivity {
private SmileRating smileRating;
private Button button;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rating);

    smileRating = findViewById(R.id.smile_rating);
    button  = findViewById(R.id.button);

    smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
        @Override
        public void onSmileySelected(int smiley, boolean reselected) {
            // reselected is false when user selects different smiley that previously selected one
            // true when the same smiley is selected.
            // Except if it first time, then the value will be false.
            switch (smiley) {
                case SmileRating.BAD:
                    Toast.makeText(RatingActivity.this,
                            "Bad",Toast.LENGTH_SHORT).show();
                    break;
                case SmileRating.GOOD:
                    Toast.makeText(RatingActivity.this,
                            "Good",Toast.LENGTH_SHORT).show();
                    break;
                case SmileRating.GREAT:
                    Toast.makeText(RatingActivity.this,
                            "Great",Toast.LENGTH_SHORT).show();
                    break;
                case SmileRating.OKAY:
                    Toast.makeText(RatingActivity.this,
                            "Okay",Toast.LENGTH_SHORT).show();
                    break;
                case SmileRating.TERRIBLE:
                    Toast.makeText(RatingActivity.this,
                            "Terrible",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    });
}
public void clickMe(View view) {
            PopupMenu popup = new PopupMenu(RatingActivity.this, button);
            popup.getMenuInflater().inflate(R.menu.poppup_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(RatingActivity.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
            popup.show();
        }
}
