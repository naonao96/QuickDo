function signUp(){
	if (confirm("アカウントを登録しますか？")){
		const formData = new FormData(document.getElementById("signupForm"));
		fetch('sign-up', {
			method: "POST",
			body: formData,
		})
		.then(response => {
			if (response.ok) {
		        alert("アカウント登録が完了しました。");
		        window.location.href = "login";
		    }else{
				alert("アカウント登録に失敗しました。");
				window.location.reload();
			}
		})
	}
}
	