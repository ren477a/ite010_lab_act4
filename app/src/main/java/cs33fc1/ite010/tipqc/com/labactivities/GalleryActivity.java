package cs33fc1.ite010.tipqc.com.labactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GalleryActivity extends AppCompatActivity {

    private ImageView imgView;
    private Button btnPrevious, btnNext;
    private int[] imageIDs;
    private int curr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        imgView = (ImageView) findViewById(R.id.imageView);
        btnPrevious = (Button) findViewById(R.id.btn_gallery_previous);
        btnNext = (Button) findViewById(R.id.btn_gallery_next);
        imageIDs = new int[5];
        imageIDs[0] = R.drawable.p1;
        imageIDs[1] = R.drawable.p2;
        imageIDs[2] = R.drawable.p3;
        imageIDs[3] = R.drawable.p4;
        imageIDs[4] = R.drawable.p5;
        curr = 0;
        imgView.setImageResource(imageIDs[curr]);

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(R.drawable.p2);
                if(curr==0)
                    curr = 4;
                else
                    curr--;
                imgView.setImageResource(imageIDs[curr]);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(R.drawable.p2);
                if(curr==4)
                    curr = 0;
                else
                    curr++;
                imgView.setImageResource(imageIDs[curr]);
            }
        });




    }
}
