/**
 * 
 */

let frm = document.getElementById("frm");
let writer = document.getElementById("writer");
let title = document.getElementById("title");
let btn = document.getElementById("btn");

btn.addEventListener("click", function() {
	let check1 = writer.value == 'admin';
	let check2 = title.value != "";

	if(check1 && check2) {
		frm.submit();
	} else {
		alert("입력 항목을 확인하세요");
	}
});