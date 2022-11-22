package tech.xx.a3dviewer;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyRenderer implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
//设置清屏颜色
        gl.glClearColor(1, 0, 1, 1);
        //启动绘制顶点数组
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
//设置视口区域
        gl.glViewport(0, 0, width, height);
        //设置绘制模式
        gl.glMatrixMode(GL10.GL_PROJECTION);
        //设置为单例矩阵
        gl.glLoadIdentity();
        float ration = (float)width/(float)height;
        //设置平截头体 左，右，下，上，近平面，远平面
        gl.glFrustumf(-1f, 1f, -ration, ration, 3, 7);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
//清除缓存颜色区域
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        //设置模型视图
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();//加载单位矩阵
        //眼睛放置的位置
        //GL10 gl, float eyeX, float eyeY, float eyeZ, 眼睛放置的位置
        //float centerX, float centerY, float centerZ, 相机放置的位置
        //float upX, float upY, float upZ 相机的朝向
        GLU.gluLookAt(gl, 0, 0, 5, 0, 0, 0, 0, 1, 0);
        //定义三角形的点x,y,z
        float[] coords = {
                0f,0.5f,0f,
                -0.5f,-0.5f,0f,
                0.5f,-0.5f,0f
        };
        //存到内存缓存区
        ByteBuffer buffer = ByteBuffer.allocateDirect(coords.length *4);
        buffer.order(ByteOrder.nativeOrder());
        //放置顶点坐标
        FloatBuffer floatBuf = buffer.asFloatBuffer();
        floatBuf.put(coords);//将点存放到floatBuffer里面
        buffer.position(0);//指针指向0
        //制定绘制点的颜色
        gl.glColor4f(1f, 0f, 0f, 1f);
        //开始绘制点
        //3 三维点, type数据类型，0跨度，顶点缓冲区
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, buffer);
        //设置绘制三角形
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
    }
}
