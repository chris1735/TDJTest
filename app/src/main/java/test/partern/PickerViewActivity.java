package test.partern;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ${USER} on 2021/2/23 16:35.
 */
public class PickerViewActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        setContentView(R.layout.activity_picker);

    }

    public void start(View view) {
        System.out.println("~~button.start~~");

        Calendar s = Calendar.getInstance();
        s.set(2019, 2, 18);
        Calendar e = Calendar.getInstance();
        e.set(2021, 2, 18);

        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                System.out.println("~~" + getClass().getSimpleName() + ".onTimeSelect~~");
                System.out.println("date = " + date + ", v = " + v);
            }
        })
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "", "", "")
                .isCenterLabel(true)
                .setLineSpacingMultiplier(1.8f)
                .setDividerColor(Color.DKGRAY)
//                .setContentSize(16)
                .setDate(Calendar.getInstance())
                .setRangDate(s, e)
                .setDecorView(null)
                .build();

        pvTime.show();


    }

}