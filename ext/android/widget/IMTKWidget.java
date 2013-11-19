package android.widget;

/**
 * Created by Fraggel on 15/11/13.
 */
public interface IMTKWidget {
    void enterAppwidgetScreen();

    void leaveAppwidgetScreen();

    void startDrag();

    void setScreen(int page);

    void stopDrag();

    void moveIn(int page);

    boolean moveOut(int mCurrentPage);

    void startCovered(int page);

    void stopCovered(int page);

    void onPauseWhenShown(int page);

    void onResumeWhenShown(int page);

    void setWidgetId(int appWidgetId);
    
}
