package opencv.demo.com.camerastream;

import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import com.github.hiteshsondhi88.libffmpeg.ExecuteBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.FFmpeg;
import com.github.hiteshsondhi88.libffmpeg.LoadBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegCommandAlreadyRunningException;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegNotSupportedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.SocketException;

import jlibrtp.RTPSession;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback , View.OnClickListener {
    

    SurfaceView recordingView;
    Camera camera;
    private int cameraId;
    private Camera.Parameters params;
    int imageFormat,frameWidth,frameHeight;
    RTPSession rtpSession;
    FFmpeg ffmpeg;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recordingView = (SurfaceView) findViewById(R.id.recordingScreen);
        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
        // SurfaceHolder to set the camera preview surface.
        SurfaceHolder surfaceHolder = recordingView.getHolder();
        surfaceHolder.addCallback(MainActivity.this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);


    }


    @Override
    protected void onStart() {
        super.onStart();
        try {
            DatagramSocket rtpSocket = new DatagramSocket();
            DatagramSocket rtcpSocket = new  DatagramSocket();
            //rtpSession = new RTPSession(rtpSocket, rtcpSocket);
        }
        catch (SocketException se){

        }
        cameraId = Camera.CameraInfo.CAMERA_FACING_BACK;
        getCameraInstance(cameraId);
    }


    // Method used to get camera instance.
    public void getCameraInstance(int camid){
        releaseCamera();

        if (camera == null) {

            try {
                camera = Camera.open(camid);
                params = camera.getParameters();
                camera.setDisplayOrientation(90);
                camera.setPreviewCallback(callback);

                Log.d("Inside","getCameraInstance");
            } catch (RuntimeException e) {
                Log.e("Camera Error.Error: ", e.getMessage());
            }

        }

    }

    // Method used to release camera instance.
    void releaseCamera() {
        try {
            if (this.camera != null) {

                camera.setPreviewCallback(null);
                camera.setErrorCallback(null);
                this.camera.stopPreview();
                this.camera.release();
                this.camera = null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            Log.e("error", e.toString());
            camera = null;
        }
        Log.d("Camera ","Cam relase");
    }




    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        Log.e("Check", "SurfaceCreated");
        if(camera!=null) {
            try {
                camera.setPreviewDisplay(holder);
                camera.startPreview();
            } catch (IOException e) {
                Log.e("TAG", e.getMessage());
                e.printStackTrace();
            }
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    Camera.PreviewCallback callback = new Camera.PreviewCallback() {
        @Override
        public void onPreviewFrame(byte[] data, Camera camera) {
            //Do your processing here... Use the byte[] called "data"
                Log.d("Cam ","Cam preview callback");
            try {
                File f=new  File(Environment.getExternalStorageDirectory()+"/test.data");
                if(!f.exists()){
                    f.createNewFile();
                }
                OutputStream outStream = new FileOutputStream(f,true);

                Camera.Parameters parameters = camera.getParameters();
                imageFormat = parameters.getPreviewFormat();
                if (imageFormat == ImageFormat.NV21) {
                    Camera.Size previewSize = parameters.getPreviewSize();
                    frameWidth = previewSize.width;
                    frameHeight = previewSize.height;
                    Rect rect = new Rect(0, 0, frameWidth, frameHeight);
                    YuvImage img = new YuvImage(data, ImageFormat.NV21, frameWidth, frameHeight, null);
                    outStream.write(data);
                    ExecFFMPEGCommand ffmpgcmd=new ExecFFMPEGCommand();
                    ffmpgcmd.execute();
                    outStream.flush();
                }
            }
            catch (FileNotFoundException iex){
                Log.d("File :-",iex.getMessage());

            }
            catch (IOException iexp){
                Log.d("File :-","IOExcp"+iexp.getMessage());
            }
        }
    };

    @Override
    public void onClick(View v) {

    }


    void ffmpegLoadBinary() {
        ffmpeg = FFmpeg.getInstance(MainActivity.this);
        try {
            ffmpeg.loadBinary(new LoadBinaryResponseHandler() {

                @Override
                public void onStart() {
                    Log.d("FFmpeg ", "Ffmpeg started");
                }

                @Override
                public void onFailure() {
                    Log.d("FFmpeg ", "Ffmpeg failure");
                }

                @Override
                public void onSuccess() {
                    Log.d("FFmpeg ", "Ffmpeg success");
                }

                @Override
                public void onFinish() {
                    Log.d("FFmpeg ", "Ffmpeg finish");
                }
            });
        } catch (FFmpegNotSupportedException e) {
            // Handle if FFmpeg is not supported by device
            Log.d("FFmpeg ", "Ffmpeg Error" + e.getMessage());
        }

    }


    void executeFfmpegCommand(String ffmpegCommand) {
        //FFmpeg ffmpeg = FFmpeg.getInstance(mContext);
        try {
            // to execute "ffmpeg -version" command you just need to pass "-version"
            ffmpeg.execute(ffmpegCommand, new ExecuteBinaryResponseHandler() {

                @Override
                public void onStart() {
                    Log.d("FFmpeg ", "Ffmpeg command started");
                }

                @Override
                public void onProgress(String message) {
                    Log.d("FFmpeg ", "Ffmpeg command message -> " + message);
                }

                @Override
                public void onFailure(String message) {
                    Log.d("FFmpeg ", "Ffmpeg command failed message ->" + message);
                }

                @Override
                public void onSuccess(String message) {
                    Log.d("FFmpeg ", "Ffmpeg command success message ->" + message);
                }

                @Override
                public void onFinish() {



                }
            });
        } catch (FFmpegCommandAlreadyRunningException e) {
            // Handle if FFmpeg is already running
            Log.d("FFmpeg ", "Ffmpeg Error" + e.getMessage());
        }
    }


    class ExecFFMPEGCommand extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            ffmpegLoadBinary();
            String ffmpegCommand=" -f rawvideo -pix_fmt nv21 -s 640x480 -r 15 -i " + Environment.getExternalStorageDirectory()+"/test.data" +" rtmp://oodles:oodles@192.168.2.61:1935/live/mstream.flv ";
            Log.d("Cmd ",ffmpegCommand);
            executeFfmpegCommand(ffmpegCommand);
            return null;
        }
    }

}
