function initView() {
	document.getElementById("reviewno_id").innerHTML = "编号：" + reviewno;
	document.getElementById("projectName_id").innerHTML = projectName;
	document.getElementById("taskNo_id").innerHTML = taskName;
	document.getElementById("figurename_id").innerHTML = figurename;
	document.getElementById("figureno_id").innerHTML = figureno;
	document.getElementById("checknum_id").innerHTML = checknum;
	document.getElementById("unqualifiednum_id").innerHTML = unqualifiednum;
	if("2" === unqualifiedgrade)
	{
		document.getElementById("unqualifiedgrade_id_1").checked = "checked";
		document.getElementById("unqualifiedgrade_id_2").disabled="true";
	}
	else
	{
		document.getElementById("unqualifiedgrade_id_1").disabled="true";
		document.getElementById("unqualifiedgrade_id_2").checked = "checked";
	}
	
	if(reviewrst === "1")
	{
		document.getElementById("reviewrst_id_1").checked = "checked";
		document.getElementById("reviewrst_id_2").disabled="true";
		document.getElementById("reviewrst_id_3").disabled="true";
		document.getElementById("reviewrst_id_4").disabled="true";
		document.getElementById("reviewrst_id_5").disabled="true";
		document.getElementById("reviewrst_id_6").disabled="true";
	}
	else if(reviewrst === "2")
	{
		document.getElementById("reviewrst_id_2").checked = "checked";
		document.getElementById("reviewrst_id_1").disabled="true";
		document.getElementById("reviewrst_id_3").disabled="true";
		document.getElementById("reviewrst_id_4").disabled="true";
		document.getElementById("reviewrst_id_5").disabled="true";
		document.getElementById("reviewrst_id_6").disabled="true";
	}
	else if(reviewrst === "3")
	{
		document.getElementById("reviewrst_id_3").checked = "checked";
		document.getElementById("reviewrst_id_1").disabled="true";
		document.getElementById("reviewrst_id_2").disabled="true";
		document.getElementById("reviewrst_id_4").disabled="true";
		document.getElementById("reviewrst_id_5").disabled="true";
		document.getElementById("reviewrst_id_6").disabled="true";
	}
	else if(reviewrst === "4")
	{
		document.getElementById("reviewrst_id_4").checked = "checked";
		document.getElementById("reviewrst_id_1").disabled="true";
		document.getElementById("reviewrst_id_2").disabled="true";
		document.getElementById("reviewrst_id_3").disabled="true";
		document.getElementById("reviewrst_id_5").disabled="true";
		document.getElementById("reviewrst_id_6").disabled="true";
	}
	else if(reviewrst === "5")
	{
		document.getElementById("reviewrst_id_5").checked = "checked";
		document.getElementById("reviewrst_id_1").disabled="true";
		document.getElementById("reviewrst_id_2").disabled="true";
		document.getElementById("reviewrst_id_3").disabled="true";
		document.getElementById("reviewrst_id_4").disabled="true";
		document.getElementById("reviewrst_id_6").disabled="true";
	}
	else if(reviewrst === "6")
	{
		document.getElementById("reviewrst_id_6").checked = "checked";
		document.getElementById("reviewrst_id_1").disabled="true";
		document.getElementById("reviewrst_id_2").disabled="true";
		document.getElementById("reviewrst_id_3").disabled="true";
		document.getElementById("reviewrst_id_4").disabled="true";
		document.getElementById("reviewrst_id_5").disabled="true";
	}
	
	if("1" === unqualifiedgrade)
	{
		document.getElementById("reviewgrp_id_1").checked = "checked";
		document.getElementById("reviewgrp_id_2").disabled="true";
	}
	else
	{
		document.getElementById("reviewgrp_id_2").checked = "checked";
		document.getElementById("reviewgrp_id_1").disabled="true";
	}
}

Ext.onReady(initView);

function preview() 
{ 
bdhtml=window.document.body.innerHTML; 
sprnstr="<!--startprint-->"; 
eprnstr="<!--endprint-->"; 
prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); 
prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); 
window.document.body.innerHTML=prnhtml; 
window.print();
window.close();
} 