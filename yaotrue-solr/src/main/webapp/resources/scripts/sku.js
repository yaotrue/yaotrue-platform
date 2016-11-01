$(document).ready(function(){
	$("#skuinfo-upload").uploadify({
		'uploader'        : base + '/resources/scripts/uploadify/uploadify.swf', 
		'script'          : base + '/skuUpload.json',
		'cancelImg'       : base + '/resources/scripts/uploadify/cancel.png',                  
		//'queueID'         : 'skuinfo-uploadQueue', //和存放队列的DIV的id一致 
		'fileDataName'    : 'SkuInfoData', //必须，和以下input的name属性一致                  
		'auto'            : false, //是否自动开始 
		'multi'           : false, //是否支持多文件上传 
		'buttonText'      : '浏览', //按钮上的文字 
		'simUploadLimit'  : 1, //一次同步上传的文件数目 
		'sizeLimit'       : 19871202*100, //设置单个文件大小限制，单位为byte 
		'queueSizeLimit'  : 10, //队列中同时存在的文件个数限制 
		'fileDesc'        : '支持格式:xls', //如果配置了以下的'fileExt'属性，那么这个属性是必须的  
		'fileExt'         : '*.xls',//允许的格式
        'onComplete'      : completeUploadSkuinfo
	});
	
});

//商品基本信息上传完成
function completeUploadSkuinfo(event, queueID, fileObj, response, data) {
	if(response){
		var result = eval('('+response+')');
		if(result.flag){
			showInfo('#upload-skuinfo-result','成功上传 ' + result.fileName, true); //showInfo方法设置上传结果     
			hideErrorMessage('#upload-skuinfo-message');
		}else{
			showInfo('#upload-skuinfo-result',"文件上传出错 ," + result.msg, false);
		}
	}
}
//显示提示信息，textstyle2为绿色，即正确信息；textstyl1为红色，即错误信息
function showInfo(id, msg, type) {
    var msgClass = type == true ? "textstyle2" : "textstyle1";
    $(id).removeClass();
    $(id).addClass(msgClass);
    $(id).html(msg);
}
//显示错误信息框
function showErrorMessage(id, message){
	$(id).html(message);
	$(id).css("display","block");
}
//隐藏错误消息框
function hideErrorMessage(id){
	$(id).css("display","none");
}
//如果点击‘导入文件’时选择文件为空，则提示
function checkImport(id) {
    if ($.trim($(id).html()) == "") {
        alert('请先选择要导入的文件！');
        return false;
    }
    return true;
} 

