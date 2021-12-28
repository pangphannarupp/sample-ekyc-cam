package mcnc.plugin.ekyc.cam;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import android.util.Log;
import com.mcnc.ekyc_camera.EkycCamera;
import com.mcnc.ekyc_camera.interfaces.PhotoListener;

/**
 * This class echoes a string called from JavaScript.
 */
public class EkycCam extends CordovaPlugin {
    private static final String TAG = "EKYC CAM";
    EkycCamera ekycCamera;

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        ekycCamera = new EkycCamera(cordova.getActivity());

        Log.d(TAG, "Initialize EKYC CAM");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("takeIdCard")) {
            try {
                JSONObject dataJson = args.getJSONObject(0);
                this.takeIdCard(dataJson, callbackContext);
            } catch(JSONException e) {
                callbackContext.error("Error JSON");
            }
            return true;
        } else if (action.equals("takeSelfie")) {
            try {
                JSONObject dataJson = args.getJSONObject(0);
                this.takeSelfie(dataJson, callbackContext);
            } catch(JSONException e) {
                callbackContext.error("Error JSON");
            }
            return true;
        }
        return false;
    }

    private void takeIdCard(JSONObject option, CallbackContext callbackContext) {
        try {
            JSONObject cameraTakeIdCardOption = new JSONObject();
            
            //Put License Key
            final String LICENSE_KEY = "licenseKey";
            if(option.has(LICENSE_KEY) && !option.isNull(LICENSE_KEY)) {
                cameraTakeIdCardOption.put(LICENSE_KEY, option.getString(LICENSE_KEY));
            }
            
            //Put isCropped
            final String IS_CROPPED = "isCropped";
            if(option.has(IS_CROPPED) && !option.isNull(IS_CROPPED)) {
                cameraTakeIdCardOption.put(IS_CROPPED, option.getBoolean(IS_CROPPED));
            }
            
            //Put width
            final String WIDTH = "width";
            if(option.has(WIDTH) && !option.isNull(WIDTH)) {
                cameraTakeIdCardOption.put(WIDTH, Float.parseFloat(option.get(WIDTH).toString()));
            }
            
            //Put showFlashButton
            final String SHOW_FLASH_BUTTON = "showFlashButton";
            if(option.has(SHOW_FLASH_BUTTON) && !option.isNull(SHOW_FLASH_BUTTON)) {
                cameraTakeIdCardOption.put(SHOW_FLASH_BUTTON, option.getBoolean(SHOW_FLASH_BUTTON));
            }
            
            //Put imageQuality
            final String IMAGE_QUALITY = "imageQuality";
            if(option.has(IMAGE_QUALITY) && !option.isNull(IMAGE_QUALITY)) {
                cameraTakeIdCardOption.put(IMAGE_QUALITY, Float.parseFloat(option.get(IMAGE_QUALITY).toString()));
            }
            
            //Put showOverlay
            final String SHOW_OVERLAY = "showOverlay";
            if(option.has(SHOW_OVERLAY) && !option.isNull(SHOW_OVERLAY)) {
                cameraTakeIdCardOption.put(SHOW_OVERLAY, option.getBoolean(SHOW_OVERLAY));
            }
            
            //Put captureButtonColor
            final String CAPTURE_BUTTON_COLOR = "captureButtonColor";
            if(option.has(CAPTURE_BUTTON_COLOR) && !option.isNull(CAPTURE_BUTTON_COLOR)) {
            cameraTakeIdCardOption.put(CAPTURE_BUTTON_COLOR, option.getString(CAPTURE_BUTTON_COLOR));
            }
            
            //Put topLabelOption
            final String TOP_LABEL_OPTION = "topLabelOption";
            if(option.has(TOP_LABEL_OPTION) && !option.isNull(TOP_LABEL_OPTION)) {
                JSONObject topLabelOption = new JSONObject();
                if(option.getJSONObject(TOP_LABEL_OPTION).has("text") && !option.getJSONObject(TOP_LABEL_OPTION).isNull("text")) {
                    topLabelOption.put("text", option.getJSONObject(TOP_LABEL_OPTION).getString("text"));
                }
                if(option.getJSONObject(TOP_LABEL_OPTION).has("color") && !option.getJSONObject(TOP_LABEL_OPTION).isNull("color")) {
                    topLabelOption.put("color", option.getJSONObject(TOP_LABEL_OPTION).getString("color"));
                }
                if(option.getJSONObject(TOP_LABEL_OPTION).has("size") && !option.getJSONObject(TOP_LABEL_OPTION).isNull("size")) {
                    topLabelOption.put("size", option.getJSONObject(TOP_LABEL_OPTION).getInt("size"));
                }
                cameraTakeIdCardOption.put(TOP_LABEL_OPTION, topLabelOption);
            }
            
            //Put bottomLabelOption
            final String BOTTOM_LABEL_OPTION = "bottomLabelOption";
            if(option.has(BOTTOM_LABEL_OPTION) && !option.isNull(BOTTOM_LABEL_OPTION)) {
                JSONObject bottomLabelOption = new JSONObject();
                if(option.getJSONObject(BOTTOM_LABEL_OPTION).has("text") && !option.getJSONObject(BOTTOM_LABEL_OPTION).isNull("text")) {
                    bottomLabelOption.put("text", option.getJSONObject(BOTTOM_LABEL_OPTION).getString("text"));
                }
                if(option.getJSONObject(BOTTOM_LABEL_OPTION).has("color") && !option.getJSONObject(BOTTOM_LABEL_OPTION).isNull("color")) {
                    bottomLabelOption.put("color", option.getJSONObject(BOTTOM_LABEL_OPTION).getString("color"));
                }
                if(option.getJSONObject(BOTTOM_LABEL_OPTION).has("size") && !option.getJSONObject(BOTTOM_LABEL_OPTION).isNull("size")) {
                    bottomLabelOption.put("size", option.getJSONObject(BOTTOM_LABEL_OPTION).getInt("size"));
                }
                cameraTakeIdCardOption.put(BOTTOM_LABEL_OPTION, bottomLabelOption);
            }
            
            //Put timerOption
            final String TIMER_OPTION = "timerOption";
            if(option.has(TIMER_OPTION) && !option.isNull(TIMER_OPTION)) {
                JSONObject timerOption = new JSONObject();
                if(option.getJSONObject(TIMER_OPTION).has("backgroundColor") && !option.getJSONObject(TIMER_OPTION).isNull("backgroundColor")) {
                    timerOption.put("backgroundColor", option.getJSONObject(TIMER_OPTION).getString("backgroundColor"));
                }
                if(option.getJSONObject(TIMER_OPTION).has("numberColor") && !option.getJSONObject(TIMER_OPTION).isNull("numberColor")) {
                    timerOption.put("numberColor", option.getJSONObject(TIMER_OPTION).getString("numberColor"));
                }
                cameraTakeIdCardOption.put(TIMER_OPTION, timerOption);
            }
            
            //Put captureOption
            final String CAPTURE_OPTION = "captureOption";
            if(option.has(CAPTURE_OPTION) && !option.isNull(CAPTURE_OPTION)) {
                JSONObject captureOption = new JSONObject();
                if(option.getJSONObject(CAPTURE_OPTION).has("delay") && !option.getJSONObject(CAPTURE_OPTION).isNull("delay")) {
                    captureOption.put("delay", option.getJSONObject(CAPTURE_OPTION).getInt("delay"));
                }
                if(option.getJSONObject(CAPTURE_OPTION).has("showFlash") && !option.getJSONObject(CAPTURE_OPTION).isNull("showFlash")) {
                    captureOption.put("showFlash", option.getJSONObject(CAPTURE_OPTION).getBoolean("showFlash"));
                }
                if(option.getJSONObject(CAPTURE_OPTION).has("pathPhoto") && !option.getJSONObject(CAPTURE_OPTION).isNull("pathPhoto")) {
                    captureOption.put("pathPhoto", option.getJSONObject(CAPTURE_OPTION).getString("pathPhoto"));
                }
                cameraTakeIdCardOption.put(CAPTURE_OPTION, captureOption);
            }
            
            //Put frameOption
            final String FRAME_OPTION = "frameOption";
            if(option.has(FRAME_OPTION) && !option.isNull(FRAME_OPTION)) {
                JSONObject frameOption = new JSONObject();
                if(option.getJSONObject(FRAME_OPTION).has("size") && !option.getJSONObject(FRAME_OPTION).isNull("size")) {
                    frameOption.put("size", option.getJSONObject(FRAME_OPTION).getString("size"));
                }
                if(option.getJSONObject(FRAME_OPTION).has("color") && !option.getJSONObject(FRAME_OPTION).isNull("color")) {
                    frameOption.put("color", option.getJSONObject(FRAME_OPTION).getString("color"));
                }
                if(option.getJSONObject(FRAME_OPTION).has("content") && !option.getJSONObject(FRAME_OPTION).isNull("content")) {
                    frameOption.put("content", option.getJSONObject(FRAME_OPTION).getString("content"));
                }
                cameraTakeIdCardOption.put(FRAME_OPTION, frameOption);
            }
            
            //Put confirmButtonOption
            final String CONFIRM_BUTTON_OPTION = "confirmButtonOption";
            if(option.has(CONFIRM_BUTTON_OPTION) && !option.isNull(CONFIRM_BUTTON_OPTION)) {
                JSONObject confirmButtonOption = new JSONObject();
                if(option.getJSONObject(CONFIRM_BUTTON_OPTION).has("backgroundColor") && !option.getJSONObject(CONFIRM_BUTTON_OPTION).isNull("backgroundColor")) {
                    confirmButtonOption.put("backgroundColor", option.getJSONObject(CONFIRM_BUTTON_OPTION).getString("backgroundColor"));
                }
                if(option.getJSONObject(CONFIRM_BUTTON_OPTION).has("iconColor") && !option.getJSONObject(CONFIRM_BUTTON_OPTION).isNull("iconColor")) {
                    confirmButtonOption.put("iconColor", option.getJSONObject(CONFIRM_BUTTON_OPTION).getString("iconColor"));
                }
                cameraTakeIdCardOption.put(CONFIRM_BUTTON_OPTION, confirmButtonOption);
            }
            
            //Put retakeButtonOption
            final String RETAKE_BUTTON_OPTION = "retakeButtonOption";
            if(option.has(RETAKE_BUTTON_OPTION) && !option.isNull(RETAKE_BUTTON_OPTION)) {
                JSONObject retakeButtonOption = new JSONObject();
                if(option.getJSONObject(RETAKE_BUTTON_OPTION).has("backgroundColor") && !option.getJSONObject(RETAKE_BUTTON_OPTION).isNull("backgroundColor")) {
                    retakeButtonOption.put("backgroundColor", option.getJSONObject("retakeButtonOption").getString("backgroundColor"));
                }
                if(option.getJSONObject(RETAKE_BUTTON_OPTION).has("backgroundColor") && !option.getJSONObject(RETAKE_BUTTON_OPTION).isNull("backgroundColor")) {
                    retakeButtonOption.put("iconColor", option.getJSONObject("retakeButtonOption").getString("iconColor"));
                }
                cameraTakeIdCardOption.put("retakeButtonOption", retakeButtonOption);
            }


            ekycCamera.takeIdCard(cameraTakeIdCardOption, new PhotoListener() {
                @Override
                public void onCompleted(JSONObject result) {
                    callbackContext.success(result);
                }

                @Override
                public void onError(JSONObject error) {
                    callbackContext.error(error);
                }
            });
        } catch(JSONException e) {
            // callbackContext.error("Error JSON");
        }

        // callbackContext.success("Successfully");
    }

    private void takeSelfie(JSONObject option, CallbackContext callbackContext) {
        try {
            JSONObject cameraTakeSelfieOption = new JSONObject();

            //Put License Key
            final String LICENSE_KEY = "licenseKey";
            if(option.has(LICENSE_KEY) && !option.isNull(LICENSE_KEY)) {
                cameraTakeSelfieOption.put("licenseKey", option.getString("licenseKey"));
            }

            //Put width
            final String WIDTH = "width";
            if(option.has(WIDTH) && !option.isNull(WIDTH)) {
                cameraTakeSelfieOption.put("width", Float.parseFloat(option.get(WIDTH).toString()));
            }
            
            //Put imageQuality
            final String IMAGE_QUALITY = "imageQuality";
            if(option.has(IMAGE_QUALITY) && !option.isNull(IMAGE_QUALITY)) {
                cameraTakeSelfieOption.put(IMAGE_QUALITY, Float.parseFloat(option.get(IMAGE_QUALITY).toString()));
            }
            
            //Put outputPath
            final String OUTPUT_PATH = "outputPath";
            if(option.has(OUTPUT_PATH) && !option.isNull(OUTPUT_PATH)) {
                cameraTakeSelfieOption.put(OUTPUT_PATH, option.getString(OUTPUT_PATH));
            }
            
            //Put isFrontCamera
            final String IS_FRONT_CAMERA = "isFrontCamera";
            if(option.has(IS_FRONT_CAMERA) && !option.isNull(IS_FRONT_CAMERA)) {
                cameraTakeSelfieOption.put(IS_FRONT_CAMERA, option.getBoolean(IS_FRONT_CAMERA));
            }
            
            //Put bottomPanelColor
            final String BOTTOM_PANEL_COLOR = "bottomPanelColor";
            if(option.has(BOTTOM_PANEL_COLOR) && !option.isNull(BOTTOM_PANEL_COLOR)) {
                cameraTakeSelfieOption.put(BOTTOM_PANEL_COLOR, option.getString(BOTTOM_PANEL_COLOR));
            }
            
            //Put captureButtonColor
            final String CAPTURE_BUTTON_COLOR = "captureButtonColor";
            if(option.has(CAPTURE_BUTTON_COLOR) && !option.isNull(CAPTURE_BUTTON_COLOR)) {
                cameraTakeSelfieOption.put(CAPTURE_BUTTON_COLOR, option.getString(CAPTURE_BUTTON_COLOR));
            }
            
            //Put topLabelOption
            final String TOP_LABEL_OPTION = "topLabelOption";
            if(option.has(TOP_LABEL_OPTION) && !option.isNull(TOP_LABEL_OPTION)) {
                JSONObject topLabelOption = new JSONObject();
                if(option.getJSONObject(TOP_LABEL_OPTION).has("text") && !option.getJSONObject(TOP_LABEL_OPTION).isNull("text")) {
                    topLabelOption.put("text", option.getJSONObject(TOP_LABEL_OPTION).getString("text"));
                }
                if(option.getJSONObject(TOP_LABEL_OPTION).has("color") && !option.getJSONObject(TOP_LABEL_OPTION).isNull("color")) {
                    topLabelOption.put("color", option.getJSONObject(TOP_LABEL_OPTION).getString("color"));
                }
                if(option.getJSONObject(TOP_LABEL_OPTION).has("size") && !option.getJSONObject(TOP_LABEL_OPTION).isNull("size")) {
                    topLabelOption.put("size", option.getJSONObject(TOP_LABEL_OPTION).getInt("size"));
                }
                cameraTakeSelfieOption.put(TOP_LABEL_OPTION, topLabelOption);
            }
            
            //Put switchCameraButtonOption
            final String SWITCH_BUTTON_OPTION = "switchCameraButtonOption";
            if(option.has(SWITCH_BUTTON_OPTION) && !option.isNull(SWITCH_BUTTON_OPTION)) {
                JSONObject switchCameraButtonOption = new JSONObject();
                if(option.getJSONObject(SWITCH_BUTTON_OPTION).has("color") && !option.getJSONObject(SWITCH_BUTTON_OPTION).isNull("color")) {
                    switchCameraButtonOption.put("color", option.getJSONObject(SWITCH_BUTTON_OPTION).getString("color"));
                }
                if(option.getJSONObject(SWITCH_BUTTON_OPTION).has("isShow") && !option.getJSONObject(SWITCH_BUTTON_OPTION).isNull("isShow")) {
                    switchCameraButtonOption.put("isShow", option.getJSONObject(SWITCH_BUTTON_OPTION).getBoolean("isShow"));
                }
                cameraTakeSelfieOption.put(SWITCH_BUTTON_OPTION, switchCameraButtonOption);
            }
            
            //Put confirmButtonOption
            final String CONFIRM_BUTTON_OPTION = "confirmButtonOption";
            if(option.has(CONFIRM_BUTTON_OPTION) && !option.isNull(CONFIRM_BUTTON_OPTION)) {
                JSONObject confirmButtonOption = new JSONObject();
                if(option.getJSONObject(CONFIRM_BUTTON_OPTION).has("backgroundColor") && !option.getJSONObject(CONFIRM_BUTTON_OPTION).isNull("backgroundColor")) {
                    confirmButtonOption.put("backgroundColor", option.getJSONObject(CONFIRM_BUTTON_OPTION).getString("backgroundColor"));
                }
                if(option.getJSONObject(CONFIRM_BUTTON_OPTION).has("iconColor") && !option.getJSONObject(CONFIRM_BUTTON_OPTION).isNull("iconColor")) {
                    confirmButtonOption.put("iconColor", option.getJSONObject(CONFIRM_BUTTON_OPTION).getString("iconColor"));
                }
                cameraTakeSelfieOption.put(CONFIRM_BUTTON_OPTION, confirmButtonOption);
            }
            
            //Put retakeButtonOption
            final String RETAKE_BUTTON_OPTION = "retakeButtonOption";
            if(option.has(RETAKE_BUTTON_OPTION) && !option.isNull(RETAKE_BUTTON_OPTION)) {
                JSONObject retakeButtonOption = new JSONObject();
                if(option.getJSONObject(RETAKE_BUTTON_OPTION).has("backgroundColor") && !option.getJSONObject(RETAKE_BUTTON_OPTION).isNull("backgroundColor")) {
                    retakeButtonOption.put("backgroundColor", option.getJSONObject(RETAKE_BUTTON_OPTION).getString("backgroundColor"));
                }
                if(option.getJSONObject(RETAKE_BUTTON_OPTION).has("iconColor") && !option.getJSONObject(RETAKE_BUTTON_OPTION).isNull("iconColor")) {
                    retakeButtonOption.put("iconColor", option.getJSONObject(RETAKE_BUTTON_OPTION).getString("iconColor"));
                }
                cameraTakeSelfieOption.put(RETAKE_BUTTON_OPTION, retakeButtonOption);
            }


            ekycCamera.takeSelfie(cameraTakeSelfieOption, new PhotoListener() {
                @Override
                public void onCompleted(JSONObject result) {
                    callbackContext.success(result);
                }

                @Override
                public void onError(JSONObject error) {
                    callbackContext.error(error);
                }
            });
        } catch(JSONException e) {
            // callbackContext.error("Error JSON");
        }

        // callbackContext.success("Successfully");
    }
}
