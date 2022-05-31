$('#loginButton').hover(function(){
//マウスカーソルが乗った時
$('#loginButton').css('background','#b0bec5');
},
function(){
//マウスカーソルが外れた時
$('#loginButton').css('background','#5c6bc0');
});

//ユーザー名、PWが入力されていないときのエラーメッセージ
function input_check() {
	if($('.ID').val() === ''){
		document.getElementById('error').textContent = 'ユーザー名を入力してください';
		$('.ID').toggleClass('idError');
		return false;
	}else if($('.PW').val() === ''){
		document.getElementById('error').textContent = 'パスワードを入力してください';
		$('.PW').toggleClass('idError');
		return false;
	}else{
		return true;
	}
}

//テキストボックスに入力したら発動
$(function() {
	$(document).on('input', '.ID', function() {
		console.log(this.value);
		$.ajax({
		  url: "./testAjax",
		  type: "POST",
		  cache: true,
		  dataType: "json",
		  data:{"ID":this.value},
		  success: function(data, textStatus){
			if(data){
				$('#output').html("存在するユーザーです");
			}else{
				$('#output').html("存在しないユーザーです");
			}
		  },
		  error: function(xhr, textStatus, errorThrown){
		    $('#output').html("接続エラー");
		  }
		});
	});
});