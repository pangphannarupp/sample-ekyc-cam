var exec = require('cordova/exec');

var PLUGIN_NAME = 'EkycCam';

var EkycCam = {
    takeIdCard: function(arg, onSuccess, onFail) {
        exec(onSuccess, onFail, PLUGIN_NAME, 'takeIdCard', [arg]);
    },
    takeSelfie: function(arg, onSuccess, onFail) {
        exec(onSuccess, onFail, PLUGIN_NAME, 'takeSelfie', [arg]);
    },
}

module.exports = EkycCam;