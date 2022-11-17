package tech.xx.a3dlib;

public class NativeLib {

    // Used to load the 'a3dlib' library on application startup.
    static {
        System.loadLibrary("a3dlib");
    }

    /**
     * A native method that is implemented by the 'a3dlib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}