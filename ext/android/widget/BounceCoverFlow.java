package android.widget;

import android.app.Activity;

/**
 * Created by Fraggel on 15/11/13.
 */
public interface BounceCoverFlow {
    void setGravity(int centerVertical);

    void setSpacing(int dimensionPixelSize);

    void setAdapter(BookmarkAdapter mAdapter);

    void setSelection(int mCurrentScenePos);

    void setEmptyView(Object o);

    void setMaxZoomOut(int maxZoomOut);


    void setOnItemSelectedListener(Activity sceneChooser);
}
