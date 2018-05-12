package com.example.ji.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DrawingView draw;
    private Paint mPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        draw = new DrawingView(this);
        setContentView(draw);

    }

    public class DrawingView extends View {

        Path path = new Path();
        Paint paint = new Paint();

        public DrawingView(Context c) {
            super(c);
        }

        public boolean onTouchEvent(MotionEvent event) {

            switch (event.getAction())
            {
                case MotionEvent.ACTION_DOWN: //눌렀을때
                    path.moveTo(event.getX(), event.getY());
                    break;
                case MotionEvent.ACTION_UP: //땠을때

                case MotionEvent.ACTION_MOVE: //이동
                    path.lineTo(event.getX(), event.getY());
                    break;
            }
            invalidate();
            return true;
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.WHITE); //바탕

            paint.setStrokeWidth(10f); //두께
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setColor(Color.BLUE); //색

            canvas.drawPath(path, paint);
        }
    }
}
