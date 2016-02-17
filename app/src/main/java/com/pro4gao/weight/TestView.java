package com.pro4gao.weight;

import android.content.Context;
import android.view.View;
import android.widget.Scroller;

/**
 * 一个可以移动的view，用来测试scroller
 * Created by gao on 2016/1/25.
 */
public class TestView  extends View{
    private Context context;
    public TestView(Context context) {
        super(context);
        this.context=context;
    }
    Scroller scroller= new Scroller(context);

    private void smoothScrollTo(int destX,int destY) {
        int scrollX=getScrollX();
        int detalX=destX-scrollX;
        scroller.startScroll(scrollX,0,detalX,1000);
        //invalidate会导致重绘，view的onDraw方法会调用computeScroll
        //computeScroll在view中是一个空实现所以在自定义的这个view中我们已经实现了
        invalidate();
    }

    @Override
    public void computeScroll() {
        //computeScrollOffset根据时间流逝的百分比算出当前XY的值
      if(scroller.computeScrollOffset()){
          scrollTo(scroller.getCurrX(),scroller.getCurrY());
          postInvalidate();
      }
    }



}
