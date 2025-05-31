package com.example.face_recognition_attendance_projects.attadance.serivce.util;

import java.awt.Button;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;

import javax.swing.text.html.ImageView;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.tensorflow.op.core.Stage;

import ai.djl.Application;
import ai.djl.modality.cv.Image;
import ai.djl.util.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

@SuppressWarnings("unused")
public class JavaFXMain extends Application {

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	private VideoCapture capture;
	private Mat frame = new Mat();
	private volatile boolean isRunning = true;
	private ImageView imageView;

	@Override
	public void start(Stage stage) {
		capture = new VideoCapture(0); // Open default webcam
		imageView = new ImageView();
		imageView.setFitWidth(640);
		imageView.setPreserveRatio(true);

		TextField empIdField = new TextField();
		empIdField.setPromptText("Enter Employee ID");

		Button captureButton = new Button("📷 Capture & Save");
		captureButton.setOnAction(e -> {
			String employeeId = empIdField.getText();
			if (employeeId != null && !employeeId.isEmpty()) {
				saveImage(frame, employeeId);
			} else {
				System.out.println("❌ Please enter a valid Employee ID!");
			}
		});

		BorderPane root = new BorderPane();
		root.setCenter(imageView);
		VBox controls = new VBox(10, empIdField, captureButton);
		controls.setStyle("-fx-padding: 10;");
		root.setBottom(controls);

		Scene scene = new Scene(root, 700, 550);
		stage.setTitle("🎥 JavaFX Face Capture");
		stage.setScene(scene);
		stage.show();

		startCamera();
		stage.setOnCloseRequest(e -> {
			isRunning = false;
			capture.release();
		});
	}

	private void startCamera() {
		Thread cameraThread = new Thread(() -> {
			while (isRunning && capture.isOpened()) {
				if (capture.read(frame)) {
					BufferedImage img = matToBufferedImage(frame);
					Image fxImage = SwingFXUtils.toFXImage(img, null);
					Platform.runLater(() -> imageView.setImage(fxImage));
				}
			}
		});
		cameraThread.setDaemon(true);
		cameraThread.start();
	}

	private void saveImage(Mat mat, String employeeId) {
		try {
			String folderPath = System.getProperty("user.home") + "/face-data/";
			File dir = new File(folderPath);
			if (!dir.exists()) {
				dir.mkdirs(); // Create folder if it doesn't exist
			}

			String path = folderPath + employeeId + ".jpg";
			Imgcodecs.imwrite(path, mat);
			System.out.println("✅ Image saved to: " + path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private BufferedImage matToBufferedImage(Mat mat) {
		int type = BufferedImage.TYPE_3BYTE_BGR;
		if (mat.channels() == 1) {
			type = BufferedImage.TYPE_BYTE_GRAY;
		}
		BufferedImage image = new BufferedImage(mat.width(), mat.height(), type);
		mat.get(0, 0, ((DataBufferByte) image.getRaster().getDataBuffer()).getData());
		return image;
	}

	public static void main(String[] args) {
		launch();
	}
}
