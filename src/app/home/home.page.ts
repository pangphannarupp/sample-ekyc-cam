import { Component } from '@angular/core';

import { EkycCam } from '@awesome-cordova-plugins/ekyc-cam/ngx';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})

export class HomePage {
  licenseKey: string = 'BaFHqPuvKLymNYOl8R7kTHOIS0NmdEHQKBLtZNHw3OMwhAIrljwdkP_yuPDVuHN5';
  takeIdCardOption: any = {
    licenseKey: this.licenseKey,
    isCropped: true,//crop the frame area
    // width: null, //width to resize the image
    showFlashButton: true,//to show torch button. If set to true, it will only be shown if onFlash from captureConfig is set to false.
    // imageQuality: 1.0, //quality of the image
    showOverlay: true,//transparent black background for camera overlay
    // captureButtonColor: '#ff3783',//color of the capture button
    topLabelOption: {
      text: 'សួស្តី 안녕하세요 你好 こんにちは PPCBank',//text of the top label
      color: "#ffffff",//color of the top label
      size: 16,//text size of the top label
    },
    // bottomLabelOption: {
    //   text: 'សួស្តី',//text of the bottom label
    //   color: "#ffffff",//color of the bottom label
    //   size: 14,//text size of the bottom label
    // },
    // timerOption: {
    //   backgroundColor: '#ff8842',//background of the count down timer
    //   numberColor: "#fff842",//text color of the count down timer
    // },
    captureOption: {
      delay: 0,//countdown before capture
      showFlash: false,//enable/disable flash
      content: null, //desired output image path
    },
    // frameOption: {
    //   size: null, //size of the camera overlay frame
    //   color: "#fff842",//color of the camera overlay frame
    //   content: null, //content of the camera overlay frame (able to display vector drawable within the frame for guidance)
    // },
    // confirmButtonOption: {
    //   backgroundColor: '#ff8142',//background color of the confirm button
    //   iconColor: "#ffffff",//content color of the confirm button
    // },
    // retakeButtonOption: {
    //   backgroundColor: '#ff1042',//background color of the confirm button
    //   iconColor: "#ffffff",//content color of the confirm button
    // },
  }
  takeSelfieOption: any = {
    licenseKey: this.licenseKey,
    // width: '', //width to resize the image
    // imageQuality: 1.0, //quality of the image
    // outputPath: '', //desired output image path
    // isFrontCamera: true,//initial camera facing when the selfie camera is launched
    // bottomPanelColor: '#ffffff',//color of the bottom frame
    // captureButtonColor: '#ff7812',//color of the capture button
    topLabelOption: {
      text: 'សួស្តី 안녕하세요 你好 こんにちは PPCBank',//text of the top label
      color: "#ffffff",//color of the top label
      size: 16,//text size of the top label
    },
    // switchCameraButtonOption: {
    //   color: "#ff54ff",//color of the switch button
    //   isShow: true,//show or hide the camera switch button
    // },
    // confirmButtonOption: {
    //   backgroundColor: '#ff8142',//background color of the confirm button
    //   iconColor: "#ffffff",//content color of the confirm button
    // },
    // retakeButtonOption: {
    //   backgroundColor: '#ff1042',//background color of the confirm button
    //   iconColor: "#ffffff",//content color of the confirm button
    // },
  }

  constructor(private ekycCam: EkycCam) {}

  takeIdCard() {
    this.ekycCam.takeIdCard(this.takeIdCardOption).then(result => {
      console.log(result);
    }).catch(error => {
      console.log(error);
    });
  }

  takeSelfie() {
    this.ekycCam.takeSelfie(this.takeSelfieOption).then(result => {
      console.log(result);
    }).catch(error => {
      console.log(error);
    });
  }

}
