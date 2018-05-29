window.onload=function(){
    document.getElementById("autoclicked").hidden=true;
    GetData();
};



function readData()
{
    
	var qid=document.getElementById('qid').value;
    var query=document.getElementById('query').value;
    
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("autoclicked").click();
            document.getElementById('qid').value="";
            document.getElementById('query').value="";
        }
      };

    var url = "newQuery?qid="+qid+"&&query="+query;
    xhttp.open("GET",url,true);

    xhttp.send();  
    
}

function GetData()
{
    var data;

    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var data_string=this.responseText;
            data = JSON.parse(data_string);
            renderDataView(data);
        }
      };

    var url = "queries";
    xhttp.open("GET",url,true);
    xhttp.send();    
}

function renderDataView(data)
{
    var code_view="";

    data.forEach(entry => {
        code_view = code_view+"<div class='jumbotron'><h4>"+entry.Query_id+"</h4><hr>"+entry.Query+"</div>";
    });

    document.getElementById("showData").innerHTML=code_view;
}
