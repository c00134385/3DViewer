package tech.xx.a3dviewer;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import androidx.annotation.Nullable;

import com.kitware.JavaVTK.JavaVTKActivity;
import com.kitware.JavaVTK.JavaVTKView;

public class TestActivity extends Activity {

    MyGLSurfaceView glSurfaceView;
    JavaVTKView vtkView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        glSurfaceView = findViewById(R.id.gl_surface_view);
//        MyGLSurfaceView glSurceView = new MyGLSurfaceView(this);
        glSurfaceView.setRenderer(new MyRenderer());
//        setContentView(glSurceView);

        vtkView = findViewById(R.id.vtk_view);
    }

    @Override
    protected void onPause() {
        super.onPause();
        vtkView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        vtkView.onResume();
    }
}
