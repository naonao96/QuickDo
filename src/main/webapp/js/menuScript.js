function logout(){
	
	if (confirm("ログアウトしますがよろしいですか？"))
	fetch('logout',{
		method: "POST",
	})
	.then(response => {
		if (response.ok){
			window.location.reload();
		}
		else{
			alert("正常にログアウトできませんでした")
		}
		
	})
}