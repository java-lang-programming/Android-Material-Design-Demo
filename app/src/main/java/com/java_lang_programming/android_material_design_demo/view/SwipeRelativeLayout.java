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
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created on 2016/08/29.
 */
public class SwipeRelativeLayout extends RelativeLayout {

    private final static String TAG = "SwipeRelativeLayout";

    public SwipeRelativeLayout(Context context) {
        super(context);
    }

    public SwipeRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwipeRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setupViewDragHelper();
    }

    private static final float SENSITIVITY = 1.0f;

    private ViewDragHelper viewDragHelper;

    private void setupViewDragHelper() {
        viewDragHelper = ViewDragHelper.create(SwipeRelativeLayout.this, SENSITIVITY, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return true;
            }

            // 上下
            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                return top;
            }

            // 左右
            @Override
            public int clampViewPositionHorizontal(View child, int left, int dy) {
                return left;
            }

            @Override
            public int getViewHorizontalDragRange(View child) {
                int measuredWidth = child.getMeasuredWidth();
                Log.d(TAG, "measuredWidth :" + measuredWidth);
                return measuredWidth;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        final int action = event.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                viewDragHelper.cancel();
                return false;
            default:
                break;
        }
        return viewDragHelper.shouldInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        viewDragHelper.processTouchEvent(event);
        return true;
    }
}
