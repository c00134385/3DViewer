package tech.xx.javavtk;

public class NativeLib {

    // Used to load the 'javavtk' library on application startup.
    static {
        System.loadLibrary("javavtk");
    }

    /**
     * A native method that is implemented by the 'javavtk' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}