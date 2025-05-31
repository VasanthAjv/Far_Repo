package com.example.face_recognition_attendance_projects.attadance.serivce.util;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.imgproc.Imgproc;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.io.InputStream; 

import java.nio.file.StandardCopyOption;

@Component
public class FaceRecognitionUtil {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // Load native OpenCV library
    }

    public boolean matchFace(String imagePath, String employeeId) {
        try {
            // Read input image from file path
            Mat inputMat = Imgcodecs.imread(imagePath);
            if (inputMat.empty()) {
                System.out.println("Image not found or invalid: " + imagePath);
                return false;
            }

         // Use getInputStream instead of getFile (better for packaged apps)
         // Step 1: Load XML file as InputStream
            ClassPathResource resource = new ClassPathResource("haarcascade_frontalface_default.xml");
            InputStream inputStream = resource.getInputStream();

            // Step 2: Create a temporary file to write the InputStream to
            File tempXml = File.createTempFile("haarcascade", ".xml");
            Files.copy(inputStream, tempXml.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Step 3: Use the absolute path of the temp file in CascadeClassifier
            CascadeClassifier faceDetector = new CascadeClassifier(tempXml.getAbsolutePath());
            // Detect faces
            MatOfRect faceDetections = new MatOfRect();
            faceDetector.detectMultiScale(inputMat, faceDetections);

            System.out.println("Faces detected: " + faceDetections.toArray().length);
            if (faceDetections.toArray().length == 0) {
                return false;
            }

            // Crop the first detected face
            Rect rect = faceDetections.toArray()[0];
            Mat croppedFace = new Mat(inputMat, rect);
            Imgproc.resize(croppedFace, croppedFace, new Size(200, 200));

         // Load reference face image based on employeeId
            String referencePath = "src/main/resources/reference_faces/" + employeeId + ".jpg";
            Mat reference = Imgcodecs.imread(referencePath);
            if (reference.empty()) {
                System.out.println("Reference image not found for employee ID: " + employeeId);
                return false;
            }
            Imgproc.resize(reference, reference, new Size(200, 200));

            // Compare faces using absolute difference
            Mat diff = new Mat();
            Core.absdiff(croppedFace, reference, diff);

            // Convert to grayscale and compute sum of differences
            Mat grayDiff = new Mat();
            Imgproc.cvtColor(diff, grayDiff, Imgproc.COLOR_BGR2GRAY);
            double diffSum = Core.sumElems(grayDiff).val[0];

            System.out.println("Difference score: " + diffSum);

            return diffSum < 500000; // You can fine-tune this threshold

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
