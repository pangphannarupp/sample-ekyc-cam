import { AwesomeCordovaNativePlugin } from '@awesome-cordova-plugins/core';
/**
 * @name Ekyc Cam
 * @description
 * This plugin does something
 *
 * @usage
 * ```typescript
 * import { EkycCam } from '@awesome-cordova-plugins/ekyc-cam';
 *
 *
 * constructor(private ekycCam: EkycCam) { }
 *
 * ...
 *
 *
 * this.ekycCam.functionName('Hello', 123)
 *   .then((res: any) => console.log(res))
 *   .catch((error: any) => console.error(error));
 *
 * ```
 */
export declare class EkycCam extends AwesomeCordovaNativePlugin {
    /**
     * This function does something
     * @param arg {JSONObject} Some param to configure something
     * @return {Promise<any>} Returns a promise that resolves when something happens
     */
    takeIdCard(arg: any): Promise<any>;
    /**
     * This function does something
     * @param arg {JSONObject} Some param to configure something
     * @return {Promise<any>} Returns a promise that resolves when something happens
     */
    takeSelfie(arg: any): Promise<any>;
}
