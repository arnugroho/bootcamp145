var processDialog;
processDialog = processDialog || (function () {
    var pleaseWaitDiv = $('<div class="modal" id="pleaseWaitDialog" style="z-index:9000" data-backdrop="static" data-keyboard="false"><div class="modal-dialog" id="pleaseWaitModalDialog"><div class="modal-content"><div class="modal-header">Processing...</div><div class="modal-body"><div class="progress progress-striped active"><div id="progress-bar" class="progress-bar progress-bar-success" style="width: 100%"></div></div></div></div></div></div>');

    return {
        showPleaseWait: function() {
            pleaseWaitDiv.modal('show');
            $('#pleaseWaitDialog').css("margin-top", Math.max(0, ($(window).height() - $('#pleaseWaitModalDialog').height()) / 2));
        },
        hidePleaseWait: function () {
            pleaseWaitDiv.modal('hide');
        },

    };
})();

function logout() {
	window.location=contextName+'/j_spring_security_logout';
}

function openlink(m,u) {
	if (u.indexOf('javascript')<0) window.location=u;
}

function setSuccessStatus(message) {
	notifySuccess(message);
}
function setFailStatus(message) {
	notifyError(message);
}
function notifySuccess(message) {
	new PNotify({
		title: 'Success',
		text: message,
		delay: 3000,
		type: 'success',
		styling: 'bootstrap3'
	});
}

function notifyError(message) {
	new PNotify({
		title: 'Error',
		text: message,
		delay: 3000,
		type: 'error',
		styling: 'bootstrap3'
	});
}

function notifyInfo(message) {
	new PNotify({
		title: 'Info',
		text: message,
		delay: 3000,
		type: 'info',
		styling: 'bootstrap3'
	});
}

function notifyWarning(message) {
	new PNotify({
		title: 'Warning',
		text: message,
		delay: 3000,		
		styling: 'bootstrap3'
	});
}

function getJsonForm(jsonArray, isAllowedNull) {
	result = {};
	jsonArray.forEach(function(element) {
		value = element.value;
		if (value == "" && isAllowedNull) {
			value = null;
		}
		result[element.name] = value;
	})
	
	return JSON.stringify(result)
}

$(function(){
	$(".yearpicker").datepicker({
		autoclose : true,
	    format : 'yyyy',
	    orientation : 'top',
	    gotoCurrent : true,
	    viewMode : 'years',
	    minViewMode :'years'
	});
	
	$(".datepicker").datepicker({
		autoclose : true,
		format:'yyyy-mm-dd',
		language:'id',
		startView: 2,
		zIndexOffset:999
	});
});
