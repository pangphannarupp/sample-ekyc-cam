import { Component } from '@angular/core';

import { EkycCam } from '@awesome-cordova-plugins/ekyc-cam/ngx';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  // win: any = window;
  licenseKey: string = 'BaFHqPuvKLymNYOl8R7kTHOIS0NmdEHQKBLtZNHw3OMwhAIrljwdkP_yuPDVuHN5';

  constructor(private ekycCam: EkycCam) {}

  takeIdCard() {
    this.ekycCam.takeIdCard({
      licenseKey: this.licenseKey,
      isCropped: true,
      // width: null, //not require
      showFlashButton: true,
      // imageQuality: 1.0, //not require
      showOverlay: true,
      // captureButtonColor: '#ff3783',
      topLabelOption: {
        text: 'សួស្តី 안녕하세요 你好 こんにちは PPCBank',
        color: "#ffffff",
        size: 16,
      },
      // bottomLabelOption: {
      //   text: 'សួស្តី',
      //   color: "#ffffff",
      //   size: 14,
      // },
      // timerOption: {
      //   backgroundColor: '#ff8842',
      //   numberColor: "#fff842",
      // },
      captureOption: {
        delay: 0,
        showFlash: false,
        content: null, //not require
      },
      // frameOption: {
      //   size: null, //not require
      //   color: "#fff842",
      //   content: null, //not require
      // },
      // confirmButtonOption: {
      //   backgroundColor: '#ff8142',
      //   iconColor: "#ffffff",
      // },
      // retakeButtonOption: {
      //   backgroundColor: '#ff1042',
      //   iconColor: "#ffffff",
      // },
    }).then(result => {
      console.log(result);
    }).catch(error => {
      console.log(error);
    });
  }

  takeSelfie() {
    this.ekycCam.takeSelfie({
      licenseKey: this.licenseKey,
      // width: '', //not require
      // imageQuality: 1.0, //not require
      // outputPath: '', //not require
      // isFrontCamera: true,
      // bottomPanelColor: '#ffffff',
      // captureButtonColor: '#ff7812',
      topLabelOption: {
        text: 'សួស្តី 안녕하세요 你好 こんにちは PPCBank',
        color: "#ffffff",
        size: 16,
      },
      // switchCameraButtonOption: {
      //   color: "#ff54ff",
      //   isShow: true,
      // },
      // confirmButtonOption: {
      //   backgroundColor: '#ff8142',
      //   iconColor: "#ffffff",
      // },
      // retakeButtonOption: {
      //   backgroundColor: '#ff1042',
      //   iconColor: "#ffffff",
      // },
    }).then(result => {
      console.log(result);
    }).catch(error => {
      console.log(error);
    });
  }

}
