package kjn.com.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Scroller;

/**
 * 作者：Konng on 2017/5/2 10:49
 * 邮箱：197726885@qq.com
 * 说明：
 * 详细：
 */

public class ScollerView extends View implements View.OnClickListener {

    private final Scroller mScroller;
    private Paint mPaint;
    private int MODE = 0;

    public ScollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
        this.setOnClickListener(this);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(10);
        mPaint.setTextSize(36);
    }

    public void setMode(int mode) {
        MODE = mode;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String s = "起始位置";
        canvas.drawText(s, getWidth() / 2 - 20, getHeight() / 2, mPaint);
    }

    private void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        int scrollY = getScrollY();
        int deltY = scrollY + destY;
        //100ms 内滑向 destX ,效果就是慢慢滑动
        mScroller.startScroll(scrollX, 0, delta, deltY, 1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    public void onClick(View v) {
        switch (MODE) {
            case 0:
                smoothScrollTo(100, 0);
                break;
            case 1:
                smoothScrollTo(-100, 0);
                break;
            case 2:
                smoothScrollTo(-100, 100);
                break;
            case 3:
                smoothScrollTo(0, 100);
                break;
            case 4:
                smoothScrollTo(0, -100);
                break;
            default:
                break;
        }
    }

    public static void log(String str) {
        Log.d("main", str);
    }
}
