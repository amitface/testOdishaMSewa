package com.test.orissa.msewa.utility;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hp on 20/01/2016.
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int leftSpace;
    private int rightLeft;
    private int bottomSpace;
    private int mSizeGridSpacingPx;
    private int mGridSize;

    private boolean mNeedLeftSpacing = false;

    public SpacesItemDecoration(int leftSpace, int rightLeft, int bottomSpace) {
        this.leftSpace = leftSpace;
        this.rightLeft = rightLeft;
        this.bottomSpace = bottomSpace;
    }

//    public SpacesItemDecoration(int gridSpacingPx, int gridSize) {
//        mSizeGridSpacingPx = gridSpacingPx;
//        mGridSize = gridSize;
//    }
//


    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {


        outRect.bottom = bottomSpace;

        int position = parent.getChildAdapterPosition(view);
       if((position%2)==0)
        {
            outRect.left = leftSpace;
            outRect.right = rightLeft+2;
        }
        else
        { outRect.left = rightLeft+2;
            outRect.right = leftSpace;
        }


    }







}
