package solutions.alterego.android.common;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Keyboard {

    /**
     * Hides the SoftKeyboard input careful as if you pass a view that didn't open the
     * soft-keyboard it will ignore this call and not close
     *
     * @param v the view that opened the soft-keyboard
     */
    public static void requestHideKeyboard(View v) {
        if (!v.isInEditMode()) {
            InputMethodManager imm = ((InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE));
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}
