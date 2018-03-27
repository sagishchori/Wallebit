package wallebit.sagishchori.com.wallebit.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircleImageView extends android.support.v7.widget.AppCompatImageView
{
    public CircleImageView(Context context)
    {
        this(context, null);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
//        Drawable drawable = getDrawable();
//
//        if (drawable == null)
//            return;
//
//        if (getWidth() == 0 || getHeight() == 0)
//            return;
//
//        Bitmap b = ((BitmapDrawable)drawable).getBitmap();
//        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);
//
//        int w = getWidth(), h = getHeight();
//
//        Bitmap roundBitmap = getCroppedBitmap(bitmap, w);
//
//        canvas.drawBitmap(roundBitmap, 0, 0, null);
    }

    private Bitmap getCroppedBitmap(Bitmap bitmap, int radius)
    {
        Bitmap scaledBitmap;

        if (bitmap.getWidth() != radius || bitmap.getHeight() != radius)
            scaledBitmap = Bitmap.createScaledBitmap(bitmap, radius, radius, false);
        else
            scaledBitmap = bitmap;

        Bitmap output = Bitmap.createBitmap(scaledBitmap.getWidth(), scaledBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(Color.parseColor("#BAB399"));

        Rect rect = new Rect(0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight());

        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(scaledBitmap.getWidth() / 2+0.7f, scaledBitmap.getHeight() / 2+0.7f,
                scaledBitmap.getWidth() / 2+0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(scaledBitmap, rect, rect, paint);

        return output;
    }
}
