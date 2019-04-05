package com.github.godness84.RNRecyclerViewList;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

public class RecyclerViewItemView extends ViewGroup {
    private static final String TAG = "RecyclerViewItem";

    private int mItemIndex;
    private boolean mItemIndexInitialized;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // noop
    }

    public void setItemIndex(int itemIndex) {
        if (mItemIndexInitialized  && this.mItemIndex != itemIndex){
            this.mItemIndex = itemIndex;
            if (getParent() instanceof RecyclerViewBackedScrollView.RecyclableWrapperViewGroup) {
                ((RecyclerViewBackedScrollView.RecyclableWrapperViewGroup) getParent()).getAdapter().notifyItemChanged(itemIndex);
            }
        } else {
            this.mItemIndex = itemIndex;
        }

        mItemIndexInitialized = true;
    }

    public int getItemIndex() {
        return mItemIndex;
    }
}
