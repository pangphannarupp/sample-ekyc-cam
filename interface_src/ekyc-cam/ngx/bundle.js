'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var tslib = require('tslib');
var core$1 = require('@angular/core');
var core = require('@awesome-cordova-plugins/core');

var EkycCam = /** @class */ (function (_super) {
    tslib.__extends(EkycCam, _super);
    function EkycCam() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    EkycCam.prototype.takeIdCard = function (arg) { return core.cordova(this, "takeIdCard", {}, arguments); };
    EkycCam.prototype.takeSelfie = function (arg) { return core.cordova(this, "takeSelfie", {}, arguments); };
    EkycCam.pluginName = "EkycCam";
    EkycCam.plugin = "mcnc-plugin-ekyc-cam";
    EkycCam.pluginRef = "EkycCam";
    EkycCam.repo = "";
    EkycCam.install = "";
    EkycCam.installVariables = [];
    EkycCam.platforms = ["Android", "iOS"];
    EkycCam.decorators = [
        { type: core$1.Injectable }
    ];
    return EkycCam;
}(core.AwesomeCordovaNativePlugin));

exports.EkycCam = EkycCam;
