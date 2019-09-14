package jcv.com.mascotas.publicaciones;

import androidx.appcompat.app.AppCompatActivity;
import jcv.com.mascotas.R;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class DetallePublicacionActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 30;
    private GestureDetector mGestureDetector;
    private View.OnTouchListener mGestureListener;
    private ImageView mImageView;
    private Integer[] mImagesList = { R.drawable.ic_action_call, R.drawable.ic_action_edit,
            R.drawable.ic_action_edit, R.drawable.ic_action_regresar};
    private int mPhoto;
    private RelativeLayout mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_publicacion);
        mPhoto = 0;
        mView = (RelativeLayout) findViewById(R.id.vista_fotos);
        mImageView = (ImageView) findViewById(R.id.image);

        // initialize with the first image
        mImageView.setImageResource(mImagesList[mPhoto]);

        // Gesture detection
        mGestureDetector = new GestureDetector(new MyGestureDetector());
        mGestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return mGestureDetector.onTouchEvent(event);
            }
        };
        // prevent the view to be touched
        mView.setOnClickListener(this);
        mView.setOnTouchListener(mGestureListener);
    }
    public class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            try {
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                    return false;
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mPhoto = (mPhoto + 1) % mImagesList.length;
                    mImageView.setImageResource(mImagesList[mPhoto]);
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mPhoto = (mPhoto - 1) % mImagesList.length;
                    if (mPhoto < 0) {
                        mPhoto = 0;
                    }
                    mImageView.setImageResource(mImagesList[mPhoto]);
                }
            } catch (Exception e) {
                Log.e("SwypeImagesActivity", "error on gesture detector");
            }
            return false;
        }
    }

    @Override
    public void onClick(View view) {

    }
}
