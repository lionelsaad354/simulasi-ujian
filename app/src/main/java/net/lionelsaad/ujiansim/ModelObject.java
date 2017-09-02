package net.lionelsaad.ujiansim;

/**
 * Created by Saad on 8/9/2017.
 */
public enum ModelObject {
    IAK(R.string.view_page_2, R.layout.apa_itu_iak),
    HOW(R.string.view_page_1, R.layout.cara_join_iak);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}