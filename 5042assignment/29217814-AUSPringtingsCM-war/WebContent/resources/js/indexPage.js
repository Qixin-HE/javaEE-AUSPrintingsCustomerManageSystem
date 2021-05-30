//https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_ref_js_dropdown_js&stacked=h
console.log("hi indexPage")
$(document).ready(function() {
	$(".dropdown-toggle").dropdown();
});

//sortTable(f,n)
//f : 1 ascending order, -1 descending order
//n : n-th child <!-- (<td>) of <tr> -->
+function sortTable(f, n) {
	var rows = $('#customertable tbody  tr').get();

	rows.sort(function(a, b) {

		var A = getVal(a);
		var B = getVal(b);

		//https://stackoverflow.com/questions/4338538/error-parsing-xhtml-the-content-of-elements-must-consist-of-well-formed-charact
		if (A < B) {
			return -1 * f;
		}
		if (A > B) {
			return 1 * f;
		}
		return 0;
	});
+function getVal(elm) {
		var v = $(elm).children('td').eq(Name).text().toUpperCase();
		if ($.isNumeric(v)) {
			v = parseInt(v, 10);
		}
		return v;
	}

	$.each(rows, function(index, row) {
		$('#customertable').children('tbody').append(row);
	});
}
var f_sl = 1; // flag to toggle the sorting order
var f_nm = 1; // flag to toggle the sorting order
$("#customerid").click(function() {
	console.log("hi");
	f_sl *= -1; // toggle the sorting order
	var n = $(this).prevAll().length;
	sortTable(f_sl, n);
});

$("#Name").click(function() {
	f_nm *= -1; // toggle the sorting order
	var n = $(this).prevAll().length;
	sortTable(f_nm, n);
});