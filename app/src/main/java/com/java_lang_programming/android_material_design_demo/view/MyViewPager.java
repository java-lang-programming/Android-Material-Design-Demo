/**
 * Copyright (C) 2016 Programming Java Android Development Project
 * Programming Java is
 * <p>
 * http://java-lang-programming.com/ja/articles/53
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.java_lang_programming.android_material_design_demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by msuzuki on 2016/09/24.
 */
public class MyViewPager extends ViewPager {


    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
//        TypedArray a = context.obtainStyledAttributes(R.styleable.View);
//        a.recycle();
    }

    /**
     * 影のpaddingを無視したdraw
     * https://github.com/android/platform_frameworks_support/blob/master/v4/java/android/support/v4/view/ViewPager.java
     *
     * @param canvas
     */
    @Override
    public void draw(Canvas canvas) {
        //final boolean clipToPadding = getClipToPadding();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        super.setPadding(paddingLeft, 0, paddingRight, 0);
        // drawだけpaddingを無視(clippadding)
        super.draw(canvas);
        // 戻す
        super.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
