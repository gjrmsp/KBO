/**
 * 
 */

$("#all").click(function(){
	let check = $("#all").prop("checked");
	$(".check").prop("checked", check);
});

$(".check").click(function(){
	let result = true;

	$(".check").each(function(){
		if(!$(this).prop("checked")){
			result = false;
		}
	});

	$("#all").prop("checked", result);
});


$("#btn").click(function() {
	let result = $("#all").prop("checked");
	if(result) {
		location.href="./memberJoin";
	} else {
		alert("약관에 동의");
	}
});