package com.unity3d.services.core.api;

import com.unity3d.services.core.sensorinfo.SensorInfoError;
import com.unity3d.services.core.sensorinfo.SensorInfoListener;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

import org.json.JSONObject;

public class SensorInfo {

	@WebViewExposed
	public static void startAccelerometerUpdates(final Integer sensorDelay, final WebViewCallback callback) {
		callback.invoke(SensorInfoListener.startAccelerometerListener(sensorDelay));
	}

	@WebViewExposed
	public static void stopAccelerometerUpdates(final WebViewCallback callback) {
		SensorInfoListener.stopAccelerometerListener();
		callback.invoke();
	}

	@WebViewExposed
	public static void isAccelerometerActive(final WebViewCallback callback) {
		callback.invoke(SensorInfoListener.isAccelerometerListenerActive());
	}

	@WebViewExposed
	public static void getAccelerometerData(final WebViewCallback callback) {
		JSONObject accelerometerData = SensorInfoListener.getAccelerometerData();
		if(accelerometerData != null) {
			callback.invoke(accelerometerData);
		} else {
			callback.error(SensorInfoError.ACCELEROMETER_DATA_NOT_AVAILABLE);
		}
	}
}
