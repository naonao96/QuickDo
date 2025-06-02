// アカウント登録フォームの送信イベントを監視
document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("signupForm").addEventListener("submit", function(event){
		event.preventDefault();
		signUp();
	})
});

//アカウント登録確認および登録完了確認を行う
async function signUp(){
	if (!confirm("アカウントを登録しますか？"))
		return;
	
	try {
		const jsonSignUpData = 
		{
			"name": document.getElementById("name").value,
			"mail": document.getElementById("mail").value,
			"password": document.getElementById("password").value
		}

		const response = await fetch('sign-up', {
			method: "POST",
			headers: {"Content-Type": "application/json"},
			body: JSON.stringify(jsonSignUpData)
		})

		const resJson = await response.json();
		alert(resJson.message);

		if (response.status === 200) {
			window.location.href = "login";
		}else {
			window.location.reload();
		}
	}catch(error){
		alert("エラーが発生しました。もう一度お試しください。");
		console.error("Error:", error);
	}
}
	